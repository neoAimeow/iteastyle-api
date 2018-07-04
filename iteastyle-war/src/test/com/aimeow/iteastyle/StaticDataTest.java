package com.aimeow.iteastyle;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<String> homeHeader = new ArrayList<>();
        homeHeader.add("http://pa74otoy6.bkt.clouddn.com/AfternoonTea.jpeg");


        List<String> serviceArray = new ArrayList<>();
        serviceArray.add("http://pa74otoy6.bkt.clouddn.com/Tea%20break%20service-web.png");
        serviceArray.add("http://pa74otoy6.bkt.clouddn.com/Tea%20gift%20service-web.png");
        serviceArray.add("http://pa74otoy6.bkt.clouddn.com/Tea%20%20art%20%20service-web.png");


        List<Map<String , String>> serviceWapArray = new ArrayList<>();
        Map<String , String> map1 = new HashMap<>();
        map1.put("image" , "http://pa74otoy6.bkt.clouddn.com/Tea%20break%20service-wap.png");
        map1.put("title" , "茶歇服务");
        map1.put("title_en" , "TEA BREAK SERVICE");

        Map<String , String> map2 = new HashMap<>();
        map2.put("image" , "http://pa74otoy6.bkt.clouddn.com/Tea%20gift%20service-wap.png");
        map2.put("title" , "茶礼服务");
        map2.put("title_en" , "TEA GIFT SERVICE");

        Map<String , String> map3 = new HashMap<>();
        map3.put("image" , "http://pa74otoy6.bkt.clouddn.com/Tea%20%20art%20%20service-wap.png");
        map3.put("title" , "茶艺服务");
        map3.put("title_en" , "TEA ART SERVICE");


        List<String> showerArray = new ArrayList<>();
        showerArray.add("http://pa74otoy6.bkt.clouddn.com/index-foot-img1.png");
        showerArray.add("http://pa74otoy6.bkt.clouddn.com/index-foot-img2.png");
        showerArray.add("http://pa74otoy6.bkt.clouddn.com/index-foot-img3.png");
        showerArray.add("http://pa74otoy6.bkt.clouddn.com/index-foot-img4.png");


        staticDataDO.setHomepageBannerUrls(homeHeader);
        staticDataDO.setHomepageServiceImageUrls(serviceArray);
        staticDataDO.setHomepageServiceWapInfos(serviceWapArray);
        staticDataDO.setHomepageShowerImageUrls(showerArray);
        staticDataDO.setContactUsTitle("杭式下午茶 创意茶歇 健康食尚");
        staticDataDO.setLogoUrl("http://pa74otoy6.bkt.clouddn.com/logo.png");
        staticDataDO.setCompanyStoryBgUrl("http://pa74otoy6.bkt.clouddn.com/company-background.png");
        staticDataDO.setContactUsBgUrl("http://pa74otoy6.bkt.clouddn.com/contactus-background.png");
        staticDataDO.setPostBgUrl("http://pa74otoy6.bkt.clouddn.com/tea-news-background.png");
        staticDataDO.setProductShowerHeaderUrl("http://pa74otoy6.bkt.clouddn.com/pd-title-background.png");

        staticDataDAO.replaceStaticData(staticDataDO);
    }
}
