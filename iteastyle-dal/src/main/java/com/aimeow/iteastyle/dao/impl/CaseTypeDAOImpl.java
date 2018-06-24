package com.aimeow.iteastyle.dao.impl;

import com.aimeow.iteastyle.dao.CaseTypeDAO;
import com.aimeow.iteastyle.domain.CaseTypeDO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaseTypeDAOImpl implements CaseTypeDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public CaseTypeDO getCaseTypeByTypeCode(
            @NonNull Integer type) {
        Query query=new Query(Criteria.where("type").is(type));
        CaseTypeDO caseTypeDO =  mongoTemplate.findOne(
                query , CaseTypeDO.class
        );
        return caseTypeDO;
    }

    @Override
    public List<CaseTypeDO> getCaseTypes() {
        List<CaseTypeDO> caseTypeDOS =  mongoTemplate.find(
                new Query() , CaseTypeDO.class
        );
        return caseTypeDOS;
    }

    @Override
    public Boolean createCaseType(CaseTypeDO caseTypeDO) {
        mongoTemplate.save(caseTypeDO);
        return true;
    }

    @Override
    public Boolean updateCaseType(CaseTypeDO caseTypeDO) {
        Query query=new Query(Criteria.where(
                "id").is(caseTypeDO.getId()));

        Update update= new Update()
                .set("type", caseTypeDO.getType())
                .set("typeName", caseTypeDO.getTypeName())
                .set("typeNameEn", caseTypeDO.getTypeNameEn())
                .set("typeImage", caseTypeDO.getTypeImage())
                .set("typeIcon", caseTypeDO.getTypeIcon());

        mongoTemplate.updateFirst(query,update,CaseTypeDO.class);
        return true;
    }

    @Override
    public Boolean removeCaseType(String caseTypeId) {
        Query query=new Query(
                Criteria.where("id").is(caseTypeId));
        mongoTemplate.remove(query,CaseTypeDO.class);
        return true;
    }
}
