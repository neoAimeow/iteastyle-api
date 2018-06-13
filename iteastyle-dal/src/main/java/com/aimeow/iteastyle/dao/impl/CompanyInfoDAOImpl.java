package com.aimeow.iteastyle.dao.impl;

import com.aimeow.iteastyle.dao.CompanyInfoDAO;
import com.aimeow.iteastyle.domain.CompanyInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CompanyInfoDAOImpl implements CompanyInfoDAO {
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Override
    public CompanyInfoDO getCompanyInfo() throws Exception {
        return null;
    }

    @Override
    public Boolean replaceCompanyInfoData(CompanyInfoDO companyInfoDO) throws Exception {
        return null;
    }
}
