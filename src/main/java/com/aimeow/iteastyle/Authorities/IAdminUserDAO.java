package com.aimeow.iteastyle.Authorities;

import com.aimeow.iteastyle.Authorities.entity.AdminUser;
import org.springframework.stereotype.Component;

@Component
public interface IAdminUserDAO {
    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    AdminUser findByUsername(String username);
    Boolean insert(AdminUser adminUser);
}
