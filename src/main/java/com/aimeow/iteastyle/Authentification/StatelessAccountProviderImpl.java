package com.aimeow.iteastyle.Authentification;

import java.util.Set;

import com.aimeow.iteastyle.Authentification.service.AdminUserService;
import com.aimeow.tools.CommonDAO;
import org.apache.shiro.authc.AuthenticationException;
import org.jsets.shiro.service.ShiroStatelessAccountProvider;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2018/7/25 3:34 PM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
public class StatelessAccountProviderImpl implements ShiroStatelessAccountProvider {
    @Autowired private AdminUserService adminUserService;

    @Override
    public boolean checkAccount(String account) throws AuthenticationException {
        return false;
    }

    @Override
    public Set<String> loadPermissions(String account) {
        return null;
    }

    @Override
    public Set<String> loadRoles(String account) {
        return null;
    }

    @Override
    public String loadAppKey(String s) {
        return null;
    }
}
