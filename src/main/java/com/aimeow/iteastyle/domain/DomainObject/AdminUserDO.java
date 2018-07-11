package com.aimeow.iteastyle.domain.DomainObject;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Data
public class AdminUserDO extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8917531975813374747L;
    @Id
    private String userName;
    private String password;
    private String userNick;
    private String fullName;
    private String phone;
    private String identifier;
    private String mail;
}
