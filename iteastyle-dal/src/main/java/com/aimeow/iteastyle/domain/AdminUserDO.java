package com.aimeow.iteastyle.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class AdminUserDO {
    @Id
    private String id;
    private String userName;
    private String userNick;
    private String fullName;
    private String phone;
    private String identifier;
    private String mail;
}
