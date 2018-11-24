package com.aimeow.iteastyle.domain.entity;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class UserInfoEntity extends BaseEntity {
    private String nickName;
    private String avatarUrl;
    private String mobile;

}
