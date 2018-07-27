package com.aimeow.iteastyle.Authentification.service.impl;

import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.Authentification.entity.AdminUserEntity;
import com.aimeow.iteastyle.Authentification.service.AdminUserService;
import org.springframework.stereotype.Component;

/**
 * Created on 2018/7/27 11:32 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Component
public class AdminUserServiceImpl implements AdminUserService {
//    @Override
//<<<<<<< HEAD
//    public Long count(BaseQuery baseQuery) throws Exception {
//        Query q = new Query();
//        return mongoTemplate.count(q, AdminUserEntity.class);
//    }
//
//    @Override
//    public Boolean save(AdminUserEntity userEntity) throws Exception {
//        userEntity.setGmtCreate(new Date());
//        userEntity.setGmtModified(new Date());
//        //userEntity.setPassword(ShiroUtils.password(userEntity.getPassword()));
//        if (StringUtils.isEmpty(userEntity.getId())) {
//            mongoTemplate.save(userEntity);
//        } else {
//            JSONObject domainObject = JSONObject.parseObject(JSONObject.toJSONString(userEntity));
//
//            Query query=new Query(Criteria.where(
//                "id").is(userEntity.getId()));
//
//            Iterator iterator = domainObject.entrySet().iterator();
//            Update update= new Update();
//
//            while (iterator.hasNext()) {
//                Map.Entry entry = (Map.Entry) iterator.next();
//                String key = entry.getKey().toString();
//                Object val = entry.getValue();
//                if ("id".equals(key)) {
//                    continue;
//                }
//                if ("gmtCreate".equals(key)) {
//                    continue;
//                }
//                if ("gmtModified".equals(key)) {
//                    val = new Date();
//                }
//                update.set(key , val);
//            }
//
//            mongoTemplate.updateFirst(query,update,AdminUserEntity.class);
//
//        }
//        return true;
//=======
    public BaseResult<Boolean> login(String userName, String password) {
        return new BaseResult<>();
    }

    @Override
    public BaseResult<Boolean> signUp(AdminUserEntity credentials) {
        return new BaseResult<>();
    }
}
