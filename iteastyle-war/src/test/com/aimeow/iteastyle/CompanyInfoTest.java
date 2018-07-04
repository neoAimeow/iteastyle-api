package com.aimeow.iteastyle;

import com.aimeow.iteastyle.Application;
import com.aimeow.iteastyle.dao.CompanyInfoDAO;
import com.aimeow.iteastyle.domain.CompanyInfoDO;
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

import java.util.ArrayList;
import java.util.List;

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
        List<String> phones = new ArrayList<>();
        phones.add("159-0663-1121");
        phones.add("188-1486-8787");
        companyInfoDO.setPhoneNumber(phones);
        companyInfoDO.setTelephoneNumber("(86)0571-83731743");
        companyInfoDO.setMail("iteastyle@126.com");
        companyInfoDO.setWebUrl("https://www.iteastyle.cn");
        companyInfoDO.setStory("执贝科技，立足杭州，以吃茶、喝茶为切入点，借助时尚、新颖的主题方式，让更多的年轻人了解茶文化，享受食尚茶歇，从而逐步打造属于我们自己的“杭式下午茶”。目前公司主要以“茶歇服务”为主体业务，茶礼茶具、器皿租赁、糕点供应为辅，提供全方位的特色服务。");
        companyInfoDO.setStoryTitle("杭式下午茶");
        companyInfoDO.setVideoUrl("");
        companyInfoDO.setLatitude(30.2312000000);
        companyInfoDO.setLongitude(120.2547900000);

        companyInfoDAO.replaceCompanyInfoData(companyInfoDO);
    }


}
