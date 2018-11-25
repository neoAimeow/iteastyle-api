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
        String mobile = JSONObject.parseObject("mobile" , String.class);
        String password = JSONObject.parseObject("password" , String.class);
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
    public BaseResult loginByWeixin(JSONObject wxLoginInfo, HttpServletRequest request) {
        String code = wxLoginInfo.getString("code");
        JSONObject loginInfo = JSONObject.parseObject("userInfo");

        if (code == null || loginInfo == null) {
            return ResultUtil.getFailureResult(AuthErrorEnum.MissingCodeAndWXInfo.getDescription()
                    , AuthErrorEnum.MissingCodeAndWXInfo.getErrorCode());
        }
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setNickName(loginInfo.getString("nickName"));
        userInfoEntity.setAvatarUrl(loginInfo.getString("avatarUrl"));


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
        String nickname = JSONObject.parseObject("nickname" , String.class);
        String password = JSONObject.parseObject("password" , String.class);
        String mobile = JSONObject.parseObject("mobile" , String.class);
        String wxCode = JSONObject.parseObject("wxCode" , String.class);

        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(mobile)
                || StringUtils.isEmpty(wxCode)) {
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
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(password);
            authEntity.setNickName(nickname);
            authEntity.setPassword(encodedPassword);
            authEntity.setMobile(mobile);
            authEntity.setOpenId(openId);
            authEntity.setAvatarUrl("https://yanxuan.nosdn.127.net/80841d741d7fa3073e0ae27bf487339f.jpg?imageView&quality=90&thumbnail=64x64");
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


}
