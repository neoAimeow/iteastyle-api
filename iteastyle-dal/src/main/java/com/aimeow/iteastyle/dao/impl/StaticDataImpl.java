package com.aimeow.iteastyle.dao.impl;

import com.aimeow.iteastyle.dao.StaticDataDAO;
import com.aimeow.iteastyle.domain.StaticDataDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class StaticDataImpl implements StaticDataDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public StaticDataDO getStaticData() throws Exception {
        return null;
    }

    @Override
    public Boolean replaceStaticData(StaticDataDO staticDataDO) throws Exception {
        return null;
    }
}
