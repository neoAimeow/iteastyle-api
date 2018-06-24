import com.aimeow.iteastyle.Application;
import com.aimeow.iteastyle.dao.CompanyInfoDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CompanyInfoTest {
    @Autowired
    CompanyInfoDAO companyInfoDAO;

    @Test
    public void testQuery() throws Exception {
        System.out.println(companyInfoDAO.getCompanyInfo());
    }

    @Test
    public void testModified() throws Exception {


    }
}
