package com.aimeow.iteastyle.dao.impl;

import java.util.List;

import com.aimeow.iteastyle.dao.AdminUserDAO;
import com.aimeow.iteastyle.domain.AdminUserDO;
import com.aimeow.iteastyle.domain.query.AdminUserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class AdminUserDAOImpl implements AdminUserDAO {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public AdminUserDO queryAdminUserById(AdminUserQuery queryCondition) throws Exception {
        Query query=new Query(Criteria.where("id").is(queryCondition.getAdminUserId()));
        AdminUserDO user =  mongoTemplate.findOne(query , AdminUserDO.class);
        return user;
    }

    @Override
    public List<AdminUserDO> queryAdminUsers(AdminUserQuery query) throws Exception {
        return null;
    }

    @Override
    public Boolean createAdminUser(AdminUserDO adminUserDO) throws Exception {
        mongoTemplate.save(adminUserDO);
        return true;
    }

    @Override
    public Boolean updateAdminUser(AdminUserDO adminUserDO) throws Exception {
        Query query=new Query(Criteria.where("id").is(adminUserDO.getId()));

        Update update= new Update()
            .set("userName", adminUserDO.getUserName())
            .set("userNick", adminUserDO.getUserNick())
            .set("fullName" , adminUserDO.getFullName())
            .set("phone" , adminUserDO.getPhone())
            .set("identifier", adminUserDO.getIdentifier())
            .set("mail", adminUserDO.getMail());

        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,AdminUserDO.class);
        return true;
    }

    @Override
    public Boolean removeAdminUser(Long adminUserId) throws Exception {
        Query query=new Query(Criteria.where("id").is(adminUserId));
        mongoTemplate.remove(query,AdminUserDO.class);
        return null;
    }
}
