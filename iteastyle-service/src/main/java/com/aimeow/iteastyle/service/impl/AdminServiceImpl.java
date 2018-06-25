package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.converter.CompanyInfoConverter;
import com.aimeow.iteastyle.converter.StaticDataConverter;
import com.aimeow.iteastyle.domain.CompanyInfo.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Log.LogVO;
import com.aimeow.iteastyle.domain.ProductShowerDO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticData.StaticDataVO;
import com.aimeow.iteastyle.manager.*;
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
    @Autowired private LogManager logManager;
    @Autowired private ProductShowerManager productShowerManager;
    @Autowired private AdminUserManager adminUserManager;
    @Autowired private CaseManager caseManager;
    @Autowired private CaseTypeManager caseTypeManager;

    @Override
    public Result<CompanyInfoVO> getCompanyInfo() {
        Result<CompanyInfoVO> result = new Result<>();
        try {
            result.setModel(CompanyInfoConverter.convertBTV(companyInfoManager.getCompanyInfo().getModel()));
        } catch (Exception e) {
            result.setMsgInfo(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<Boolean> updateCompanyInfo(
            @NonNull JSONObject param) {
        return null;
    }

    @Override
    public Result<StaticDataVO> getStaticData() {
        Result<StaticDataVO> result = new Result<>();
        try {
            result.setModel(StaticDataConverter.convertBTV(staticDataManager.getStaticData().getModel()));
        } catch (Exception e) {
            result.setMsgInfo(e.getMessage());
            result.setSuccess(false);
        }
        return result;
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

    @Override
    public Result<Boolean> createCase(JSONObject param) {
        return null;
    }

    @Override
    public Result<Boolean> updateCase(JSONObject param) {
        return null;
    }

    @Override
    public Result<Boolean> deleteCase(String caseId) {
        return null;
    }

    @Override
    public Result<Boolean> createProductShower(JSONObject param) {
        return null;
    }

    @Override
    public Result<Boolean> updateProductShower(JSONObject param) {
        return null;
    }

    @Override
    public Result<Boolean> deleteProductShower(String caseId) {
        return null;
    }

    @Override
    public Result<LogVO> getLogs() {
        return null;
    }
}
