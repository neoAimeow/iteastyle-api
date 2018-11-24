package com.aimeow.iteastyle.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.UserAuthEntity;
import com.aimeow.iteastyle.domain.entity.UserInfoEntity;
import com.aimeow.iteastyle.domain.entity.UserToken;
import com.aimeow.iteastyle.domain.entity.WXLoginInfo;
import com.aimeow.iteastyle.errorEnums.AuthErrorEnum;
import com.aimeow.iteastyle.manager.UserTokenManager;
import com.aimeow.iteastyle.service.WXAuthService;
import com.aimeow.tools.CommonDAO;
import com.aimeow.tools.RegexUtil;
import com.aimeow.tools.ResultUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WXAuthServiceImpl implements WXAuthService {
    @Autowired private WxMaService wxService;
    @Autowired private CommonDAO commonDAO;


    @Override
    public BaseResult login(String body, HttpServletRequest request) {
        String username = JSONObject.parseObject("username" , String.class);
        String password = JSONObject.parseObject("password" , String.class);
        try {
            if (username == null || password == null) {
                return ResultUtil.getFailureResult(AuthErrorEnum.ParamMissing.getDescription()
                        , AuthErrorEnum.ParamMissing.getErrorCode());
            }

            List<UserAuthEntity> userInfoEntities = commonDAO.queryByParam(
                    new HashMap<String, Object>(){{put("userName", username);}},
                    UserAuthEntity.class,
                    null,
                    null);

            if (userInfoEntities == null || userInfoEntities.isEmpty()) {
                return ResultUtil.getFailureResult(AuthErrorEnum.UserNotExist.getDescription()
                        , AuthErrorEnum.UserNotExist.getErrorCode());
            }

            UserAuthEntity user = userInfoEntities.get(0);

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!encoder.matches(password, user.getPassword())) {
                return ResultUtil.getFailureResult(AuthErrorEnum.PasswordError.getDescription()
                        , AuthErrorEnum.PasswordError.getErrorCode());
            }

            // userInfo
            UserInfoEntity userInfo = new UserInfoEntity();
            userInfo.setNickName(username);
            userInfo.setAvatarUrl(user.getAvatarUrl());
            userInfo.setMobile(user.getMobile());

            // token
            UserToken userToken = UserTokenManager.generateToken(user.getId());

            Map<Object, Object> result = new HashMap<Object, Object>();
            result.put("token", userToken.getToken());
            result.put("tokenExpire", userToken.getExpireTime().toString());
            result.put("userInfo", userInfo);
            return ResultUtil.buildSuccessResult(new BaseResult<>(), result);

        } catch (Exception ex) {
            return ResultUtil.getFailureResult(AuthErrorEnum.UnknownError.getDescription()
                    , AuthErrorEnum.UnknownError.getErrorCode());
        }
    }

    @Override
    public BaseResult loginByWeixin(WXLoginInfo wxLoginInfo, HttpServletRequest request) {
        String code = wxLoginInfo.getCode();
        UserInfoEntity userInfo = wxLoginInfo.getUserInfo();

        if (code == null || userInfo == null) {
            return ResultUtil.getFailureResult(AuthErrorEnum.MissingCodeAndWXInfo.getDescription()
                    , AuthErrorEnum.MissingCodeAndWXInfo.getErrorCode());
        }

        String sessionKey = null;
        String openId = null;

        try {
            WxMaJscode2SessionResult result = this.wxService.getUserService().getSessionInfo(code);
            sessionKey = result.getSessionKey();
            openId = result.getOpenid();
            if (sessionKey == null || openId == null) {
                return ResultUtil.getFailureResult(AuthErrorEnum.OpenIdAndSessionKeyMissing.getDescription()
                        , AuthErrorEnum.OpenIdAndSessionKeyMissing.getErrorCode());
            }

            Map<String, Object> loginParam = new HashMap<>();
            loginParam.put("openId", openId);
            List<UserAuthEntity> userAuthEntities = commonDAO.queryByParam(
                    loginParam,
                    UserAuthEntity.class,
                    null,
                    null);
            UserAuthEntity user;
            if (userAuthEntities == null || userAuthEntities.isEmpty()) {
                user = new UserAuthEntity();
                user.setOpenId(openId);
                user.setPassword(openId);
                user.setNickName(userInfo.getNickName());
                user.setAvatarUrl(userInfo.getAvatarUrl());
            } else {
                user = userAuthEntities.get(0);
            }


            UserToken userToken = UserTokenManager.generateToken(user.getId());
            userToken.setSessionKey(sessionKey);

            Map<Object, Object> response = new HashMap<Object, Object>();
            response.put("token", userToken.getToken());
            response.put("tokenExpire", userToken.getExpireTime().toString());
            response.put("userInfo", userInfo);
            return ResultUtil.getFailureResult(AuthErrorEnum.UnknownError.getDescription()
                    , AuthErrorEnum.UnknownError.getErrorCode());

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getFailureResult(AuthErrorEnum.UnknownError.getDescription()
                    , AuthErrorEnum.UnknownError.getErrorCode());
        }

    }

    @Override
    public BaseResult register(String body, HttpServletRequest request) {
        String username = JSONObject.parseObject("username" , String.class);
        String nickname = JSONObject.parseObject("nickname" , String.class);
        String password = JSONObject.parseObject("password" , String.class);
        String mobile = JSONObject.parseObject("mobile" , String.class);
        String code = JSONObject.parseObject("code" , String.class);
        String wxCode = JSONObject.parseObject("wxCode" , String.class);

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(mobile)
                || StringUtils.isEmpty(wxCode) || StringUtils.isEmpty(code)) {
            return ResultUtil.getFailureResult(AuthErrorEnum.ParamMissing.getDescription()
                    , AuthErrorEnum.ParamMissing.getErrorCode());
        }

        try {
            List<UserAuthEntity> userNameEntities = commonDAO.queryByParam(
                    new HashMap<String, Object>(){{put("userName", username);}},
                    UserAuthEntity.class,
                    null,
                    null);

            if (userNameEntities != null && !userNameEntities.isEmpty()) {
                return ResultUtil.getFailureResult(AuthErrorEnum.UserExist.getDescription()
                        , AuthErrorEnum.UserExist.getErrorCode());
            }

            List<UserAuthEntity> userMobileEntities = commonDAO.queryByParam(
                    new HashMap<String, Object>(){{put("mobile", mobile);}},
                    UserAuthEntity.class,
                    null,
                    null);

            if (userMobileEntities != null && !userMobileEntities.isEmpty()) {
                return ResultUtil.getFailureResult(AuthErrorEnum.MobileExist.getDescription()
                        , AuthErrorEnum.MobileExist.getErrorCode());
            }

            if (!RegexUtil.isMobileExact(mobile)) {
                return ResultUtil.getFailureResult(AuthErrorEnum.MobileFormatIllegal.getDescription()
                        , AuthErrorEnum.MobileFormatIllegal.getErrorCode());
            }

            //TODO:验证码校验

            WxMaJscode2SessionResult result = this.wxService.getUserService().getSessionInfo(wxCode);
            String openId = result.getOpenid();

            List<UserAuthEntity> userEntities = commonDAO.queryByParam(
                    new HashMap<String, Object>(){{put("openId", openId);}},
                    UserAuthEntity.class,
                    null,
                    null);

            if (userEntities != null && !userEntities.isEmpty()) {
                return ResultUtil.getFailureResult(AuthErrorEnum.OpenIdExist.getDescription()
                        , AuthErrorEnum.OpenIdExist.getErrorCode());
            }
            if (userEntities.size() == 1) {
                UserAuthEntity checkUser = userEntities.get(0);
                String checkUsername = checkUser.getUserName();
                String checkPassword = checkUser.getPassword();
                if (!checkUsername.equals(openId) || !checkPassword.equals(openId)) {
                    return ResultUtil.getFailureResult(AuthErrorEnum.OpenIdExist.getDescription()
                            , AuthErrorEnum.OpenIdExist.getErrorCode());
                }
            }

            UserAuthEntity authEntity = new UserAuthEntity();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(password);
            authEntity.setUserName(username);
            authEntity.setNickName(nickname);
            authEntity.setPassword(encodedPassword);
            authEntity.setMobile(mobile);
            authEntity.setOpenId(openId);
            authEntity.setAvatarUrl("https://yanxuan.nosdn.127.net/80841d741d7fa3073e0ae27bf487339f.jpg?imageView&quality=90&thumbnail=64x64");
            commonDAO.create(authEntity);

            // userInfo
            UserInfoEntity userInfo = new UserInfoEntity();
            userInfo.setNickName(username);
            userInfo.setAvatarUrl(authEntity.getAvatarUrl());
            userInfo.setMobile(authEntity.getMobile());

            // token
            UserToken userToken = UserTokenManager.generateToken(authEntity.getId());

            Map<Object, Object> response = new HashMap<>();
            response.put("token", userToken.getToken());
            response.put("tokenExpire", userToken.getExpireTime().toString());
            response.put("userInfo", userInfo);
            return ResultUtil.buildSuccessResult(new BaseResult<>(), response);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ResultUtil.getFailureResult(AuthErrorEnum.UnknownError.getDescription()
                    , AuthErrorEnum.UnknownError.getErrorCode());
        }



    }
}
