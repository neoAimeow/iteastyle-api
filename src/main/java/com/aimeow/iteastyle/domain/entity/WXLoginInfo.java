package com.aimeow.iteastyle.domain.entity;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class WXLoginInfo extends BaseEntity {
    private String code;
    private UserInfoEntity userInfo;
}
