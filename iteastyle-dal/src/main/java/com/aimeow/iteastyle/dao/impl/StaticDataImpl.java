package com.aimeow.iteastyle.dao.impl;

import java.util.List;

import com.aimeow.iteastyle.dao.StaticDataDAO;
import com.aimeow.iteastyle.domain.StaticDataDO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class StaticDataImpl implements StaticDataDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public StaticDataDO getStaticData() throws Exception {
        Query query=new Query();
        StaticDataDO staticDataDO =  mongoTemplate
            .findOne(query , StaticDataDO.class);
        return staticDataDO;
    }

    @Override
    public Boolean replaceStaticData(
        @NonNull StaticDataDO staticDataDO
    ) throws Exception {
        List<StaticDataDO> lists = mongoTemplate
            .findAll(StaticDataDO.class);
        lists.iterator().forEachRemaining(
            obj-> {
                mongoTemplate.remove(obj);
            }
        );

        mongoTemplate.save(staticDataDO);
        return true;
    }
}
