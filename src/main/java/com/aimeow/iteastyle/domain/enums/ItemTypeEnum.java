package com.aimeow.iteastyle.domain.enums;

public enum ItemTypeEnum {
    Normal(1 , "普通商品"),
    Plan(2 , "套餐端口")
    ;
    private Integer value;
    private String description;

    ItemTypeEnum(Integer value ,String description) {
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
