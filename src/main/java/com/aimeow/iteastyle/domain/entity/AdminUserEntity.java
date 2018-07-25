package com.aimeow.iteastyle.domain.entity;

import java.util.List;

import lombok.Data;

/**
 * Created on 2018/7/25 11:57 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Data
public class AdminUserEntity {
    private String id;
    private String userName;
    private String password;
    private List<String> roles;
}
