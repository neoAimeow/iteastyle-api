package com.aimeow.iteastyle.Authentification.entity;

import java.util.Collection;
import java.util.List;

import com.aimeow.domain.BaseEntity;
import lombok.Data;

/**
 * Created on 2018/7/25 11:57 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Data
public class AdminUserEntity extends BaseEntity {
    private String userName;
    private String password;
    private Short status;
    private List<String> roles;
}
