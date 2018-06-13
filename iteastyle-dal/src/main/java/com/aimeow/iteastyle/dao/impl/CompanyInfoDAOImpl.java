package com.aimeow.iteastyle.dao.impl;

import java.util.List;

import com.aimeow.iteastyle.dao.CompanyInfoDAO;
import com.aimeow.iteastyle.domain.CompanyInfoDO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class CompanyInfoDAOImpl implements CompanyInfoDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public CompanyInfoDO getCompanyInfo() throws Exception {
        Query query=new Query();
        CompanyInfoDO companyInfoDO =  mongoTemplate.findOne(query , CompanyInfoDO.class);
        return companyInfoDO;
    }

    @Override
    public Boolean replaceCompanyInfoData(
        @NonNull CompanyInfoDO companyInfoDO) throws Exception {
        List<CompanyInfoDO> lists = mongoTemplate.findAll(CompanyInfoDO.class);
        lists.iterator().forEachRemaining(
            obj-> {
                mongoTemplate.remove(obj);
            }
        );

        mongoTemplate.save(companyInfoDO);
        return true;
    }
}
