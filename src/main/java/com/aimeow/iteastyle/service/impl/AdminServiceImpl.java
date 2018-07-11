package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.base.domain.BaseQuery;
import com.aimeow.iteastyle.base.domain.BaseResult;
import com.aimeow.iteastyle.base.tools.CommonConverter;
import com.aimeow.iteastyle.domain.DomainObject.*;
import com.aimeow.iteastyle.domain.ViewObject.*;
import com.aimeow.iteastyle.domain.query.PostQuery;
import com.aimeow.iteastyle.service.AdminService;
import com.alibaba.fastjson.JSONObject;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminServiceImpl implements AdminService {
    @Autowired private CommonDAO commonDAO;
    @Autowired private CommonData commonData;

    @Override
    public BaseResult<Boolean> create(@NonNull String param, @NonNull String type) {
        BaseResult<Boolean> result = new BaseResult<>();
        try {
            JSONObject object = JSONObject.parseObject(param);
            if ("post".equals(type)) {
                PostDO postDO = JSONObject.parseObject(param , PostDO.class);
                result.setModel(commonDAO.create(postDO));
            } else if("case".equals(type)) {
                CaseDO caseDO = JSONObject.parseObject(param , CaseDO.class);
                result.setModel(commonDAO.create(caseDO));
            } else if("productShower".equals(type)) {
                ProductShowerDO productShowerDO = JSONObject.parseObject(param , ProductShowerDO.class);
                result.setModel(commonDAO.create(productShowerDO));
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
            JSONObject object = JSONObject.parseObject(param);

            if ("post".equals(type)) {
                PostDO postDO = JSONObject.parseObject(param , PostDO.class);
                result.setModel(commonDAO.update(postDO , PostDO.class));
            } else if("case".equals(type)) {
                CaseDO caseDO = JSONObject.parseObject(param , CaseDO.class);
                result.setModel(commonDAO.update(caseDO , CaseDO.class));
            } else if("productShower".equals(type)) {
                ProductShowerDO productShowerDO = JSONObject.parseObject(param , ProductShowerDO.class);
                result.setModel(commonDAO.update(productShowerDO , ProductShowerDO.class));
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
                result.setModel(commonDAO.delete(id , PostDO.class));
            } else if("case".equals(type)) {
                result.setModel(commonDAO.delete(id , CaseDO.class));
            } else if("productShower".equals(type)) {
                result.setModel(commonDAO.delete(id , ProductShowerDO.class));
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
                CompanyInfoDO companyInfoDO = JSONObject.parseObject(param , CompanyInfoDO.class);
                result.setModel(commonData.edit(companyInfoDO, CompanyInfoDO.class));
            } else if ("staticData".equals(type)) {
                StaticDataDO staticDataDO = JSONObject.parseObject(param , StaticDataDO.class);
                result.setModel(commonData.edit(staticDataDO, StaticDataDO.class));
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
                        CommonConverter.convert(commonData.getData(CompanyInfoDO.class) , CompanyInfoVO.class)))
                );
            } else if ("staticData".equals(type)) {
                result.setModel(JSONObject.parseObject(JSONObject.toJSONString(
                        CommonConverter.convert(commonData.getData(StaticDataDO.class) , StaticDataDO.class)))
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
                List<PostVO> postVOS = new ArrayList<>();
                List<PostDO> postDOS = commonDAO.queryList(baseQuery , PostDO.class);
                postDOS.iterator().forEachRemaining(
                        obj-> {
                            postVOS.add(CommonConverter.convert(obj , PostVO.class));
                        }
                );

                GetPostsVO getPostsVO = new GetPostsVO();
                getPostsVO.setPage(page);
                getPostsVO.setPageSize(pageSize);
                getPostsVO.setTotalCount(commonDAO.count(baseQuery , PostDO.class));
                getPostsVO.setPosts(postVOS);
                result.setModel(JSONObject.parseObject(JSONObject.toJSONString(postVOS)));

            } else if("case".equals(type)) {

            } else if("productShower".equals(type)) {

            }
        } catch (Exception e) {
            result.setMsgInfo(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

}
