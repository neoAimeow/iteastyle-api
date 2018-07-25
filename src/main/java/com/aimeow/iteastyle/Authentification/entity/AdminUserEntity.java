package com.aimeow.iteastyle.Authentification.entity;

import java.util.Collection;
import java.util.List;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import org.apache.shiro.authc.Account;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.data.annotation.Id;

/**
 * Created on 2018/7/25 11:57 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Data
public class AdminUserEntity extends BaseEntity implements Account {
    private String userName;
    private String password;
    private Short status;
    private List<String> roles;

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public PrincipalCollection getPrincipals() {
        return null;
    }

    @Override
    public Collection<Permission> getObjectPermissions() {
        return null;
    }

    @Override
    public Collection<String> getStringPermissions() {
        return null;
    }
}
