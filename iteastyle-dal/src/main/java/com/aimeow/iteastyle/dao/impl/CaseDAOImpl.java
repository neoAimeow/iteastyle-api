package com.aimeow.iteastyle.dao.impl;

import com.aimeow.iteastyle.dao.CaseDAO;
import com.aimeow.iteastyle.domain.CaseDO;
import com.aimeow.iteastyle.domain.query.CaseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CaseDAOImpl implements CaseDAO {
    @Autowired private MongoTemplate mongoTemplate;

    @Override
    public CaseDO queryCaseById(CaseQuery caseQuery) {
        Query query=new Query(Criteria.where("id").is(
                caseQuery.getCaseId()));
        CaseDO post =  mongoTemplate.findOne(
                query , CaseDO.class
        );
        return post;
    }

    @Override
    public List<CaseDO> queryCases(CaseQuery caseQuery) {
        Query query=new Query(Criteria.where("type").is(
                caseQuery.getType()));
        query.with(new Sort(Sort.Direction.DESC, "gmtModified"));
        query.skip((caseQuery.getPage()-1) * caseQuery.getPageSize()).limit(caseQuery.getPageSize());
        List<CaseDO> caseDOS =  mongoTemplate.find(
                query , CaseDO.class
        );
        return caseDOS;
    }

    @Override
    public Long countCases(CaseQuery caseQuery) {
        Query query=new Query(Criteria.where("type").is(
                caseQuery.getType()));
        return mongoTemplate.count(query, CaseDO.class);
    }

    @Override
    public Boolean createCase(CaseDO caseDO) {
        caseDO.setGmtCreate(new Date());
        caseDO.setGmtModified(new Date());
        mongoTemplate.save(caseDO);
        return true;
    }

    @Override
    public Boolean updateCase(CaseDO caseDO) {
        caseDO.setGmtModified(new Date());
        Query query=new Query(Criteria.where(
                "id").is(caseDO.getId()));

        Update update= new Update()
                .set("title", caseDO.getTitle())
                .set("imageArr", caseDO.getImageArr());

        mongoTemplate.updateFirst(query,update,CaseDO.class);
        return true;
    }

    @Override
    public Boolean deleteCaseById(String caseId) {
        Query query=new Query(Criteria.where("id").is(caseId));
        mongoTemplate.remove(query,CaseDO.class);
        return true;
    }
}
