package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.domain.*;
import com.aimeow.iteastyle.manager.CompanyInfoManager;
import com.aimeow.iteastyle.manager.StaticDataManager;
import com.aimeow.iteastyle.service.WebDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebDataServiceImpl implements WebDataService {
    @Autowired private StaticDataManager staticDataManager;
    @Autowired private CompanyInfoManager companyInfoManager;

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
        try {
            CompanyStoryVO companyStoryVO = new CompanyStoryVO();
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
        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }


        return result;
    }
}
