package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.domain.CompanyStoryVO;
import com.aimeow.iteastyle.domain.HomePageVO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.service.WebDataService;
import org.springframework.stereotype.Service;

@Service
public class WebDataServiceImpl implements WebDataService {

    @Override
    public Result<HomePageVO> getHomePageData() {
        return null;
    }

    @Override
    public Result<CompanyStoryVO> getCompanyStory() {
        return null;
    }

}
