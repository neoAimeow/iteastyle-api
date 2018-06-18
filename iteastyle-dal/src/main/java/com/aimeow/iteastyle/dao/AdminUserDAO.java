package com.aimeow.iteastyle.dao;

import java.util.List;

import com.aimeow.iteastyle.domain.AdminUserDO;
import com.aimeow.iteastyle.domain.query.AdminUserQuery;

public interface AdminUserDAO {

    AdminUserDO queryAdminUserById(
            AdminUserQuery query
    ) throws Exception;
    List<AdminUserDO> queryAdminUsers(
            AdminUserQuery query
    ) throws Exception;

    Boolean createAdminUser(
            AdminUserDO adminUserDO
    ) throws Exception;
    Boolean updateAdminUser(
            AdminUserDO adminUserDO
    ) throws Exception;
    Boolean removeAdminUser(
            String adminUserId
    ) throws Exception;
}
