import com.aimeow.iteastyle.dao.AdminUserDAO;
import com.aimeow.iteastyle.domain.AdminUserDO;
import com.aimeow.iteastyle.domain.query.AdminUserQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserDAOTest {
    @Autowired
    private AdminUserDAO adminUserDAO;

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
        adminUserDO.setId(1L);
        adminUserDO.setFullName("Zhaoyi.w");
        adminUserDO.setIdentifier("admin");
        adminUserDO.setMail("a18814888787@gmail.com");
        adminUserDO.setUserName("aimeow");
        adminUserDO.setUserNick("qq252104960");
        adminUserDO.setPhone("18814888787");
        adminUserDAO.updateAdminUser(adminUserDO);
    }

    @Test
    public void testQueryById() throws Exception {
        AdminUserQuery query = new AdminUserQuery();
        query.setAdminUserId(1L);
        System.out.println(adminUserDAO.queryAdminUserById(query));
    }

    @Test
    public void testQuerys() throws Exception {
        AdminUserQuery query = new AdminUserQuery();
        System.out.println(adminUserDAO.queryAdminUsers(query));
    }


}
