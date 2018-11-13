package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseQuery;
import com.aimeow.domain.BaseResult;
import com.aimeow.domain.BaseGetList;
import com.aimeow.tools.CommonDAO;
import com.aimeow.tools.CommonData;


import com.aimeow.iteastyle.domain.ViewObject.*;
import com.aimeow.iteastyle.domain.ViewObject.Case.CasesInTypeVO;
import com.aimeow.iteastyle.domain.entity.*;
import com.aimeow.iteastyle.domain.entity.service.TeaDIYEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaLectureEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaPerformEntity;
import com.aimeow.iteastyle.domain.enums.StatusEnum;
import com.aimeow.iteastyle.domain.query.CaseQuery;
import com.aimeow.iteastyle.domain.query.PostQuery;
import com.aimeow.iteastyle.service.WebDataService;
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
                    postEntity.setImageUrl("http://pazp3d0xt.bkt.clouddn.com/if%20no%20img.jpg");
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
    public BaseResult<List<CaseTypeEntity>> getCaseTypes() {
        BaseResult<List<CaseTypeEntity>> result = new BaseResult<>();
        try {

            List<CaseTypeEntity> caseTypeEntities = commonDAO.queryAllList(CaseTypeEntity.class,"rank",false);
            result.setModel(caseTypeEntities);
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

            Map<String, Object> map = new HashMap<>();
            map.put("type" , caseEntity.getType());
            List<CaseTypeEntity> caseTypeEntities = commonDAO.queryByParam(map, CaseTypeEntity.class, null, null);
            if (caseTypeEntities.size()>0) {
                caseEntity.setTypeName(caseTypeEntities.get(0).getTypeName());
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

            Map<String, Object> map = new HashMap<>();
            map.put("type" , type);
            List<CaseTypeEntity> caseTypeEntities = commonDAO.queryByParam(map, CaseTypeEntity.class, null , null);
            if (caseTypeEntities.size()>0) {
                CaseTypeEntity caseTypeVO = caseTypeEntities.get(0);
                casesInTypeVO.setCaseType(caseTypeVO);
            }

            List<CaseEntity> caseEntities = commonDAO.queryList(caseQuery, CaseEntity.class , null , null);
            caseEntities.iterator().forEachRemaining(
                    obj-> {
                        CaseEntity caseBaseVO = obj;
                        caseBaseVO.setTypeName(casesInTypeVO.getCaseType().getTypeName());
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
            List<CaseTypeEntity> caseTypeVOS = new ArrayList<>();
            List<CaseEntity> caseBaseVOS = new ArrayList<>();
            List<CaseEntity> caseEntities = commonDAO.queryAllList(
                CaseEntity.class,null,null);
            List<CaseTypeEntity> caseTypeEntities = commonDAO.queryList(
                new BaseQuery() , CaseTypeEntity.class, "rank" , false);

            for (CaseEntity caseEntity : caseEntities) {
                caseBaseVOS.add(caseEntity);
            }

            for (CaseTypeEntity caseTypeEntity : caseTypeEntities) {
                caseTypeVOS.add(caseTypeEntity);

                CasesInTypeVO casesInTypeVO = new CasesInTypeVO();
                casesInTypeVO.setCaseType(caseTypeEntity);
                casesInTypeVOS.add(casesInTypeVO);
            }

            for (CasesInTypeVO casesInTypeVO:casesInTypeVOS) {
                for (CaseEntity caseBaseVO: caseBaseVOS) {
                    if (caseBaseVO.getType().equals(casesInTypeVO.getCaseType().getType())) {
                        caseBaseVO.setTypeName(casesInTypeVO.getCaseType().getTypeName());
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
