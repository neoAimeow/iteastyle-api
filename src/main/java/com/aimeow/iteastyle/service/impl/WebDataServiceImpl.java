package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.base.domain.BaseQuery;
import com.aimeow.iteastyle.base.domain.BaseResult;
import com.aimeow.iteastyle.base.tools.CommonConverter;
import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;


import com.aimeow.iteastyle.domain.DomainObject.*;
import com.aimeow.iteastyle.domain.ViewObject.*;
import com.aimeow.iteastyle.domain.ViewObject.Case.GetCasesVO;
import com.aimeow.iteastyle.domain.ViewObject.Case.CaseTypeVO;
import com.aimeow.iteastyle.domain.ViewObject.Case.CaseBaseVO;
import com.aimeow.iteastyle.domain.ViewObject.Case.CasesInTypeVO;
import com.aimeow.iteastyle.domain.enums.StatusEnum;
import com.aimeow.iteastyle.domain.query.CaseQuery;
import com.aimeow.iteastyle.domain.query.PostQuery;
import com.aimeow.iteastyle.service.WebDataService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WebDataServiceImpl implements WebDataService {
    @Autowired private CommonDAO commonDAO;
    @Autowired private CommonData commonData;

    @Override
    public BaseResult<HomePageVO> getHomePageData() {
        BaseResult<HomePageVO> result = new BaseResult<>();
        try {
            StaticDataDO staticDataDO = commonData.getData(StaticDataDO.class);
            HomePageVO homePageVO = new HomePageVO();
            result.setModel(homePageVO);
            homePageVO.setHeaderImages(staticDataDO.getHomepageBannerUrls());
            homePageVO.setShowerImages(staticDataDO.getHomepageShowerImageUrls());
            homePageVO.setServiceImages(staticDataDO.getHomepageServiceImageUrls());
            homePageVO.setServiceWapInfos(staticDataDO.getHomepageServiceWapInfos());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public BaseResult<CompanyStoryVO> getCompanyStory() {
        BaseResult<CompanyStoryVO> result = new BaseResult<>();
        CompanyStoryVO companyStoryVO = new CompanyStoryVO();
        result.setModel(companyStoryVO);
        try {
            CompanyInfoDO companyInfoDO = commonData.getData(CompanyInfoDO.class);
            StaticDataDO staticDataDO = commonData.getData(StaticDataDO.class);

            companyStoryVO.setBackgroundImageUrl(staticDataDO.getCompanyStoryBgUrl());
            companyStoryVO.setVideoUrl(companyInfoDO.getVideoUrl());
            companyStoryVO.setStoryTitle(companyInfoDO.getStoryTitle());
            companyStoryVO.setStoryContent(companyInfoDO.getStory());

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<ContactUsVO> getContactUsData() {
        BaseResult<ContactUsVO> result = new BaseResult<>();
        ContactUsVO contactUsVO = new ContactUsVO();
        result.setModel(contactUsVO);
        try {
            CompanyInfoDO companyInfoDO = commonData.getData(CompanyInfoDO.class);
            StaticDataDO staticDataDO = commonData.getData(StaticDataDO.class);

            contactUsVO.setCompanyAddress(companyInfoDO.getCompanyAddress());
            contactUsVO.setCompanyName(companyInfoDO.getCompanyName());
            contactUsVO.setContactUsBackgroundImage(staticDataDO.getContactUsBgUrl());
            contactUsVO.setLatitude(companyInfoDO.getLatitude());
            contactUsVO.setLongitude(companyInfoDO.getLongitude());
            contactUsVO.setMailAddress(companyInfoDO.getMail());
            contactUsVO.setPhoneNumber(companyInfoDO.getPhoneNumber());
            contactUsVO.setTelephoneNumber(companyInfoDO.getTelephoneNumber());
            contactUsVO.setSiteAddress(companyInfoDO.getWebUrl());
            contactUsVO.setContactUsTitle(staticDataDO.getContactUsTitle());

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }


        return result;
    }

    @Override
    public BaseResult<GetPostsVO> getPosts(
            Integer page, Integer pageSize) {
        BaseResult<GetPostsVO> result = new BaseResult<GetPostsVO>();
        GetPostsVO getPostsVO = new GetPostsVO();
        try {
            StaticDataDO staticDataDO = commonData.getData(StaticDataDO.class);
            getPostsVO.setPostBackgroundImage(staticDataDO.getPostBgUrl());
            getPostsVO.setPage(page);
            getPostsVO.setPageSize(pageSize);

            PostQuery postQuery = new PostQuery();
            postQuery.setPageSize(pageSize);
            postQuery.setPage(page);
            postQuery.setStatus(StatusEnum.NORMAL.getStatus());

            List<PostVO> postVos = new ArrayList();
            List<PostDO> postDOS = commonDAO.queryList(postQuery , PostDO.class);

            postDOS.iterator().forEachRemaining(
                    obj-> {
                        postVos.add(CommonConverter.convert(obj , PostVO.class));
                    }
            );
            getPostsVO.setTotalCount(commonDAO.count(postQuery , PostDO.class));

            getPostsVO.setPosts(postVos);
            result.setModel(getPostsVO);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<PostVO> getPostByPostId(
            @NonNull String postId) {
        BaseResult<PostVO> result = new BaseResult<>();
        try {
            result.setModel(CommonConverter.convert(commonDAO.queryById(postId , PostDO.class) , PostVO.class));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<List<CaseTypeVO>> getCaseTypes() {
        BaseResult<List<CaseTypeVO>> result = new BaseResult<>();
        try {
            List<CaseTypeVO> caseTypeVOS = new ArrayList<>();

            List<CaseTypeDO> caseTypeDOS = commonDAO.queryAllList(CaseTypeDO.class);
            caseTypeDOS.iterator().forEachRemaining(
                    obj-> {
                        caseTypeVOS.add(CommonConverter.convert(obj , CaseTypeVO.class));
                    }
            );
            result.setModel(caseTypeVOS);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<CaseBaseVO> getCaseById(
            @NonNull String caseId) {
        BaseResult<CaseBaseVO> result = new BaseResult<>();

        try {
            CaseDO caseDO = commonDAO.queryById(caseId , CaseDO.class);
            CaseBaseVO caseBaseVO = CommonConverter.convert(caseDO, CaseBaseVO.class);

            Map<String, Object> map = new HashMap<>();
            map.put("type" , caseBaseVO.getType());
            List<CaseTypeDO> caseTypeDOS = commonDAO.queryByParam(map, CaseTypeDO.class);
            if (caseTypeDOS.size()>0) {
                caseBaseVO.setTypeName(caseTypeDOS.get(0).getTypeName());
            }
            result.setModel(caseBaseVO);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<GetCasesVO> getCaseByType(
            @NonNull Integer type , Integer page, Integer pageSize) {
        BaseResult<GetCasesVO> result = new BaseResult<>();
        GetCasesVO getCasesVO = new GetCasesVO();
        try {
            getCasesVO.setPage(page);
            getCasesVO.setPageSize(pageSize);

            CaseQuery caseQuery = new CaseQuery();
            caseQuery.setType(type);
            caseQuery.setPage(page);
            caseQuery.setPageSize(pageSize);

            getCasesVO.setTotalCount(commonDAO.count(caseQuery, CaseDO.class));

            CasesInTypeVO casesInTypeVO = new CasesInTypeVO();
            List<CaseBaseVO> caseBaseVOS = new ArrayList<>();
            casesInTypeVO.setCases(caseBaseVOS);

            Map<String, Object> map = new HashMap<>();
            map.put("type" , type);
            List<CaseTypeDO> caseTypeDOS = commonDAO.queryByParam(map, CaseTypeDO.class);
            if (caseTypeDOS.size()>0) {
                CaseTypeVO caseTypeVO = CommonConverter.convert(caseTypeDOS.get(0),CaseTypeVO.class);
                casesInTypeVO.setCaseType(caseTypeVO);
            }

            List<CaseDO> caseDOS = commonDAO.queryList(caseQuery, CaseDO.class);
            caseDOS.iterator().forEachRemaining(
                    obj-> {
                        CaseBaseVO caseBaseVO = CommonConverter.convert(obj , CaseBaseVO.class);
                        caseBaseVO.setTypeName(casesInTypeVO.getCaseType().getTypeName());
                        caseBaseVOS.add(caseBaseVO);
                    }
            );


            getCasesVO.setModel(casesInTypeVO);
            result.setModel(getCasesVO);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<List<CasesInTypeVO>> getCasesHomeData() {
        BaseResult<List<CasesInTypeVO>> result = new BaseResult<>();
        List<CasesInTypeVO> casesInTypeVOS = new ArrayList<>();
        try {
            List<CaseTypeVO> caseTypeVOS = new ArrayList<>();
            List<CaseBaseVO> caseBaseVOS = new ArrayList<>();
            List<CaseDO> caseDOS = commonDAO.queryList(
                new BaseQuery() , CaseDO.class);
            List<CaseTypeDO> caseTypeDOS = commonDAO.queryList(
                new BaseQuery() , CaseTypeDO.class);

            for (CaseDO caseDO: caseDOS) {
                caseBaseVOS.add(CommonConverter.convert( caseDO , CaseBaseVO.class));
            }

            for (CaseTypeDO caseTypeDO: caseTypeDOS) {
                CaseTypeVO caseTypeVO = CommonConverter.convert(caseTypeDO , CaseTypeVO.class);
                caseTypeVOS.add(caseTypeVO);

                CasesInTypeVO casesInTypeVO = new CasesInTypeVO();
                casesInTypeVO.setCaseType(caseTypeVO);
                casesInTypeVOS.add(casesInTypeVO);
            }

            for (CasesInTypeVO casesInTypeVO:casesInTypeVOS) {
                for (CaseBaseVO caseBaseVO: caseBaseVOS) {
                    if (caseBaseVO.getType().equals(casesInTypeVO.getCaseType().getType())) {
                        caseBaseVO.setTypeName(casesInTypeVO.getCaseType().getTypeName());
                        if (casesInTypeVO.getCases() == null) {
                            casesInTypeVO.setCases(new ArrayList<>());
                        }
                        casesInTypeVO.getCases().add(caseBaseVO);
                    }
                }
            }

            result.setModel(casesInTypeVOS);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }
}
