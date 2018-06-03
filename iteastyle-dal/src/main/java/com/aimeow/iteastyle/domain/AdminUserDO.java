package com.aimeow.iteastyle.domain;

import lombok.Data;

@Data
public class AdminUserDO {
    private String userName;
    private String userNick;
    private String fullName;
    private String phone;
    private String identifier;
    private String mail;
}
