package com.aimeow.iteastyle.service;

import com.aimeow.domain.BaseResult;
import com.aimeow.domain.BaseGetList;
import com.aimeow.iteastyle.domain.ViewObject.*;
import com.aimeow.iteastyle.domain.ViewObject.Case.CasesInTypeVO;
import com.aimeow.iteastyle.domain.entity.CaseEntity;
import com.aimeow.iteastyle.domain.entity.CaseTypeEntity;
import com.aimeow.iteastyle.domain.entity.PostEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.TeaBreakServiceEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.TeaGiftServiceEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "/service",tags = {"网页端接口"}, description = "网页部分相关数据")
@RequestMapping(value = "/service")
@RestController
public interface WebDataService {

    @ApiOperation(value = "通过GET请求方式获取『首页』相关信息，不需要传任何参数")
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    BaseResult<HomePageVO> getHomePageData();

    @ApiOperation(value = "通过GET请求方式获取『公司故事』相关信息，不需要传任何参数")
    @RequestMapping(value = "/companyStory", method = RequestMethod.GET)
    BaseResult<CompanyStoryVO> getCompanyStory();

    @ApiOperation(value = "通过GET请求方式获取『关于我们』相关信息，不需要传任何参数")
    @RequestMapping(value = "/contactUsData", method = RequestMethod.GET)
    BaseResult<ContactUsVO> getContactUsData();

    @ApiOperation(value = "通过GET请求方式获取『茶式动态』需要传分页参数")
    @RequestMapping(value = "/getPosts", method = RequestMethod.GET)
    BaseResult<BaseGetList> getPosts(Integer page, Integer pageSize);

    @ApiOperation(value = "通过GET请求方式获取『茶式动态详情』相关信息，需要传id")
    @RequestMapping(value = "/getPostById", method = RequestMethod.GET)
    BaseResult<PostEntity> getPostByPostId(String postId);

    @ApiOperation(value = "通过GET请求方式获取产品展示类型")
    @RequestMapping(value = "/getCaseTypes", method = RequestMethod.GET)
    BaseResult<List<CaseTypeEntity>> getCaseTypes();

    @ApiOperation(value = "通过ID获取产品展示内容")
    @RequestMapping(value = "/getCaseById", method = RequestMethod.GET)
    BaseResult<CaseEntity> getCaseById(String caseId);

    @ApiOperation(value = "通过分页参数获得产品展示列表")
    @RequestMapping(value = "/getCaseByType", method = RequestMethod.GET)
    BaseResult<BaseGetList> getCaseByType(Integer type , Integer page , Integer pageSize);

    @ApiOperation(value = "获得产品展示首页列表")
    @RequestMapping(value = "/getCasesHomeData", method = RequestMethod.GET)
    BaseResult<List<CasesInTypeVO>> getCasesHomeData();

    @ApiOperation(value = "获得茶歇服务内容")
    @RequestMapping(value = "/getTeaBreakService", method = RequestMethod.GET)
    BaseResult<TeaBreakServiceEntity> getTeaBreakService();

    @ApiOperation(value = "获得茶礼服务内容")
    @RequestMapping(value = "/getTeaGiftService", method = RequestMethod.GET)
    BaseResult<TeaGiftServiceEntity> getTeaGiftService();

    @ApiOperation(value = "获得diy活动内容")
    @RequestMapping(value = "/getTeaDIYService", method = RequestMethod.GET)
    BaseResult<BaseGetList> getTeaDIYService(Integer page, Integer pageSize);

    @ApiOperation(value = "获得茶艺表演活动内容")
    @RequestMapping(value = "/getTeaPerformService", method = RequestMethod.GET)
    BaseResult<BaseGetList> getTeaPerformService(Integer page, Integer pageSize);

    @ApiOperation(value = "获得茶文化讲座活动内容")
    @RequestMapping(value = "/getTeaLectureService", method = RequestMethod.GET)
    BaseResult<BaseGetList> getTeaLectureService(Integer page, Integer pageSize);
}