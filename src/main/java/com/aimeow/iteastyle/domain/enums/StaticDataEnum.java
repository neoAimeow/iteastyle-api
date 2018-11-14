package com.aimeow.iteastyle.domain.enums;

public enum StaticDataEnum {
    NORMAL("common" , "iteastyle-common-data" , "基础数据"),
    TEA_BREAK_SERVICE("teaBreak" , "iteastyle-tea-break-service" , "茶歇服务内容"),
    TEA_GIFT_SERVICE("teaGift" , "iteastyle-tea-gift-service" , "杭州伴手礼"),
    CASE_TYPE("caseType" , "iteastyle-case-type" , "经典案例类型"),
            ;
    private String name;
    private String key;
    private String description;

    StaticDataEnum(String name, String key, String description) {
        this.name = name;
        this.key = key;
        this.description = description;
    }


    public static StaticDataEnum getEnumByValue(String value) {
        for (StaticDataEnum staticDataEnum : StaticDataEnum.values()) {
            if (staticDataEnum.getName().equals(value)) {
                return staticDataEnum;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
