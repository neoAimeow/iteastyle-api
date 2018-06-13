package com.aimeow.iteastyle.domain.enums;

public enum StatusEnum {
    ALL(99 , "all"),
    NORMAL(0 , "normal status"),
    OFFLINE(-1,"offline")
    ;
    private int status;
    private String name;

    StatusEnum(Integer status ,String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
