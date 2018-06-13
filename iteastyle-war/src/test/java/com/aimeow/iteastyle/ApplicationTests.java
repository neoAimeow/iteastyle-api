
package com.aimeow.iteastyle;


import com.aimeow.iteastyle.Application;

import com.aimeow.iteastyle.dao.AdminUserDAO;
import com.aimeow.iteastyle.domain.AdminUserDO;
import com.aimeow.iteastyle.domain.query.AdminUserQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private AdminUserDAO adminUserDAO;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        System.out.print("tests");
    }
    @Test
    public void testCreate() throws Exception {
        AdminUserDO adminUserDO = new AdminUserDO();
        adminUserDO.setFullName("Zhaoyi.w");
        adminUserDO.setIdentifier("admin");
        adminUserDO.setMail("a18814888787@gmail.com");
        adminUserDO.setUserName("aimeow");
        adminUserDO.setUserNick("qq252104960");
        adminUserDO.setPhone("18814888787");
        adminUserDAO.createAdminUser(adminUserDO);
    }

    @Test
    public void testUpdate() throws Exception {
        AdminUserDO adminUserDO = new AdminUserDO();
        adminUserDO.setId("5b1a7040fbab443799af6f9a");
        adminUserDO.setFullName("Zhaoyi.w");
        adminUserDO.setIdentifier("admin123");
        adminUserDO.setMail("a18814888787@gmail.com");
        adminUserDO.setUserName("aimeow");
        adminUserDO.setUserNick("qq252104960");
        adminUserDO.setPhone("18814888787");
        adminUserDAO.updateAdminUser(adminUserDO);
    }

    @Test
    public void testQueryById() throws Exception {
        AdminUserQuery query = new AdminUserQuery();
        query.setAdminUserId("5b1a7040fbab443799af6f9a");
        System.out.println(adminUserDAO.queryAdminUserById(query));
    }

    @Test
    public void testQuerys() throws Exception {
        AdminUserQuery query = new AdminUserQuery();
        System.out.println(adminUserDAO.queryAdminUsers(query));
    }


}
