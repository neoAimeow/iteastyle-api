package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.entity.WXLoginInfo;
import com.aimeow.iteastyle.tools.domain.BaseResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(value = "/user",tags = {"用户接口"}, description = "用户操作接口")
@RequestMapping(value = "/user")
@RestController
public interface WXAuthService {

    /**
     * 账号登录
     *
     * @param body    请求内容，{ username: xxx, password: xxx }
     * @param request 请求对象
     * @return 登录结果
     */
    @PostMapping("login")
    BaseResult login(@RequestBody String body, HttpServletRequest request);

    /**
     * 微信登录
     *
     * @param body
     * @param request     请求对象
     * @return 登录结果
     */
    @PostMapping("wxlogin")
    BaseResult loginByWeixin(@RequestBody String body, HttpServletRequest request);

    /**
     * 账号注册
     *
     * @param body    请求内容
     */
    @PostMapping("register")
    BaseResult register(@RequestBody String body, HttpServletRequest request);

    /**
     * 账号通过微信注册
     *
     * @param
     */
    @PostMapping("wxregister")
    BaseResult wxRegister(@RequestBody String body, HttpServletRequest request);

    /**
     * 重置密码
     *
     * @param body    请求内容
     */
    @PostMapping("resetPassword")
    BaseResult resetPassword(@RequestBody String body, HttpServletRequest request);

    /**
     * 发送验证码
     *
     * @param body    请求内容
     */
    @PostMapping("sendSms")
    BaseResult sendSms(@RequestBody String body, HttpServletRequest request);


}
