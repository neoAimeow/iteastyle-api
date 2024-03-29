package com.aimeow.iteastyle.errorEnums;

public enum AuthErrorEnum {
    UserNotExist("user_not_exist" , "用户不存在，请确认是否注册过"),
    PasswordError("password_error" , "密码错误，请重新再输"),
    ParamMissing("param_is_missing" , "请求缺少必填的参数"),
    UnknownError("unknown_error" , "未知错误"),

    MissingCode("missing_code" , "登录缺少code"),
    OpenIdAndSessionKeyMissing("openid_and_session_key_missing" , "微信登录失败"),

    MobileExist("mobile_exist" , "手机号已经注册过"),
    MobileFormatIllegal("mobile_format_illegal" , "手机号格式错误"),
    OpenIdExist("openid_exist" , "openId已绑定帐号"),
    OpenIdNotExist("openid_not_exist" , "openId未绑定帐号,需要注册"),
    ;
    private String errorCode;
    private String description;

    AuthErrorEnum(String value ,String description) {
        this.errorCode = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
