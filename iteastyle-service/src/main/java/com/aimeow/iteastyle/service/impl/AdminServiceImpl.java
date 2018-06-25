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
            @NonNull String param) {
        Result<Boolean> result = new Result<>();
        System.out.println(param);
        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
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
            @NonNull String param) {
        Result<Boolean> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<Boolean> createPost(
            @NonNull String param) {
        Result<Boolean> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<Boolean> updatePost(
            @NonNull String param) {
        Result<Boolean> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<Boolean> deletePost(
            @NonNull String postId) {
        Result<Boolean> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<Boolean> createCase(String param) {
        Result<Boolean> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<Boolean> updateCase(String param) {
        Result<Boolean> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<Boolean> deleteCase(String caseId) {
        Result<Boolean> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<Boolean> createProductShower(String param) {
        Result<Boolean> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<Boolean> updateProductShower(String param) {
        Result<Boolean> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<Boolean> deleteProductShower(String caseId) {
        Result<Boolean> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<LogVO> getLogs() {
        Result<LogVO> result = new Result<>();

        try {

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }
}
