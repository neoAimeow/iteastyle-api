package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseQuery;
import com.aimeow.domain.BaseResult;
import com.aimeow.domain.BaseGetList;
import com.aimeow.iteastyle.domain.entity.*;
import com.aimeow.iteastyle.domain.enums.ContentTypeEnum;
import com.aimeow.iteastyle.domain.enums.StaticDataEnum;
import com.aimeow.iteastyle.service.WebDataService;
import com.aimeow.tools.CommonConverter;
import com.aimeow.iteastyle.domain.ViewObject.*;
import com.aimeow.iteastyle.service.AdminService;
import com.aimeow.tools.RedisUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aimeow.tools.CommonDAO;
import com.aimeow.tools.CommonData;

import java.awt.*;
import java.util.List;

/**
 * Created on 2018/11/6 11:52 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Component
public class AdminServiceImpl implements AdminService {
    @Autowired private CommonDAO commonDAO;
    @Autowired private CommonData commonData;
    @Autowired private WebDataService webDataService;

    @Override
    public BaseResult<Boolean> create(@NonNull String param, @NonNull String type) {
        BaseResult<Boolean> result = new BaseResult<>();
        try {
            if (ContentTypeEnum.Post.getValue().equals(type)) {
                PostEntity postEntity = JSONObject.parseObject(param , PostEntity.class);
                result.setModel(commonDAO.create(postEntity));
            } else if(ContentTypeEnum.Case.getValue().equals(type)) {
                CaseEntity caseEntity = JSONObject.parseObject(param , CaseEntity.class);
                result.setModel(commonDAO.create(caseEntity));
            } else if (ContentTypeEnum.Event.getValue().equals(type)) {
                EventEntity eventEntity = JSONObject.parseObject(param , EventEntity.class);
                result.setModel(commonDAO.create(eventEntity));
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
            if (ContentTypeEnum.Post.getValue().equals(type)) {
                PostEntity postEntity = JSONObject.parseObject(param , PostEntity.class);
                result.setModel(commonDAO.update(postEntity, PostEntity.class));
            } else if(ContentTypeEnum.Case.getValue().equals(type)) {
                CaseEntity caseEntity = JSONObject.parseObject(param , CaseEntity.class);
                result.setModel(commonDAO.update(caseEntity, CaseEntity.class));
            } else if(ContentTypeEnum.Event.getValue().equals(type)) {
                EventEntity eventEntity = JSONObject.parseObject(param , EventEntity.class);
                result.setModel(commonDAO.update(eventEntity, EventEntity.class));
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
            if (ContentTypeEnum.Post.getValue().equals(type)) {
                result.setModel(commonDAO.delete(id , PostEntity.class));
            } else if(ContentTypeEnum.Case.getValue().equals(type)) {
                result.setModel(commonDAO.delete(id , CaseEntity.class));
            } else if(ContentTypeEnum.Event.getValue().equals(type)) {
                result.setModel(commonDAO.delete(id , EventEntity.class));
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
            if (ContentTypeEnum.CompanyInfo.getValue().equals(type)) {
                CompanyInfoEntity companyInfoDO = JSONObject.parseObject(param , CompanyInfoEntity.class);
                result.setModel(commonData.edit(companyInfoDO, CompanyInfoEntity.class));
            } else if (ContentTypeEnum.StaticData.getValue().equals(type)) {
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
            if (ContentTypeEnum.CompanyInfo.getValue().equals(type)) {
                result.setModel(JSONObject.parseObject(JSONObject.toJSONString(
                        CommonConverter.convert(commonData.getData(CompanyInfoEntity.class) , CompanyInfoVO.class)))
                );
            } else if (ContentTypeEnum.StaticData.getValue().equals(type)) {
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
        BaseResult result = new BaseResult<>();
        try {
            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setPage(page);
            baseQuery.setPageSize(pageSize);
            if (ContentTypeEnum.Post.getValue().equals(type)) {
                List<PostEntity> postEntities = commonDAO.queryList(baseQuery , PostEntity.class, null , null);
                BaseGetList baseGetList = new BaseGetList();
                baseGetList.setPage(page);
                baseGetList.setPageSize(pageSize);
                baseGetList.setTotalCount(commonDAO.count(baseQuery , PostEntity.class));
                baseGetList.setItems(postEntities);
                result.setModel(baseGetList);
            } else if(ContentTypeEnum.Case.getValue().equals(type)) {
                List<CaseEntity> caseEntities = commonDAO.queryList(baseQuery , CaseEntity.class, null , null);
                BaseGetList baseGetList = new BaseGetList();
                baseGetList.setPage(page);
                baseGetList.setPageSize(pageSize);
                baseGetList.setTotalCount(commonDAO.count(baseQuery , CaseEntity.class));
                baseGetList.setItems(caseEntities);
                result.setModel(baseGetList);
            } else if(ContentTypeEnum.Event.getValue().equals(type)) {

                List<EventEntity> eventEntities = commonDAO.queryList(baseQuery , EventEntity.class, null , null);

                BaseGetList baseGetList = new BaseGetList();
                baseGetList.setPage(page);
                baseGetList.setPageSize(pageSize);
                baseGetList.setTotalCount(commonDAO.count(baseQuery , CaseEntity.class));
                baseGetList.setItems(eventEntities);
                result.setModel(baseGetList);
            }
        } catch (Exception e) {
            result.setMsgInfo(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public BaseResult getDataById(String id, String type) {
        BaseResult result = new BaseResult<>();
        try {
            if (ContentTypeEnum.Post.getValue().equals(type)) {
                PostEntity postEntity = commonDAO.queryById(id , PostEntity.class);
                result.setModel(postEntity);
            } else if(ContentTypeEnum.Case.getValue().equals(type)) {
                result.setModel(webDataService.getCaseById(id).getModel());
            } else if(ContentTypeEnum.Event.getValue().equals(type)) {
                EventEntity eventEntity = commonDAO.queryById(id , EventEntity.class);
                result.setModel(eventEntity);
            }
        } catch (Exception ex) {
            result.setMsgInfo(ex.getMessage());
            result.setSuccess(false);
        }
        return result;
    }
}
