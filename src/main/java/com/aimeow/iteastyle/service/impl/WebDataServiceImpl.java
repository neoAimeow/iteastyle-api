package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.base.domain.BaseQuery;
import com.aimeow.iteastyle.base.domain.BaseResult;
import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;


import com.aimeow.iteastyle.domain.ViewObject.*;
import com.aimeow.iteastyle.domain.ViewObject.Case.CasesInTypeVO;
import com.aimeow.iteastyle.domain.entity.*;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.TeaBreakServiceEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.TeaGiftServiceEntity;
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
            StaticDataEntity staticDataDO = commonData.getData(StaticDataEntity.class);
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
            CompanyInfoEntity companyInfoDO = commonData.getData(CompanyInfoEntity.class);
            StaticDataEntity staticDataDO = commonData.getData(StaticDataEntity.class);

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
            CompanyInfoEntity companyInfoDO = commonData.getData(CompanyInfoEntity.class);
            StaticDataEntity staticDataDO = commonData.getData(StaticDataEntity.class);

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
    public BaseResult<GetItemsVO> getPosts(
            Integer page, Integer pageSize) {
        BaseResult<GetItemsVO> result = new BaseResult<GetItemsVO>();
        GetItemsVO getItemsVO = new GetItemsVO();
        try {
            getItemsVO.setPage(page);
            getItemsVO.setPageSize(pageSize);

            PostQuery postQuery = new PostQuery();
            postQuery.setPageSize(pageSize);
            postQuery.setPage(page);
            postQuery.setStatus(StatusEnum.NORMAL.getStatus());

            List<PostEntity> postEntities = commonDAO.queryList(postQuery , PostEntity.class);
            getItemsVO.setTotalCount(commonDAO.count(postQuery , PostEntity.class));
            getItemsVO.setItems(postEntities);
            result.setModel(getItemsVO);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<PostEntity> getPostByPostId(
            @NonNull String postId) {
        BaseResult<PostEntity> result = new BaseResult<>();
        try {
            result.setModel(commonDAO.queryById(postId , PostEntity.class));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<List<CaseTypeEntity>> getCaseTypes() {
        BaseResult<List<CaseTypeEntity>> result = new BaseResult<>();
        try {

            List<CaseTypeEntity> caseTypeEntities = commonDAO.queryAllList(CaseTypeEntity.class);
            result.setModel(caseTypeEntities);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<CaseEntity> getCaseById(
            @NonNull String caseId) {
        BaseResult<CaseEntity> result = new BaseResult<>();

        try {
            CaseEntity caseEntity = commonDAO.queryById(caseId , CaseEntity.class);

            Map<String, Object> map = new HashMap<>();
            map.put("type" , caseEntity.getType());
            List<CaseTypeEntity> caseTypeEntities = commonDAO.queryByParam(map, CaseTypeEntity.class);
            if (caseTypeEntities.size()>0) {
                caseEntity.setTypeName(caseTypeEntities.get(0).getTypeName());
            }
            result.setModel(caseEntity);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<GetItemsVO> getCaseByType(
            @NonNull Integer type , Integer page, Integer pageSize) {
        BaseResult<GetItemsVO> result = new BaseResult<>();
        GetItemsVO getItemsVO = new GetItemsVO();
        try {
            getItemsVO.setPage(page);
            getItemsVO.setPageSize(pageSize);

            CaseQuery caseQuery = new CaseQuery();
            caseQuery.setType(type);
            caseQuery.setPage(page);
            caseQuery.setPageSize(pageSize);

            getItemsVO.setTotalCount(commonDAO.count(caseQuery, CaseEntity.class));

            CasesInTypeVO casesInTypeVO = new CasesInTypeVO();
            List<CaseEntity> caseBaseVOS = new ArrayList<>();
            casesInTypeVO.setCases(caseBaseVOS);

            Map<String, Object> map = new HashMap<>();
            map.put("type" , type);
            List<CaseTypeEntity> caseTypeEntities = commonDAO.queryByParam(map, CaseTypeEntity.class);
            if (caseTypeEntities.size()>0) {
                CaseTypeEntity caseTypeVO = caseTypeEntities.get(0);
                casesInTypeVO.setCaseType(caseTypeVO);
            }

            List<CaseEntity> caseEntities = commonDAO.queryList(caseQuery, CaseEntity.class);
            caseEntities.iterator().forEachRemaining(
                    obj-> {
                        CaseEntity caseBaseVO = obj;
                        caseBaseVO.setTypeName(casesInTypeVO.getCaseType().getTypeName());
                        caseBaseVOS.add(caseBaseVO);
                    }
            );


            getItemsVO.setItems(casesInTypeVO);
            result.setModel(getItemsVO);
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
            List<CaseTypeEntity> caseTypeVOS = new ArrayList<>();
            List<CaseEntity> caseBaseVOS = new ArrayList<>();
            List<CaseEntity> caseEntities = commonDAO.queryList(
                new BaseQuery() , CaseEntity.class);
            List<CaseTypeEntity> caseTypeEntities = commonDAO.queryList(
                new BaseQuery() , CaseTypeEntity.class);

            for (CaseEntity caseEntity : caseEntities) {
                caseBaseVOS.add(caseEntity);
            }

            for (CaseTypeEntity caseTypeEntity : caseTypeEntities) {
                caseTypeVOS.add(caseTypeEntity);

                CasesInTypeVO casesInTypeVO = new CasesInTypeVO();
                casesInTypeVO.setCaseType(caseTypeEntity);
                casesInTypeVOS.add(casesInTypeVO);
            }

            for (CasesInTypeVO casesInTypeVO:casesInTypeVOS) {
                for (CaseEntity caseBaseVO: caseBaseVOS) {
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

    @Override
    public BaseResult<TeaBreakServiceEntity> getTeaBreakService() {
        BaseResult<TeaBreakServiceEntity> result = new BaseResult<>();
        try {
            TeaBreakServiceEntity teaBreakServiceEntity = commonData.getData(TeaBreakServiceEntity.class);
            result.setModel(teaBreakServiceEntity);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<TeaGiftServiceEntity> getTeaGiftService() {
        BaseResult<TeaGiftServiceEntity> result = new BaseResult<>();
        try {
            TeaGiftServiceEntity teaGiftServiceEntity = commonData.getData(TeaGiftServiceEntity.class);
            result.setModel(teaGiftServiceEntity);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }
}
