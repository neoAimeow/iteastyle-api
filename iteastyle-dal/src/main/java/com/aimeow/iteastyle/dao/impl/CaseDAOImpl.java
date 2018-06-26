package com.aimeow.iteastyle.dao.impl;

import com.aimeow.iteastyle.dao.CaseDAO;
import com.aimeow.iteastyle.domain.CaseDO;
import com.aimeow.iteastyle.domain.query.CaseQuery;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Component
public class CaseDAOImpl implements CaseDAO {
    @Autowired private MongoTemplate mongoTemplate;

    @Override
    public CaseDO queryCaseById(@NonNull CaseQuery caseQuery) throws Exception {
        Query query=new Query(Criteria.where("id").is(
                caseQuery.getCaseId()));
        CaseDO post =  mongoTemplate.findOne(
                query , CaseDO.class
        );
        return post;
    }

    @Override
    public List<CaseDO> queryCases(@NonNull CaseQuery caseQuery) throws Exception {
        Query query=new Query();
        if (caseQuery.getType() == null) {
            query.addCriteria(Criteria.where("type").is(
                    caseQuery.getType()));
        }

        query.with(new Sort(Sort.Direction.DESC, "gmtModified"));
        query.skip((caseQuery.getPage()-1) * caseQuery.getPageSize()).limit(caseQuery.getPageSize());
        List<CaseDO> caseDOS =  mongoTemplate.find(
                query , CaseDO.class
        );
        return caseDOS;
    }

    @Override
    public Long countCases(@NonNull CaseQuery caseQuery) throws Exception {
        Query query=new Query(Criteria.where("type").is(
                caseQuery.getType()));
        return mongoTemplate.count(query, CaseDO.class);
    }

    @Override
    public Boolean createCase(@NonNull CaseDO caseDO) throws Exception {
        if (StringUtils.isEmpty(caseDO.getTitle())) {
            throw new Exception("title can not be null");
        }
        if (StringUtils.isEmpty(caseDO.getType())) {
            throw new Exception("type can not be null");
        }
        if (null == caseDO.getImageArr() || caseDO.getImageArr().size() == 0) {
            throw new Exception("imageArr can not be null");
        }

        caseDO.setGmtCreate(new Date());
        caseDO.setGmtModified(new Date());
        mongoTemplate.save(caseDO);
        return true;
    }

    @Override
    public Boolean updateCase(@NonNull CaseDO caseDO) throws Exception {
        if (StringUtils.isEmpty(caseDO.getId())) {
            throw new Exception("id can not be null");
        }
        if (StringUtils.isEmpty(caseDO.getTitle())) {
            throw new Exception("title can not be null");
        }
        if (StringUtils.isEmpty(caseDO.getType())) {
            throw new Exception("type can not be null");
        }
        if (null == caseDO.getImageArr() || caseDO.getImageArr().size() == 0) {
            throw new Exception("imageArr can not be null");
        }

        caseDO.setGmtModified(new Date());
        Query query=new Query(Criteria.where(
                "id").is(caseDO.getId()));

        Update update= new Update()
                .set("title", caseDO.getTitle())
                .set("type" , caseDO.getType())
                .set("imageArr", caseDO.getImageArr());

        mongoTemplate.updateFirst(query,update,CaseDO.class);
        return true;
    }

    @Override
    public Boolean deleteCaseById(@NonNull String caseId) throws Exception {
        Query query=new Query(Criteria.where("id").is(caseId));
        mongoTemplate.remove(query,CaseDO.class);
        return true;
    }
}
