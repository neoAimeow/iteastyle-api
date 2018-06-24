package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.domain.CompanyStoryVO;
import com.aimeow.iteastyle.domain.HomePageVO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticDataBO;
import com.aimeow.iteastyle.manager.StaticDataManager;
import com.aimeow.iteastyle.service.WebDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebDataServiceImpl implements WebDataService {
    @Autowired private StaticDataManager staticDataManager;

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
        return null;
    }

}
