package com.aimeow.iteastyle.base.tools.impl;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CommonDataImpl implements CommonData {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public <T extends BaseEntity> T getData(Class<T> cls) throws Exception {
        String value = redisTemplate.opsForValue().get(cls.getName());
        return JSONObject.parseObject(value , cls);
    }

    @Override
    public <T extends BaseEntity> Boolean edit(T t) throws Exception {
        redisTemplate.opsForValue().set(t.getClass().getName() , JSONObject.toJSONString(t));
        return true;
    }
}
