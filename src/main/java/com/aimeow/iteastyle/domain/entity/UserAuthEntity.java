package com.aimeow.iteastyle.domain.entity;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class UserAuthEntity extends BaseEntity {
    private String nickName;
    private String mobile;
    private String password;
    private String openId;
    private String avatarUrl;
}
