import com.aimeow.iteastyle.Application;
import com.aimeow.iteastyle.dao.ProductShowerDAO;
import com.aimeow.iteastyle.domain.query.ProductShowerQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.management.Query;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ProductShowerTest {
    @Autowired ProductShowerDAO productShowerDAO;
    @Test public void testQuery() throws Exception {
        ProductShowerQuery query = new ProductShowerQuery();
        query.setStatus(0);
        query.setPage(1);
        query.setPageSize(10);
        System.out.println(productShowerDAO.queryProductShowers(query));
    }


}
