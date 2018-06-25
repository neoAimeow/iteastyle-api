package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyInfo.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Log.LogVO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticData.StaticDataVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

@Api(value = "/admin",tags = {"管理接口"}, description = "管理相关各路接口")
@RequestMapping(value = "/admin")
@RestController
public interface AdminService {

    @RequestMapping(value = "/getCompanyInfo", method = RequestMethod.GET)
    Result<CompanyInfoVO> getCompanyInfo();

    @RequestMapping(value = "/updateCompanyInfo", method = RequestMethod.POST)
    Result<Boolean> updateCompanyInfo(String param);

    @RequestMapping(value = "/getStaticData", method = RequestMethod.GET)
    Result<StaticDataVO> getStaticData();

    @RequestMapping(value = "/updateStaticData", method = RequestMethod.POST)
    Result<Boolean> updateStaticData(String param);

    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    Result<Boolean> createPost(String param);

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    Result<Boolean> updatePost(String param);

    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    Result<Boolean> deletePost(String postId);

    @RequestMapping(value = "/createCase", method = RequestMethod.POST)
    Result<Boolean> createCase(String param);

    @RequestMapping(value = "/updateCase", method = RequestMethod.POST)
    Result<Boolean> updateCase(String param);

    @RequestMapping(value = "/deleteCase", method = RequestMethod.POST)
    Result<Boolean> deleteCase(String caseId);

    @RequestMapping(value = "/createProductShower", method = RequestMethod.POST)
    Result<Boolean> createProductShower(String param);

    @RequestMapping(value = "/updateProductShower", method = RequestMethod.POST)
    Result<Boolean> updateProductShower(String param);

    @RequestMapping(value = "/deleteProductShower", method = RequestMethod.POST)
    Result<Boolean> deleteProductShower(String productShowerId);

    @RequestMapping(value = "/getLogs", method = RequestMethod.GET)
    Result<List<LogVO>> getLogs(Integer page , Integer pageSize);
}
