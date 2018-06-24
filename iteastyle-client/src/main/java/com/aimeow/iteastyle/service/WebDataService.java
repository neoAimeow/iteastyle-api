package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyStoryVO;
import com.aimeow.iteastyle.domain.ContactUsVO;
import com.aimeow.iteastyle.domain.HomePageVO;
import com.aimeow.iteastyle.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "/web",tags = {"网页端接口"}, description = "网页部分相关数据")
@RequestMapping(value = "/staticData")
public interface WebDataService {

    @ApiOperation(value = "通过GET请求方式获取『首页』相关信息，不需要传任何参数")
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    Result<HomePageVO> getHomePageData();

    @ApiOperation(value = "通过GET请求方式获取『公司故事』相关信息，不需要传任何参数")
    @RequestMapping(value = "/companyStory", method = RequestMethod.GET)
    Result<CompanyStoryVO> getCompanyStory();

    @ApiOperation(value = "通过GET请求方式获取『关于我们』相关信息，不需要传任何参数")
    @RequestMapping(value = "/contactUsData", method = RequestMethod.GET)
    Result<ContactUsVO> getContactUsData();

}
