package com.aimeow.iteastyle.domain.enums;

/**
 * Created on 2018/10/31 下午11:56
 *
 * @author zhaoyi.w <a18814888787@gmail.com>
 */
public enum ContentTypeEnum {
    Post("post" , "文章类型"),
    Case("case" , "经典案例类型"),
    Event("event" , "小程序活动"),
    CompanyInfo("companyInfo" , "公司信息"),
    StaticData("staticData" , "静态信息")
    ;
    private String value;
    private String description;

    ContentTypeEnum(String value ,String description) {
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
