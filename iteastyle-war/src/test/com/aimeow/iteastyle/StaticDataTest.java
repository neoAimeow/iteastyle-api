import com.aimeow.iteastyle.Application;
import com.aimeow.iteastyle.dao.StaticDataDAO;
import com.aimeow.iteastyle.domain.StaticDataDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class StaticDataTest {
    @Autowired
    StaticDataDAO staticDataDAO;

    @Test
    public void testQuery () throws Exception {
        System.out.println(staticDataDAO.getStaticData());
    }

    @Test
    public void testModified () throws Exception {
        StaticDataDO staticDataDO = new StaticDataDO();
        List<String> arrary = new ArrayList<>();
        arrary.add("http://test");
        arrary.add("http://test2");
        arrary.add("http://test3");

        staticDataDO.setHomepageBannerUrls(arrary);
        staticDataDO.setHomepageServiceImageUrls(arrary);
        staticDataDO.setHomepageShowerImageUrls(arrary);
        staticDataDO.setLogoUrl("hello world");
        staticDataDO.setCompanyStoryBgUrl("hello world");
        staticDataDO.setContactUsBgUrl("hello world");
        staticDataDO.setPostBgUrl("hello world");
        staticDataDO.setProductShowerHeaderUrl("hello world");

        staticDataDAO.replaceStaticData(staticDataDO);

    }
}
