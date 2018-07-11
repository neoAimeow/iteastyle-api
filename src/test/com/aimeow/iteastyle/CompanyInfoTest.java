import com.aimeow.iteastyle.Application;
import com.aimeow.iteastyle.dao.CompanyInfoDAO;
import com.aimeow.iteastyle.base.domain.CompanyInfoDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
        CompanyInfoDO companyInfoDO = new CompanyInfoDO();
        companyInfoDO.setCompanyName("杭州执贝科技有限公司");
        companyInfoDO.setCompanyAddress("杭州民和路525号三宏国际8楼");
        companyInfoDO.setPostCode("300000");
        companyInfoDO.setPhoneNumber("159-0663-1121");
        companyInfoDO.setTelephoneNumber("(86)0571-83731743");
        companyInfoDO.setMail("iteastyle@126.com");
        companyInfoDO.setWebUrl("https://www.iteastyle.com");
        companyInfoDO.setStory("    杭州执贝科技有限公司旗下品牌【杭式下午茶】是致力于茶歇(Tea Break)一站式的综合服务机构，真正以茶元素为核心，用纯天然的超微茶粉，将茶与饮品、茶与糕点、茶与时尚有机的结合在一起，旨在引领一种健康的生活方式与生活理念！\n" +
                "    HangZhou Afternoon Tea is a compositive organization which is devoted to Tea Break one-stop service. It really takes tea elements as the core. Using pure natural tea powder mixes tea with drinks , cakes and fashion together . It aims to lead a healthy lifestyle and concept of life.");
        companyInfoDO.setStoryTitle("杭式下午茶");
        companyInfoDO.setVideoUrl("http://pa74otoy6.bkt.clouddn.com/video-test.mov");
        companyInfoDO.setLatitude(30.2312000000);
        companyInfoDO.setLongitude(120.2547900000);

        companyInfoDAO.replaceCompanyInfoData(companyInfoDO);

    }
}
