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
    @Override
    public BaseResult<Boolean> login(String userName, String password) {
        return new BaseResult<>();
    }

    @Override
    public BaseResult<Boolean> signUp(AdminUserEntity credentials) {
        return new BaseResult<>();
    }
}
