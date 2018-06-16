package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
@RestController
public interface AdminService {
    @RequestMapping("/admin/updateCompanyInfo")
    Result<Boolean> updateCompanyInfo(JSONObject param);

    @RequestMapping("/admin/updateStaticData")
    Result<Boolean> updateStaticData(JSONObject param);

    @RequestMapping("/admin/createPost")
    Result<Boolean> createPost(JSONObject param);

    @RequestMapping("/admin/updatePost")
    Result<Boolean> updatePost(JSONObject param);

    @RequestMapping("/admin/deletePost")
    Result<Boolean> deletePost(String postId);
}
