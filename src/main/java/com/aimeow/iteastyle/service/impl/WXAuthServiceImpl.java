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
import com.aimeow.tools.MessageSender;
import com.aimeow.tools.RegexUtil;
import com.aimeow.tools.ResultUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
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
    @Autowired private MessageSender messageSender;

    @Override
    public BaseResult login(String body, HttpServletRequest request) {
        JSONObject object = JSONObject.parseObject(body);
        String mobile = object.getString("mobile");
        String password = object.getString("password");
        try {
            if (mobile == null || password == null) {
                return ResultUtil.getFailureResult(AuthErrorEnum.ParamMissing.getDescription()
                        , AuthErrorEnum.ParamMissing.getErrorCode());
            }

            List<UserAuthEntity> userInfoEntities = commonDAO.queryByParam(
                    new HashMap<String, Object>(){{put("mobile", mobile);}},
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
            userInfo.setNickName(user.getNickName());
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
    public BaseResult loginByWeixin(String body, HttpServletRequest request) {
        JSONObject object = JSONObject.parseObject(body);
        String code = object.getString("code");

        if (code == null) {
            return ResultUtil.getFailureResult(AuthErrorEnum.MissingCode.getDescription()
                    , AuthErrorEnum.MissingCode.getErrorCode());
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

            //if user not register, break and guide to register.
            if (userAuthEntities == null || userAuthEntities.isEmpty()) {
                return ResultUtil.getFailureResult(AuthErrorEnum.OpenIdNotExist.getDescription()
                        , AuthErrorEnum.OpenIdNotExist.getErrorCode());
            }

            UserAuthEntity user = userAuthEntities.get(0);

            UserToken userToken = UserTokenManager.generateToken(user.getId());
            userToken.setSessionKey(sessionKey);

            UserInfoEntity infoEntity = new UserInfoEntity();
            infoEntity.setAvatarUrl(user.getAvatarUrl());
            infoEntity.setNickName(user.getNickName());
            infoEntity.setMobile(user.getMobile());
            infoEntity.setId(user.getId());

            Map<Object, Object> response = new HashMap<Object, Object>();
            response.put("token", userToken.getToken());
            response.put("tokenExpire", userToken.getExpireTime().toString());
            response.put("userInfo", infoEntity);
            return ResultUtil.buildSuccessResult(new BaseResult<>(), response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getFailureResult(AuthErrorEnum.UnknownError.getDescription()
                    , AuthErrorEnum.UnknownError.getErrorCode());
        }

    }

    @Override
    public BaseResult register(String body, HttpServletRequest request) {
        JSONObject object = JSONObject.parseObject(body);
        String nickname = object.getString("nickname");
        String password = object.getString("password");
        String mobile = object.getString("mobile");
        String avatar = object.getString("avatar");

        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(mobile)) {
            return ResultUtil.getFailureResult(AuthErrorEnum.ParamMissing.getDescription()
                    , AuthErrorEnum.ParamMissing.getErrorCode());
        }

        try {
            if (!RegexUtil.isMobileExact(mobile)) {
                return ResultUtil.getFailureResult(AuthErrorEnum.MobileFormatIllegal.getDescription()
                        , AuthErrorEnum.MobileFormatIllegal.getErrorCode());
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

            //TODO:验证码校验

            UserAuthEntity authEntity = new UserAuthEntity();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(password);
            authEntity.setNickName(nickname);
            authEntity.setPassword(encodedPassword);
            authEntity.setMobile(mobile);
            authEntity.setAvatarUrl(avatar);
            commonDAO.create(authEntity);

            // userInfo
            UserInfoEntity userInfo = new UserInfoEntity();
            userInfo.setNickName(authEntity.getNickName());
            userInfo.setAvatarUrl(authEntity.getAvatarUrl());
            userInfo.setMobile(authEntity.getMobile());
            userInfo.setId(authEntity.getId());

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

    @Override
    public BaseResult wxRegister(String body, HttpServletRequest request) {
        JSONObject object = JSONObject.parseObject(body);
        String nickname = object.getString("nickname");
        String wxCode = object.getString("wxCode");
        String mobile = object.getString("mobile");
        String avatar = object.getString("avatar");

        if (StringUtils.isEmpty(mobile)) {
            return ResultUtil.getFailureResult(AuthErrorEnum.ParamMissing.getDescription()
                    , AuthErrorEnum.ParamMissing.getErrorCode());
        }

        try {
            if (!RegexUtil.isMobileExact(mobile)) {
                return ResultUtil.getFailureResult(AuthErrorEnum.MobileFormatIllegal.getDescription()
                        , AuthErrorEnum.MobileFormatIllegal.getErrorCode());
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

            UserAuthEntity authEntity = new UserAuthEntity();
            authEntity.setNickName(nickname);
            authEntity.setPassword(openId);
            authEntity.setMobile(mobile);
            authEntity.setOpenId(openId);
            authEntity.setAvatarUrl(avatar);
            commonDAO.create(authEntity);

            // userInfo
            UserInfoEntity userInfo = new UserInfoEntity();
            userInfo.setNickName(authEntity.getNickName());
            userInfo.setAvatarUrl(authEntity.getAvatarUrl());
            userInfo.setMobile(authEntity.getMobile());
            userInfo.setId(authEntity.getId());

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

    @Override
    public BaseResult resetPassword(String body, HttpServletRequest request) {
        return null;
    }

    @Override
    public BaseResult sendSms(String body, HttpServletRequest request) {
        return null;
    }
}
