package com.aimeow.iteastyle;

import java.util.ArrayList;
import java.util.List;

import com.aimeow.iteastyle.Authentification.entity.AdminUserEntity;
import com.aimeow.iteastyle.Authentification.service.AdminUserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created on 2018/7/27 4:25 PM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class AdminUserTest {
    @Autowired
    AdminUserDAO adminUserDAO;

    @Test public void testAdmin() throws Exception {
        AdminUserEntity  entity = new AdminUserEntity();
        entity.setUserName("admin");
        entity.setPassword("123");
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        entity.setRoles(roles);
        adminUserDAO.save(entity);

    }
}
