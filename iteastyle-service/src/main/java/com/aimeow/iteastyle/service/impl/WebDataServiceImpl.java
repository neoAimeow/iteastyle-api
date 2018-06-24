package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.converter.PostConverter;
import com.aimeow.iteastyle.converter.ProductShowerConverter;
import com.aimeow.iteastyle.domain.*;
import com.aimeow.iteastyle.domain.enums.StatusEnum;
import com.aimeow.iteastyle.manager.CompanyInfoManager;
import com.aimeow.iteastyle.manager.PostManager;
import com.aimeow.iteastyle.manager.ProductShowerManager;
import com.aimeow.iteastyle.manager.StaticDataManager;
import com.aimeow.iteastyle.service.WebDataService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebDataServiceImpl implements WebDataService {
    @Autowired private StaticDataManager staticDataManager;
    @Autowired private CompanyInfoManager companyInfoManager;
    @Autowired private ProductShowerManager productShowerManager;
    @Autowired private PostManager postManager;

    @Override
    public Result<HomePageVO> getHomePageData() {
        Result<HomePageVO> result = new Result<>();
        try {
            StaticDataBO staticDataBO = staticDataManager.getStaticData().getModel();
            HomePageVO homePageVO = new HomePageVO();
            result.setModel(homePageVO);
            homePageVO.setHeaderImages(staticDataBO.getHomepageBannerUrls());
            homePageVO.setShowerImages(staticDataBO.getHomepageShowerImageUrls());
            homePageVO.setServiceImages(staticDataBO.getHomepageServiceImageUrls());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<CompanyStoryVO> getCompanyStory() {
        Result<CompanyStoryVO> result = new Result<>();
        CompanyStoryVO companyStoryVO = new CompanyStoryVO();
        result.setModel(companyStoryVO);
        try {
            CompanyInfoBO companyInfoBO = companyInfoManager.getCompanyInfo().getModel();
            StaticDataBO staticDataBO = staticDataManager.getStaticData().getModel();

            companyStoryVO.setBackgroundImageUrl(staticDataBO.getCompanyStoryBgUrl());
            companyStoryVO.setVideoUrl(companyInfoBO.getVideoUrl());
            companyStoryVO.setStoryTitle(companyInfoBO.getStoryTitle());
            companyStoryVO.setStoryContent(companyInfoBO.getStory());

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<ContactUsVO> getContactUsData() {
        Result<ContactUsVO> result = new Result<>();
        ContactUsVO contactUsVO = new ContactUsVO();
        result.setModel(contactUsVO);
        try {
            CompanyInfoBO companyInfoBO = companyInfoManager.getCompanyInfo().getModel();
            StaticDataBO staticDataBO = staticDataManager.getStaticData().getModel();
            contactUsVO.setCompanyAddress(companyInfoBO.getCompanyAddress());
            contactUsVO.setCompanyName(companyInfoBO.getCompanyName());
            contactUsVO.setContactUsBackgroundImage(staticDataBO.getContactUsBgUrl());
            contactUsVO.setLatitude(companyInfoBO.getLatitude());
            contactUsVO.setLongitude(companyInfoBO.getLongitude());
            contactUsVO.setMailAddress(companyInfoBO.getMail());
            contactUsVO.setPhoneNumber(companyInfoBO.getPhoneNumber());
            contactUsVO.setTelephoneNumber(companyInfoBO.getTelephoneNumber());
            contactUsVO.setSiteAddress(companyInfoBO.getWebUrl());
            contactUsVO.setContactUsTitle(staticDataBO.getContactUsTitle());

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }


        return result;
    }

    @Override
    public Result<GetProductShowersVO> getProductShowerList(
            Integer page, Integer pageSize) {
        Result<GetProductShowersVO> result = new Result<>();
        GetProductShowersVO getProductShowersVO = new GetProductShowersVO();
        result.setModel(getProductShowersVO);
        List<ProductShowerVO> productShowerVOS = new ArrayList<>();
        try {
            StaticDataBO staticDataBO = staticDataManager.getStaticData().getModel();
            getProductShowersVO.setHeaderImageUrl(staticDataBO.getProductShowerHeaderUrl());
            getProductShowersVO.setPage(page);
            getProductShowersVO.setPageSize(pageSize);
            getProductShowersVO.setTotalCount(
                    productShowerManager.countProductShower(StatusEnum.NORMAL.getStatus()).getModel()
            );
            List<ProductShowerBO> productShowerBOS = productShowerManager.getProductShowerList(
                    StatusEnum.NORMAL.getStatus(), page , pageSize
            ).getModel();

            productShowerBOS.iterator().forEachRemaining(
                    obj-> {
                        productShowerVOS.add(ProductShowerConverter.convertBTV(obj));
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
    public Result<ProductShowerVO> getProductShowerDetail(@NonNull String productShowerId) {
        Result<ProductShowerVO> result = new Result<>();

        try {
            ProductShowerBO productShowerBO = productShowerManager
                    .getProductShowerById(productShowerId).getModel();
            result.setModel(ProductShowerConverter.convertBTV(productShowerBO));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }


    @Override
    public Result<GetPostsVO> getPosts(
            Integer page, Integer pageSize) {
        Result<GetPostsVO> result = new Result<GetPostsVO>();
        GetPostsVO getPostsVO = new GetPostsVO();
        try {
            List<PostVO> postVos = new ArrayList();
            List<PostBO> postBos = postManager.getPosts(
                    0 , page , pageSize).getModel();
            postBos.iterator().forEachRemaining(
                    obj-> {
                        postVos.add(PostConverter.convertBTV(obj));
                    }
            );
            getPostsVO.setPosts(postVos);
            result.setModel(getPostsVO);
        } catch (Exception e) {
            result.setSuccess(false);
            return result;
        }
        return result;
    }

    @Override
    public Result<PostVO> getPostByPostId(
            @NonNull String postId) {
        Result<PostVO> result = new Result<>();
        try {
            result.setModel(PostConverter.convertBTV(
                    postManager.getPostById(postId).getModel()));
        } catch (Exception e) {
            result.setSuccess(false);
            return result;
        }
        return result;
    }

    @Override
    public Result<CaseVO> getCaseById(
            @NonNull String caseId) {
        return null;
    }

    @Override
    public Result<GetCasesVO> getCases(
            Integer page, Integer pageSize) {
        return null;
    }
}
