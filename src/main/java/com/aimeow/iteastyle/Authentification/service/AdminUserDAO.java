package com.aimeow.iteastyle.Authentification.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import com.aimeow.domain.BaseQuery;
import com.aimeow.iteastyle.Authentification.entity.AdminUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AdminUserDAO implements UserDetailsService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query=new Query(Criteria.where("userName").is(username));
        AdminUserEntity td =  mongoTemplate.findOne(query , AdminUserEntity.class);
        return td;
    }

    public AdminUserEntity queryById(String id) throws Exception {
        Query query=new Query(Criteria.where("id").is(id));
        AdminUserEntity td =  mongoTemplate.findOne(query , AdminUserEntity.class);
        return td;
    }

    public List<AdminUserEntity> queryList(BaseQuery query, String orderBy, Boolean isDESC) throws Exception {
        Query q = new Query();
        if (!StringUtils.isEmpty(orderBy)) {
            if (isDESC != null) {
                q.with(new Sort(isDESC.booleanValue() ? Direction.DESC : Direction.ASC, new String[]{orderBy}));
            } else {
                q.with(new Sort(Direction.DESC, new String[]{orderBy}));
            }
        } else {
            q.with(new Sort(Direction.DESC, new String[]{"gmtModified"}));
        }

        query.setPage(query.getPage() != null && query.getPage().intValue() != 0 ? query.getPage().intValue() : 1);
        query.setPageSize(query.getPageSize() != null && query.getPageSize().intValue() != 0 ? query.getPageSize().intValue() : 10);
        q.skip((long)((query.getPage().intValue() - 1) * query.getPageSize().intValue())).limit(query.getPageSize().intValue());
        List<AdminUserEntity> dos = this.mongoTemplate.find(q, AdminUserEntity.class);
        return dos;
    }

    public Long count(BaseQuery baseQuery) throws Exception {
        Query q = new Query();
        return mongoTemplate.count(q, AdminUserEntity.class);
    }

    public Boolean save(AdminUserEntity userEntity) throws Exception {
        userEntity.setGmtCreate(new Date());
        userEntity.setGmtModified(new Date());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(userEntity.getPassword());
        userEntity.setPassword(encode);

        if (StringUtils.isEmpty(userEntity.getId())) {
            mongoTemplate.save(userEntity);
        } else {
            JSONObject domainObject = JSONObject.parseObject(JSONObject.toJSONString(userEntity));

            Query query=new Query(Criteria.where(
                "id").is(userEntity.getId()));

            Iterator iterator = domainObject.entrySet().iterator();
            Update update= new Update();

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

            mongoTemplate.updateFirst(query,update,AdminUserEntity.class);

        }
        return true;
    }

    public Boolean delete(String id) throws Exception {
        Query query = new Query(Criteria.where("id").is(id));
        this.mongoTemplate.remove(query, AdminUserEntity.class);
        return true;
    }
}
