package com.aimeow.iteastyle.Authentification.service;

import com.aimeow.iteastyle.Authentification.entity.AdminUserEntity;
import com.aimeow.iteastyle.tools.domain.BaseResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/7/27 11:22 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Api(value = "/adminUser",tags = {"管理用户管理"}, description = "管理用户管理")
@RequestMapping(value = "/adminUser")
@RestController
public interface AdminUserService {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    BaseResult<Boolean> login(String userName, String password);

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    BaseResult<Boolean> signUp(AdminUserEntity credentials);
}
