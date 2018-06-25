package com.aimeow.iteastyle.dao.impl;

import com.aimeow.iteastyle.dao.LogDAO;
import com.aimeow.iteastyle.domain.LogDO;
import com.aimeow.iteastyle.domain.query.LogQuery;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Component
public class LogDAOImpl implements LogDAO {
    @Autowired private MongoTemplate mongoTemplate;
    @Override
    public List<LogDO> queryLogs(
            @NonNull LogQuery logQuery) throws Exception {
        Query query=new Query();
        query.with(new Sort(Sort.Direction.DESC, "gmtModified"));
        query.skip((logQuery.getPage()-1) * logQuery.getPageSize()).limit(logQuery.getPageSize());
        List<LogDO> logDOS =  mongoTemplate.find(
                query , LogDO.class
        );
        return logDOS;
    }

    @Override
    public Boolean record(
            @NonNull LogDO logDO) throws Exception {
        if (StringUtils.isEmpty(logDO.getContent())) {
            throw new Exception("content can not be null");
        }
        if (StringUtils.isEmpty(logDO.getOperator())) {
            throw new Exception("operator can not be null");
        }
        logDO.setGmtCreate(new Date());
        logDO.setGmtModified(new Date());
        mongoTemplate.save(logDO);
        return true;
    }

    @Override
    public Boolean removeRecord(
            @NonNull String logId) throws Exception {
        Query query=new Query(
                Criteria.where("id").is(logId));
        mongoTemplate.remove(query,LogDO.class);
        return true;
    }


    @Override
    public Boolean clearRecord() {
        List<LogDO> lists = mongoTemplate.findAll(LogDO.class);
        lists.iterator().forEachRemaining(
                obj-> {
                    mongoTemplate.remove(obj);
                }
        );
        return true;
    }
}
