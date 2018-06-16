package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.manager.CompanyInfoManager;
import com.aimeow.iteastyle.manager.PostManager;
import com.aimeow.iteastyle.manager.StaticDataManager;
import com.aimeow.iteastyle.service.AdminService;
import com.alibaba.fastjson.JSONObject;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl implements AdminService {
    @Autowired private CompanyInfoManager companyInfoManager;
    @Autowired private StaticDataManager staticDataManager;
    @Autowired private PostManager postManager;

    @Override
    public Result<Boolean> updateCompanyInfo(
            @NonNull JSONObject param) {
        return null;
    }

    @Override
    public Result<Boolean> updateStaticData(
            @NonNull JSONObject param) {
        return null;
    }

    @Override
    public Result<Boolean> createPost(
            @NonNull JSONObject param) {
        return null;
    }

    @Override
    public Result<Boolean> updatePost(
            @NonNull JSONObject param) {
        return null;
    }

    @Override
    public Result<Boolean> deletePost(
            @NonNull String postId) {
        return null;
    }
}
