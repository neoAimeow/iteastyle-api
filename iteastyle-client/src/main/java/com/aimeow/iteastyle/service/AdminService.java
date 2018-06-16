package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
@RestController
public interface AdminService {
    @RequestMapping(value = "/admin/updateCompanyInfo", method = RequestMethod.POST, consumes="application/json")
    Result<Boolean> updateCompanyInfo(JSONObject param);

    @RequestMapping(value = "/admin/updateStaticData", method = RequestMethod.POST, consumes="application/json")
    Result<Boolean> updateStaticData(JSONObject param);

    @RequestMapping(value = "/admin/createPost", method = RequestMethod.POST, consumes="application/json")
    Result<Boolean> createPost(JSONObject param);

    @RequestMapping(value = "/admin/updatePost", method = RequestMethod.POST, consumes="application/json")
    Result<Boolean> updatePost(JSONObject param);

    @RequestMapping(value = "/admin/deletePost", method = RequestMethod.POST, consumes="application/json")
    Result<Boolean> deletePost(String postId);
}
