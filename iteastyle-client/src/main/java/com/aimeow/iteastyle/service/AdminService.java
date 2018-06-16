package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

@Api(value = "/admin", description = "管理相关各路接口")
@RequestMapping(value = "/admin")
@RestController
public interface AdminService {

    @RequestMapping(value = "/updateCompanyInfo", method = RequestMethod.POST, consumes="application/json")
    Result<Boolean> updateCompanyInfo(JSONObject param);

    @RequestMapping(value = "/updateStaticData", method = RequestMethod.POST, consumes="application/json")
    Result<Boolean> updateStaticData(JSONObject param);

    @RequestMapping(value = "/createPost", method = RequestMethod.POST, consumes="application/json")
    Result<Boolean> createPost(JSONObject param);

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST, consumes="application/json")
    Result<Boolean> updatePost(JSONObject param);

    @RequestMapping(value = "/deletePost", method = RequestMethod.POST, consumes="application/json")
    Result<Boolean> deletePost(String postId);
}
