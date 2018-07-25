package com.aimeow.iteastyle.Authentification.service;

import java.util.List;
import java.util.Map;
import com.aimeow.domain.BaseQuery;
import com.aimeow.iteastyle.Authentification.entity.AdminUserEntity;

public interface AdminUserService {
    AdminUserEntity queryById(String id) throws Exception;
    List<AdminUserEntity> queryList(BaseQuery baseQuery, String orderBy, Boolean isDESC) throws Exception;
    Long count(BaseQuery baseQuery) throws Exception;
    Boolean save(AdminUserEntity userEntity) throws Exception;
    Boolean delete(String id) throws Exception;
}
