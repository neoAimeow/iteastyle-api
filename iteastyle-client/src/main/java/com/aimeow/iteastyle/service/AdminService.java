package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Result;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
@RestController
public interface AdminService {
    Result<Boolean> updateCompanyInfo(JSONObject param);
    Result<Boolean> updateStaticData(JSONObject param);
    Result<Boolean> createPost(JSONObject param);
    Result<Boolean> updatePost(JSONObject param);
    Result<Boolean> deletePost(String postId);
}
