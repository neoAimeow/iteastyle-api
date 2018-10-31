package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseQuery;
import com.aimeow.domain.BaseResult;
import com.aimeow.domain.BaseGetList;
import com.aimeow.tools.CommonConverter;
import com.aimeow.iteastyle.domain.ViewObject.*;
import com.aimeow.iteastyle.domain.entity.CaseEntity;
import com.aimeow.iteastyle.domain.entity.CompanyInfoEntity;
import com.aimeow.iteastyle.domain.entity.PostEntity;
import com.aimeow.iteastyle.domain.entity.StaticDataEntity;
import com.aimeow.iteastyle.service.AdminService;
import com.alibaba.fastjson.JSONObject;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aimeow.tools.CommonDAO;
import com.aimeow.tools.CommonData;

import java.util.List;

@Component
public class AdminServiceImpl implements AdminService {
    @Autowired private CommonDAO commonDAO;
    @Autowired private CommonData commonData;

    @Override
    public BaseResult<Boolean> create(@NonNull String param, @NonNull String type) {
        BaseResult<Boolean> result = new BaseResult<>();
        try {
            if ("post".equals(type)) {
                PostEntity postEntity = JSONObject.parseObject(param , PostEntity.class);
                result.setModel(commonDAO.create(postEntity));
            } else if("case".equals(type)) {
                CaseEntity caseEntity = JSONObject.parseObject(param , CaseEntity.class);
                result.setModel(commonDAO.create(caseEntity));
            }
        } catch (Exception e) {
            result.setMsgInfo(e.getMessage());
            result.setSuccess(false);
        }
        return result;

    }

    @Override
    public BaseResult<Boolean> update(@NonNull String param, @NonNull String type) {
        BaseResult<Boolean> result = new BaseResult<>();
        try {
            if ("post".equals(type)) {
                PostEntity postEntity = JSONObject.parseObject(param , PostEntity.class);
                result.setModel(commonDAO.update(postEntity, PostEntity.class));
            } else if("case".equals(type)) {
                CaseEntity caseEntity = JSONObject.parseObject(param , CaseEntity.class);
                result.setModel(commonDAO.update(caseEntity, CaseEntity.class));
            }

        } catch (Exception e) {
            result.setMsgInfo(e.getMessage());
            result.setSuccess(false);
        }
        return result;

    }

    @Override
    public BaseResult<Boolean> delete(@NonNull String id, @NonNull String type) {
        BaseResult<Boolean> result = new BaseResult<>();
        try {
            if ("post".equals(type)) {
                result.setModel(commonDAO.delete(id , PostEntity.class));
            } else if("case".equals(type)) {
                result.setModel(commonDAO.delete(id , CaseEntity.class));
            }
        } catch (Exception e) {
            result.setMsgInfo(e.getMessage());
            result.setSuccess(false);
        }
        return result;

    }

    @Override
    public BaseResult<Boolean> updateData(String param, String type) {
        BaseResult<Boolean> result = new BaseResult<>();
        try {
            if ("companyInfo".equals(type)) {
                CompanyInfoEntity companyInfoDO = JSONObject.parseObject(param , CompanyInfoEntity.class);
                result.setModel(commonData.edit(companyInfoDO, CompanyInfoEntity.class));
            } else if ("staticData".equals(type)) {
                StaticDataEntity staticDataDO = JSONObject.parseObject(param , StaticDataEntity.class);
                result.setModel(commonData.edit(staticDataDO, StaticDataEntity.class));
            }
        } catch (Exception e) {
            result.setMsgInfo(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public BaseResult<JSONObject> getInfo(String type) {
        BaseResult<JSONObject> result = new BaseResult<>();
        try {
            if ("companyInfo".equals(type)) {
                result.setModel(JSONObject.parseObject(JSONObject.toJSONString(
                        CommonConverter.convert(commonData.getData(CompanyInfoEntity.class) , CompanyInfoVO.class)))
                );
            } else if ("staticData".equals(type)) {
                result.setModel(JSONObject.parseObject(JSONObject.toJSONString(
                        CommonConverter.convert(commonData.getData(StaticDataEntity.class) , StaticDataEntity.class)))
                );
            }

        } catch (Exception e) {
            result.setMsgInfo(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public BaseResult<JSONObject> getList(Integer page, Integer pageSize, String type) {
        BaseResult<JSONObject> result = new BaseResult<>();
        try {
            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setPage(page);
            baseQuery.setPageSize(pageSize);
            if ("post".equals(type)) {
                List<PostEntity> postEntities = commonDAO.queryList(baseQuery , PostEntity.class, null , null);

                BaseGetList baseGetList = new BaseGetList();
                baseGetList.setPage(page);
                baseGetList.setPageSize(pageSize);
                baseGetList.setTotalCount(commonDAO.count(baseQuery , PostEntity.class));
                baseGetList.setItems(postEntities);
                result.setModel(JSONObject.parseObject(JSONObject.toJSONString(postEntities)));

            } else if("case".equals(type)) {

            }
        } catch (Exception e) {
            result.setMsgInfo(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

}
