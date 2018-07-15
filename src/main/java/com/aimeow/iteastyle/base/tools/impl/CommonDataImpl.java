package com.aimeow.iteastyle.base.tools.impl;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CommonDataImpl implements CommonData {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public <T extends BaseEntity> T getData(Class<T> cls) throws Exception {
        Query query=new Query();
        T data =  mongoTemplate.findOne(query , cls);
        return data;
    }

    @Override
    public <T extends BaseEntity> Boolean edit(T t, Class<T> cls) throws Exception {
        List<T> lists = mongoTemplate.findAll(cls);
        for (T item:lists) {
            mongoTemplate.remove(item);
        }

        t.setGmtCreate(new Date());
        t.setGmtModified(new Date());
        mongoTemplate.save(t);
        return true;
    }


}
