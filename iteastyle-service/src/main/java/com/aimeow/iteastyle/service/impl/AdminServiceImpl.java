package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.converter.CompanyInfoConverter;
import com.aimeow.iteastyle.converter.LogConverter;
import com.aimeow.iteastyle.converter.StaticDataConverter;
import com.aimeow.iteastyle.domain.*;
import com.aimeow.iteastyle.domain.CompanyInfo.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Log.LogVO;
import com.aimeow.iteastyle.domain.StaticData.StaticDataVO;
import com.aimeow.iteastyle.manager.*;
import com.aimeow.iteastyle.service.AdminService;
import com.alibaba.fastjson.JSONObject;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

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
        try {
            JSONObject object = JSONObject.parseObject(param);
            CompanyInfoBO companyInfoBO = JSONObject.parseObject(param , CompanyInfoBO.class);
            result.setModel(companyInfoManager.updateCompanyInfo(companyInfoBO).getModel());

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
            JSONObject object = JSONObject.parseObject(param);
            StaticDataBO staticDataBO = JSONObject.parseObject(param , StaticDataBO.class);

            result.setModel(staticDataManager.updateStaticData(staticDataBO).getModel());

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
            JSONObject object = JSONObject.parseObject(param);
            PostBO postBO = JSONObject.parseObject(param , PostBO.class);
            result.setModel(postManager.createPost(postBO).getModel());
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
            JSONObject object = JSONObject.parseObject(param);
            PostBO postBO = JSONObject.parseObject(param , PostBO.class);
            result.setModel(postManager.updatePost(postBO).getModel());
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
            result.setModel(postManager.deletePost(postId).getModel());
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
            JSONObject object = JSONObject.parseObject(param);
            CaseBO caseBO = JSONObject.parseObject(param , CaseBO.class);
            result.setModel(caseManager.createCase(caseBO).getModel());
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
            JSONObject object = JSONObject.parseObject(param);
            CaseBO caseBO = JSONObject.parseObject(param , CaseBO.class);
            result.setModel(caseManager.updateCase(caseBO).getModel());
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
            result.setModel(caseManager.deleteCase(caseId).getModel());

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
            JSONObject object = JSONObject.parseObject(param);
            ProductShowerBO productShowerBO = JSONObject.parseObject(param , ProductShowerBO.class);
            result.setModel(productShowerManager.createProductShower(productShowerBO).getModel());
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
            JSONObject object = JSONObject.parseObject(param);
            ProductShowerBO productShowerBO = JSONObject.parseObject(param , ProductShowerBO.class);
            result.setModel(productShowerManager.updateProductShower(productShowerBO).getModel());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<Boolean> deleteProductShower(String productShowerId) {
        Result<Boolean> result = new Result<>();

        try {
            result.setModel(productShowerManager.deleteProductShower(productShowerId).getModel());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<List<LogVO>> getLogs(Integer page , Integer pageSize) {
        Result<List<LogVO>> result = new Result<>();

        try {
            List<LogVO> logVOS = new ArrayList<>();
            List<LogBO> logBOS = logManager.queryLogs(page , pageSize).getModel();
            logBOS.iterator().forEachRemaining(
                    obj-> {
                        logVOS.add(LogConverter.convertBTV(obj));
                    }
            );
            result.setModel(logVOS);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }
}
