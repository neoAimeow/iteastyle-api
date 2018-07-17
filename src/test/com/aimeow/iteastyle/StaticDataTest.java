package com.aimeow.iteastyle;

import com.aimeow.iteastyle.Application;
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
//    @Autowired
//    StaticDataDAO staticDataDAO;
//
//    @Test
//    public void testQuery () throws Exception {
//        System.out.println(staticDataDAO.getStaticData());
//    }
//
//    @Test
//    public void testModified () throws Exception {
//        StaticDataDO staticDataDO = new StaticDataDO();
//        List<String> homeHeader = new ArrayList<>();
//        homeHeader.add("http://pa74otoy6.bkt.clouddn.com/AfternoonTea.jpeg");
//
//
//        List<String> serviceArray = new ArrayList<>();
//        serviceArray.add("http://pa74otoy6.bkt.clouddn.com/index-TeaArt.png");
//        serviceArray.add("http://pa74otoy6.bkt.clouddn.com/index-TeaBreak.png");
//        serviceArray.add("http://pa74otoy6.bkt.clouddn.com/index-TeaCeremony.png");
//
//
//        List<String> showerArray = new ArrayList<>();
//        showerArray.add("http://pa74otoy6.bkt.clouddn.com/index-foot-img1.png");
//        showerArray.add("http://pa74otoy6.bkt.clouddn.com/index-foot-img2.png");
//        showerArray.add("http://pa74otoy6.bkt.clouddn.com/index-foot-img3.png");
//        showerArray.add("http://pa74otoy6.bkt.clouddn.com/index-foot-img4.png");
//
//
//        staticDataDO.setHomepageBannerUrls(homeHeader);
//        staticDataDO.setHomepageServiceImageUrls(serviceArray);
//        staticDataDO.setHomepageShowerImageUrls(showerArray);
//        staticDataDO.setContactUsTitle("杭式下午茶 创意茶歇 健康食尚");
//        staticDataDO.setLogoUrl("http://pa74otoy6.bkt.clouddn.com/logo.png");
//        staticDataDO.setCompanyStoryBgUrl("http://pa74otoy6.bkt.clouddn.com/company-background.png");
//        staticDataDO.setContactUsBgUrl("http://pa74otoy6.bkt.clouddn.com/contactus-background.png");
//        staticDataDO.setPostBgUrl("http://pa74otoy6.bkt.clouddn.com/tea-news-background.png");
//        staticDataDO.setProductShowerHeaderUrl("http://pa74otoy6.bkt.clouddn.com/pd-title-background.png");
//
//        staticDataDAO.replaceStaticData(staticDataDO);
//
//    }
}
