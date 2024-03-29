package com.aimeow.iteastyle.tools.tools.impl;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import com.aimeow.iteastyle.tools.domain.BaseQuery;
import com.aimeow.iteastyle.tools.tools.CommonDAO;
import com.alibaba.fastjson.JSONObject;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class CommonDAOImpl implements CommonDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public <TD extends BaseEntity,TQ extends BaseQuery> List<TD> queryList(
                    @NonNull TQ query, Class<TD> cls , String orderBy , Boolean isDESC) throws Exception {
        Query q = parseQuery(query);
        if (!StringUtils.isEmpty(orderBy)) {
            if (isDESC!= null) {
                q.with(new Sort(isDESC?Sort.Direction.DESC:Sort.Direction.ASC, orderBy));
            } else {
                q.with(new Sort(Sort.Direction.DESC, orderBy));
            }
        } else {
            q.with(new Sort(Sort.Direction.DESC, "gmtModified"));
        }

        query.setPage((query.getPage()==null || query.getPage()==0)?1:query.getPage());
        query.setPageSize((query.getPageSize()==null || query.getPageSize()==0)?10:query.getPageSize());

        q.skip((query.getPage()-1) * query.getPageSize()).limit(query.getPageSize());
        List<TD> dos =  mongoTemplate.find(q , cls);
        return dos;
    }

    @Override
    public <TD extends BaseEntity> TD queryById(
            @NonNull String id, @NonNull Class<TD> cls) throws Exception {
        Query query=new Query(Criteria.where("id").is(id));
        TD td =  mongoTemplate.findOne(query , cls);
        return td;
    }

    @Override
    public <TD extends BaseEntity> List<TD> queryByParam(
            Map<String, Object> param, Class<TD> cls , String orderBy , Boolean isDESC) {
        Query query=new Query();
        if (!StringUtils.isEmpty(orderBy)) {
            if (isDESC!= null) {
                query.with(new Sort(isDESC?Sort.Direction.DESC:Sort.Direction.ASC, orderBy));
            } else {
                query.with(new Sort(Sort.Direction.DESC, orderBy));
            }
        } else {
            query.with(new Sort(Sort.Direction.DESC, "gmtModified"));
        }

        Iterator iterator = param.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = entry.getKey().toString();
            Object val = entry.getValue();
            System.out.println(key+"|"+val);
            query.addCriteria(Criteria.where(key).is(val));
        }

        return mongoTemplate.find(query , cls);
    }

    @Override
    public <TD extends BaseEntity> List<TD> queryAllList(Class<TD> cls , String orderBy , Boolean isDESC) {
        Query query = new Query();
        if (!StringUtils.isEmpty(orderBy)) {
            if (isDESC!= null) {
                query.with(new Sort(isDESC?Sort.Direction.DESC:Sort.Direction.ASC, orderBy));
            } else {
                query.with(new Sort(Sort.Direction.DESC, orderBy));
            }
        } else {
            query.with(new Sort(Sort.Direction.DESC, "gmtModified"));
        }

        List<TD> dos =  mongoTemplate.find(query,cls);
        return dos;
    }

    @Override
    public <TD extends BaseEntity,TQ extends BaseQuery> Long count(
            @NonNull TQ query, Class<TD> cls) throws Exception {
        Query q = parseQuery(query);
        return mongoTemplate.count(q, cls);
    }

    @Override
    public <TD extends BaseEntity> Boolean create(
            @NonNull TD domain) throws Exception {
        JSONObject domainObject = JSONObject.parseObject(JSONObject.toJSONString(domain));
        Iterator iterator = domainObject.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = entry.getKey().toString();
            Object val = entry.getValue();

            if ("id".equals(key)) {
                continue;
            }
            if ("gmtCreate".equals(key)) {
                continue;
            }
            if ("gmtModified".equals(key)) {
                continue;
            }
            if (StringUtils.isEmpty(val)) {
                throw new Exception(domain.getClass().getName() + " parameter " + key + " cannot be null");
            }
        }

        domain.setGmtCreate(new Date());
        domain.setGmtModified(new Date());
        mongoTemplate.save(domain);
        return true;
    }

    @Override
    public <TD extends BaseEntity> Boolean update(
            @NonNull TD domain , Class<TD> cls) throws Exception {
        JSONObject domainObject = JSONObject.parseObject(JSONObject.toJSONString(domain));

        Query query = new Query(Criteria.where(
                "id").is(domain.getId()));

        Update update = getUpdateData(domainObject);

        mongoTemplate.updateFirst(query,update,cls);
        return true;
    }

    @Override
    public <TD extends BaseEntity> Boolean updateById(TD domain, Class<TD> cls) {
        JSONObject domainObject = JSONObject.parseObject(JSONObject.toJSONString(domain));

        Query query = new Query();

        Update update = getUpdateData(domainObject);

        mongoTemplate.updateMulti(query,update,cls);
        return true;
    }

    @Override
    public <TD extends BaseEntity> Boolean delete(
            @NonNull String id, Class<TD> cls) {
        Query query=new Query(
                Criteria.where("id").is(id));
        mongoTemplate.remove(query,cls);
        return true;
    }

    @Override
    public <TD extends BaseEntity> Boolean clear(Class<TD> cls) {
        List<TD> lists = mongoTemplate.findAll(cls);
        lists.iterator().forEachRemaining(
                obj-> {
                    mongoTemplate.remove(obj);
                }
        );
        return true;
    }


    private <TD extends BaseEntity,TQ extends BaseQuery> Query parseQuery(TQ query) {
        JSONObject queryObject = JSONObject.parseObject(JSONObject.toJSONString(query));
        Query q=new Query();

        Iterator iterator = queryObject.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = entry.getKey().toString();
            Object val = entry.getValue();

            if ("page".equals(key)) {
                continue;
            }
            if ("pageSize".equals(key)) {
                continue;
            }
            q.addCriteria(Criteria.where(key).is(val));
        }
        return q;
    }

    private Update getUpdateData(JSONObject object) {
        Update update= new Update();
        Iterator iterator = object.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = entry.getKey().toString();
            Object val = entry.getValue();
            if ("id".equals(key)) {
                continue;
            }
            if ("gmtCreate".equals(key)) {
                continue;
            }
            if ("gmtModified".equals(key)) {
                val = new Date();
            }
            update.set(key , val);
        }
        return update;
    }
}
