package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.domain.*;
import com.aimeow.iteastyle.manager.CompanyInfoManager;
import com.aimeow.iteastyle.manager.ProductShowerManager;
import com.aimeow.iteastyle.manager.StaticDataManager;
import com.aimeow.iteastyle.service.WebDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class WebDataServiceImpl implements WebDataService {
    @Autowired private StaticDataManager staticDataManager;
    @Autowired private CompanyInfoManager companyInfoManager;
    @Autowired private ProductShowerManager productShowerManager;

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
        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<ProductShowerVO> getProductShowerDetail(String productShowerId) {
        Result<ProductShowerVO> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }
}
