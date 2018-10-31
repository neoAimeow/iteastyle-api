package com.aimeow.iteastyle;

import com.aimeow.iteastyle.Application;
import com.aimeow.tools.CommonData;
import com.aimeow.iteastyle.domain.entity.StaticDataEntity;
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
    @Autowired private CommonData commonData;
    @Test
    public void testQuery () throws Exception {
        System.out.println(commonData.getData(StaticDataEntity.class));
    }
//
    @Test
    public void testModified () throws Exception {
        StaticDataEntity staticDataEntity = new StaticDataEntity();
        List<String> homeHeader = new ArrayList<>();
        homeHeader.add("http://pa74otoy6.bkt.clouddn.com/AfternoonTea.jpeg");
//
//
        List<String> serviceArray = new ArrayList<>();
        serviceArray.add("http://pa74otoy6.bkt.clouddn.com/Tea%20break%20service-web.png");
        serviceArray.add("http://pa74otoy6.bkt.clouddn.com/Tea%20gift%20service-web.png");
        serviceArray.add("http://pa74otoy6.bkt.clouddn.com/Tea%20%20art%20%20service-web.png");

        List<String> showerArray = new ArrayList<>();
        showerArray.add("http://pazp3d0xt.bkt.clouddn.com/index-foot-img6.jpg");
        showerArray.add("http://pazp3d0xt.bkt.clouddn.com/index-foot-img5.jpg");
        showerArray.add("http://pa74otoy6.bkt.clouddn.com/index-foot-img3.png");
        showerArray.add("http://pa74otoy6.bkt.clouddn.com/index-foot-img4.png");

        staticDataEntity.setHomepageBannerUrls(homeHeader);
        staticDataEntity.setHomepageServiceImageUrls(serviceArray);
        staticDataEntity.setHomepageShowerImageUrls(showerArray);
        staticDataEntity.setContactUsTitle("杭式下午茶 创意茶歇 健康食尚");
        staticDataEntity.setLogoUrl("http://pa74otoy6.bkt.clouddn.com/logo.png");
        staticDataEntity.setCompanyStoryBgUrl("http://pazp3d0xt.bkt.clouddn.com/compamy-bk-1500-1133.jpg");
        staticDataEntity.setContactUsBgUrl("http://pazp3d0xt.bkt.clouddn.com/ct-us-1700-930.jpg");

        commonData.edit(staticDataEntity, StaticDataEntity.class);
//    }
    }
}