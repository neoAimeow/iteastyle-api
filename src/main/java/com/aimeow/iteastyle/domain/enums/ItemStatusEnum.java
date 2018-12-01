package com.aimeow.iteastyle.domain.enums;

public enum ItemStatusEnum {
    Enable(1 , "开启"),
    Close(-1 , "关闭")
            ;
    private Integer value;
    private String description;

    ItemStatusEnum(Integer value ,String description) {
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
