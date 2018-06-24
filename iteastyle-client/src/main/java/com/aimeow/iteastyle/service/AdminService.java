package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

@Api(value = "/admin",tags = {"管理接口"}, description = "管理相关各路接口")
@RequestMapping(value = "/admin")
@RestController
public interface AdminService {

    @RequestMapping(value = "/updateCompanyInfo", method = RequestMethod.POST)
    Result<Boolean> updateCompanyInfo(JSONObject param);

    @RequestMapping(value = "/updateStaticData", method = RequestMethod.POST)
    Result<Boolean> updateStaticData(JSONObject param);

    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    Result<Boolean> createPost(JSONObject param);

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    Result<Boolean> updatePost(JSONObject param);

    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    Result<Boolean> deletePost(String postId);
}
