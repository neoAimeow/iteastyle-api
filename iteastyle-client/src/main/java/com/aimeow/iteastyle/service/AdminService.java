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

@Api(value = "/admin",tags = {"管理接口"}, description = "管理相关各路接口")
@RequestMapping(value = "/admin")
@RestController
public interface AdminService {

    @RequestMapping(value = "/getCompanyInfo", method = RequestMethod.GET)
    Result<CompanyInfoVO> getCompanyInfo();

    @RequestMapping(value = "/updateCompanyInfo", method = RequestMethod.POST)
    Result<Boolean> updateCompanyInfo(JSONObject param);

    @RequestMapping(value = "/getStaticData", method = RequestMethod.GET)
    Result<StaticDataVO> getStaticData();

    @RequestMapping(value = "/updateStaticData", method = RequestMethod.POST)
    Result<Boolean> updateStaticData(JSONObject param);

    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    Result<Boolean> createPost(JSONObject param);

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    Result<Boolean> updatePost(JSONObject param);

    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    Result<Boolean> deletePost(String postId);

    @RequestMapping(value = "/createCase", method = RequestMethod.POST)
    Result<Boolean> createCase(JSONObject param);

    @RequestMapping(value = "/updateCase", method = RequestMethod.POST)
    Result<Boolean> updateCase(JSONObject param);

    @RequestMapping(value = "/deleteCase", method = RequestMethod.POST)
    Result<Boolean> deleteCase(String caseId);

    @RequestMapping(value = "/createProductShower", method = RequestMethod.POST)
    Result<Boolean> createProductShower(JSONObject param);

    @RequestMapping(value = "/updateProductShower", method = RequestMethod.POST)
    Result<Boolean> updateProductShower(JSONObject param);

    @RequestMapping(value = "/deleteProductShower", method = RequestMethod.POST)
    Result<Boolean> deleteProductShower(String caseId);

    @RequestMapping(value = "/getLogs", method = RequestMethod.GET)
    Result<LogVO> getLogs();
}
