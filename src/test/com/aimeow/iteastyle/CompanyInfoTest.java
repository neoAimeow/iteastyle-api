package com.aimeow.iteastyle;

import com.aimeow.iteastyle.Application;
import com.aimeow.tools.CommonDAO;
import com.aimeow.tools.CommonData;
import com.aimeow.iteastyle.domain.entity.CompanyInfoEntity;
import com.aimeow.iteastyle.domain.enums.StatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CompanyInfoTest {
    @Autowired
    CommonData commonData;

    @Autowired
    CommonDAO commonDAO;
    @Test
    public void testQuery() throws Exception {
        System.out.println(commonData.getData(CompanyInfoEntity.class));
//        ProductShowerQuery query = new ProductShowerQuery();
//        query.setPage(1);
//        query.setPageSize(10);
//        Map<String,String> map = new HashMap<>();
//        map.put("title" , "中式古典");
//        System.out.println(commonDAO.queryList(query , ProductShowerDO.class));
    }

    @Test
    public void testModified() throws Exception {
        CompanyInfoEntity entity = new CompanyInfoEntity();
        entity.setCompanyName("杭州执贝科技有限公司");
        entity.setCompanyAddress("杭州民和路525号三宏国际8楼");
        entity.setPostCode("300000");
        entity.setTelephoneNumber("(86)0571-83731743");
        entity.setMail("iteastyle@126.com");
        entity.setWebUrl("https://www.iteastyle.cn");
        entity.setStoryTitle("杭式下午茶");
        //entity.setVideoUrl("www.aimeow.com");
        entity.setLatitude(30.2312);
        entity.setLongitude(120.25479);
        entity.setQrCodeImageUrl("http://pa74otoy6.bkt.clouddn.com/contactus-QRcode.png");
        entity.setCustomerQrCodeImageUrl("http://pazp3d0xt.bkt.clouddn.com/Customer%20service-QR%20code.png");
        entity.setStory("&emsp;&emsp;执贝科技，立足杭州，以吃茶、喝茶为切入点，借助时尚、新颖的主题方式，让更多的年轻人了解茶文化，享受食尚茶歇，从而逐步打造属于我们自己的“杭式下午茶”。目前公司主要以“茶歇服务”为主体业务，茶礼茶具、器皿租赁、糕点供应为辅，提供全方位的特色服务。<br><br>&emsp;&emsp;HangZhou Afternoon Tea is a compositive organization which is devoted to Tea Break one-stop service. It really takes tea elements as the core.  Using pure natural tea powder tea with drinks , cakes  and fashion together . It aims to lead a healthy lifestyle and concept of life.");
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("15906631121");
        phoneNumbers.add("15858232263");
        entity.setPhoneNumber(phoneNumbers);
        commonData.edit(entity , CompanyInfoEntity.class);
    }
}
