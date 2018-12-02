package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseQuery;
import com.aimeow.domain.BaseResult;
import com.aimeow.domain.BaseGetList;
import com.aimeow.iteastyle.domain.enums.StaticDataEnum;
import com.aimeow.tools.CommonDAO;
import com.aimeow.tools.CommonData;

import com.aimeow.iteastyle.domain.ViewObject.Case.CasesInTypeVO;
import com.aimeow.iteastyle.domain.entity.*;
import com.aimeow.iteastyle.domain.entity.service.TeaDIYEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaLectureEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaPerformEntity;
import com.aimeow.iteastyle.domain.enums.StatusEnum;
import com.aimeow.iteastyle.domain.query.CaseQuery;
import com.aimeow.iteastyle.domain.query.PostQuery;
import com.aimeow.iteastyle.service.WebDataService;
import com.aimeow.tools.RedisUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created on 2018/11/6 11:52 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Component
public class WebDataServiceImpl implements WebDataService {
    @Autowired private CommonDAO commonDAO;
    @Autowired private CommonData commonData;
    @Autowired private RedisUtil redisUtil;

    @Override
    public BaseResult<BaseGetList> getPosts(
            Integer page, Integer pageSize) {
        BaseResult<BaseGetList> result = new BaseResult<BaseGetList>();
        BaseGetList baseGetList = new BaseGetList();
        try {
            baseGetList.setPage(page);
            baseGetList.setPageSize(pageSize);

            PostQuery postQuery = new PostQuery();
            postQuery.setPageSize(pageSize);
            postQuery.setPage(page);
            postQuery.setStatus(StatusEnum.NORMAL.getStatus());
        
            List<PostEntity> postEntities = commonDAO.queryList(postQuery , PostEntity.class, null , null);
            for (PostEntity postEntity: postEntities) {
                if (StringUtils.isEmpty(postEntity.getImageUrl())) {
                    postEntity.setImageUrl("http://image.iteastyle.com/if%20no%20img.jpg");
                }

                if (StringUtils.isEmpty(postEntity.getSummary())) {
                    postEntity.setSummary("点击查看文章详情..");
                }
            }
            baseGetList.setTotalCount(commonDAO.count(postQuery , PostEntity.class));
            baseGetList.setItems(postEntities);
            result.setModel(baseGetList);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<PostEntity> getPostByPostId(
            @NonNull String postId) {
        BaseResult<PostEntity> result = new BaseResult<>();
        try {
            result.setModel(commonDAO.queryById(postId , PostEntity.class));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<CaseEntity> getCaseById(
            @NonNull String caseId) {
        BaseResult<CaseEntity> result = new BaseResult<>();

        try {
            CaseEntity caseEntity = commonDAO.queryById(caseId , CaseEntity.class);

            JSONArray jsonArray = JSONArray.parseArray(redisUtil.get(StaticDataEnum.CASE_TYPE.getKey()));
            JSONObject targetObject = null;
            for (Object o : jsonArray) {
                JSONObject jo = JSONObject.parseObject(JSONObject.toJSONString(o));
                if (jo.get("type")!= null && jo.get("type").equals(caseEntity.getType())) {
                    targetObject = jo;
                    break;
                }
            }
            if (targetObject != null) {
                caseEntity.setTypeName(targetObject.get("typeName").toString());
            }
            result.setModel(caseEntity);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<BaseGetList> getCaseByType(
            @NonNull Integer type , Integer page, Integer pageSize) {
        BaseResult<BaseGetList> result = new BaseResult<>();
        BaseGetList baseGetList = new BaseGetList();
        try {
            baseGetList.setPage(page);
            baseGetList.setPageSize(pageSize);

            CaseQuery caseQuery = new CaseQuery();
            caseQuery.setType(type);
            caseQuery.setPage(page);
            caseQuery.setPageSize(pageSize);

            baseGetList.setTotalCount(commonDAO.count(caseQuery, CaseEntity.class));

            CasesInTypeVO casesInTypeVO = new CasesInTypeVO();
            List<CaseEntity> caseBaseVOS = new ArrayList<>();
            casesInTypeVO.setCases(caseBaseVOS);


            JSONArray jsonArray = JSONArray.parseArray(redisUtil.get(StaticDataEnum.CASE_TYPE.getKey()));
            JSONObject targetObject = null;
            for (Object o : jsonArray) {
                JSONObject jo = JSONObject.parseObject(JSONObject.toJSONString(o));
                if (jo.get("type")!= null && jo.get("type").equals(type)) {
                    targetObject = jo;
                    break;
                }
            }
            if (targetObject != null) {
                casesInTypeVO.setCaseType(targetObject);
            }

            List<CaseEntity> caseEntities = commonDAO.queryList(caseQuery, CaseEntity.class , null , null);
            caseEntities.iterator().forEachRemaining(
                    obj-> {
                        CaseEntity caseBaseVO = obj;
                        caseBaseVO.setTypeName(casesInTypeVO.getCaseType().get("typeName").toString());
                        caseBaseVOS.add(caseBaseVO);
                    }
            );


            baseGetList.setItems(casesInTypeVO);
            result.setModel(baseGetList);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<List<CasesInTypeVO>> getCasesHomeData() {
        BaseResult<List<CasesInTypeVO>> result = new BaseResult<>();
        List<CasesInTypeVO> casesInTypeVOS = new ArrayList<>();
        try {
            JSONArray jsonArray = JSONArray.parseArray(redisUtil.get(StaticDataEnum.CASE_TYPE.getKey()));

            List<JSONObject> caseTypeVOS = new ArrayList<>();
            List<CaseEntity> caseBaseVOS = new ArrayList<>();
            List<CaseEntity> caseEntities = commonDAO.queryAllList(
                CaseEntity.class,null,null);

            for (CaseEntity caseEntity : caseEntities) {
                caseBaseVOS.add(caseEntity);
            }

            for (Object o : jsonArray) {
                JSONObject jo = JSONObject.parseObject(JSONObject.toJSONString(o));

            }

            for (Object o : jsonArray) {
                JSONObject jo = JSONObject.parseObject(JSONObject.toJSONString(o));
                caseTypeVOS.add(jo);
                CasesInTypeVO casesInTypeVO = new CasesInTypeVO();
                casesInTypeVO.setCaseType(jo);
                casesInTypeVOS.add(casesInTypeVO);
            }

            for (CasesInTypeVO casesInTypeVO:casesInTypeVOS) {
                for (CaseEntity caseBaseVO: caseBaseVOS) {
                    if (caseBaseVO.getType().equals(casesInTypeVO.getCaseType().get("type"))) {
                        caseBaseVO.setTypeName(casesInTypeVO.getCaseType().get("typeName").toString());
                        if (casesInTypeVO.getCases() == null) {
                            casesInTypeVO.setCases(new ArrayList<>());
                        }
                        if (casesInTypeVO.getCases().size() < 6) {
                            casesInTypeVO.getCases().add(caseBaseVO);
                        }
                    }
                }
            }

            Iterator<CasesInTypeVO> it = casesInTypeVOS.iterator();
            while(it.hasNext()){
                CasesInTypeVO x = it.next();
                if(x.getCases() == null){
                    it.remove();
                }
            }

            result.setModel(casesInTypeVOS);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }


    @Override
    public BaseResult<BaseGetList> getTeaLectureService(Integer page, Integer pageSize) {
        BaseResult<BaseGetList> result = new BaseResult<>();
        try {
            BaseGetList baseGetList = new BaseGetList();
            baseGetList.setPage(page);
            baseGetList.setPageSize(pageSize);

            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setPageSize(pageSize);
            baseQuery.setPage(page);
            List<TeaLectureEntity> teaLectureEntities = commonDAO.queryList(
                    baseQuery , TeaLectureEntity.class, null ,null
            );
            baseGetList.setTotalCount(commonDAO.count(new BaseQuery() , TeaLectureEntity.class));
            baseGetList.setItems(teaLectureEntities);
            result.setModel(baseGetList);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<BaseGetList> getTeaDIYService(Integer page, Integer pageSize) {
        BaseResult<BaseGetList> result = new BaseResult<>();
        try {
            BaseGetList baseGetList = new BaseGetList();
            baseGetList.setPage(page);
            baseGetList.setPageSize(pageSize);

            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setPageSize(pageSize);
            baseQuery.setPage(page);
            List<TeaDIYEntity> teaDIYEntities = commonDAO.queryList(baseQuery , TeaDIYEntity.class , null , null);
            baseGetList.setTotalCount(commonDAO.count(new BaseQuery() , TeaDIYEntity.class));
            baseGetList.setItems(teaDIYEntities);
            result.setModel(baseGetList);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<BaseGetList> getTeaPerformService(Integer page, Integer pageSize) {
        BaseResult<BaseGetList> result = new BaseResult<>();
        try {
            BaseGetList baseGetList = new BaseGetList();
            baseGetList.setPage(page);
            baseGetList.setPageSize(pageSize);

            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setPageSize(pageSize);
            baseQuery.setPage(page);
            List<TeaPerformEntity> teaPerformEntities = commonDAO.queryList(
                    baseQuery , TeaPerformEntity.class , null , null
            );
            baseGetList.setTotalCount(commonDAO.count(baseQuery , TeaPerformEntity.class));
            baseGetList.setItems(teaPerformEntities);
            result.setModel(baseGetList);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }
}
