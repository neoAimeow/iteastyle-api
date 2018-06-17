package com.aimeow.iteastyle.dao.impl;

import com.aimeow.iteastyle.dao.LogDAO;
import com.aimeow.iteastyle.domain.LogDO;
import com.aimeow.iteastyle.domain.query.LogQuery;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LogDAOImpl implements LogDAO {
    @Autowired private MongoTemplate mongoTemplate;
    @Override
    public LogDO queryLogs(@NonNull LogQuery query) {

        return null;
    }

    @Override
    public Boolean record(
            @NonNull LogDO logDO) {
        logDO.setGmtCreate(new Date());
        logDO.setGmtModified(new Date());
        mongoTemplate.save(logDO);
        return true;
    }

    @Override
    public Boolean removeRecord(
            @NonNull String logId) {
        Query query=new Query(
                Criteria.where("id").is(logId));
        mongoTemplate.remove(query,LogDO.class);
        return true;
    }


    @Override
    public Boolean clearRecord() {
        return null;
    }
}
