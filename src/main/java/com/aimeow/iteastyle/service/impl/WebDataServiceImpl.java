package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.base.domain.BaseQuery;
import com.aimeow.iteastyle.base.domain.BaseResult;
import com.aimeow.iteastyle.base.tools.CommonConverter;
import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;


import com.aimeow.iteastyle.domain.DomainObject.*;
import com.aimeow.iteastyle.domain.ViewObject.*;
import com.aimeow.iteastyle.domain.enums.StatusEnum;
import com.aimeow.iteastyle.domain.query.CaseQuery;
import com.aimeow.iteastyle.domain.query.PostQuery;
import com.aimeow.iteastyle.domain.query.ProductShowerQuery;
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
    public BaseResult<GetProductShowersVO> getProductShowerList(
            Integer page, Integer pageSize) {
        BaseResult<GetProductShowersVO> result = new BaseResult<>();
        GetProductShowersVO getProductShowersVO = new GetProductShowersVO();
        result.setModel(getProductShowersVO);
        List<ProductShowerVO> productShowerVOS = new ArrayList<>();
        try {
            StaticDataDO staticDataDO = commonData.getData(StaticDataDO.class);

            getProductShowersVO.setHeaderImageUrl(staticDataDO.getProductShowerHeaderUrl());
            getProductShowersVO.setPage(page);
            getProductShowersVO.setPageSize(pageSize);

            ProductShowerQuery query = new ProductShowerQuery();
            query.setPage(page);
            query.setPageSize(pageSize);
            query.setStatus(StatusEnum.NORMAL.getStatus());

            getProductShowersVO.setTotalCount(
                    commonDAO.count(query , ProductShowerDO.class)
            );
            List<ProductShowerDO> productShowerDOS = commonDAO.queryList(query , ProductShowerDO.class);

            productShowerDOS.iterator().forEachRemaining(
                    obj-> {
                        productShowerVOS.add(CommonConverter.convert(obj , ProductShowerVO.class));
                    }
            );
            getProductShowersVO.setProducts(productShowerVOS);


        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<ProductShowerVO> getProductShowerDetail(@NonNull String productShowerId) {
        BaseResult<ProductShowerVO> result = new BaseResult<>();

        try {
            ProductShowerDO productShowerDO = commonDAO.queryById(productShowerId , ProductShowerDO.class);
            result.setModel(CommonConverter.convert(productShowerDO , ProductShowerVO.class));
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

            List<CaseTypeDO> caseTypeDOS = commonDAO.queryList(new BaseQuery(), CaseTypeDO.class);
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
    public BaseResult<CaseVO> getCaseById(
            @NonNull String caseId) {
        BaseResult<CaseVO> result = new BaseResult<>();

        try {
            CaseDO caseDO = commonDAO.queryById(caseId , CaseDO.class);
            CaseVO caseVO = CommonConverter.convert(caseDO , CaseVO.class);

            Map<String, String> map = new HashMap<>();
            map.put("type" , caseVO.getType().toString());
            List<CaseTypeDO> caseTypeDOS = commonDAO.queryByParam(map, CaseTypeDO.class);
            if (caseTypeDOS.size()>0) {
                caseVO.setTypeName(caseTypeDOS.get(0).getTypeName());
            }
            result.setModel(caseVO);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<GetCasesVO> getCases(
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

            getCasesVO.setTotalCount(commonDAO.count(caseQuery , CaseDO.class));
            List<CaseVO> caseVOS = new ArrayList<>();

            List<CaseDO> caseDOS = commonDAO.queryList(caseQuery , CaseDO.class);
            caseDOS.iterator().forEachRemaining(
                    obj-> {
                        caseVOS.add(CommonConverter.convert(obj , CaseVO.class));
                    }
            );
            getCasesVO.setCases(caseVOS);
            result.setModel(getCasesVO);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }
}
