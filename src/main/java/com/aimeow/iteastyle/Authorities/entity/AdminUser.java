package com.aimeow.iteastyle.Authorities.entity;

import lombok.Data;

import java.util.List;

@Data
public class AdminUser {
    private String id;
    private String username;
    private String password;
    private List<String> roles;
}
