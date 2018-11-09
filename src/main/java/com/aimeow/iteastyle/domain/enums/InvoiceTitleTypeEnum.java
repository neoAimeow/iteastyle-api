package com.aimeow.iteastyle.domain.enums;

public enum InvoiceTitleTypeEnum {
    Personal(1 , "个人/非企业单位"),
    Company(2 , "企业")
    ;
    private Integer value;
    private String description;

    InvoiceTitleTypeEnum(Integer value ,String description) {
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
