package com.aimeow.iteastyle;

import com.aimeow.iteastyle.base.domain.BaseQuery;
import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.aimeow.iteastyle.domain.entity.service.TeaDIYEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaLectureEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaPerformEntity;
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
public class TeaPerformTest {
    @Autowired
    CommonData commonData;

    @Autowired
    CommonDAO commonDAO;
    @Test
    public void testQuery() throws Exception {
        System.out.println(commonDAO.queryList(new BaseQuery() , TeaPerformEntity.class, null , null) );
    }

    @Test public void create() throws Exception {
        TeaPerformEntity entity1 = new TeaPerformEntity();
        TeaPerformEntity entity2 = new TeaPerformEntity();
        TeaPerformEntity entity3 = new TeaPerformEntity();
        entity1.setTitle("永商精英会");
        entity1.setTitle_en("TEA PERFORMANCE");
        entity1.setIconImageUrl("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");
        List<String> images1 = new ArrayList<>();
        entity1.setImageUrls(images1);
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FiY6VCNA4sMmb5t1ZspdZTqp6A7E");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FnULg-RbhrqFERvuYuNg5x7jdwJ6");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FigZKxaWuqjW4vvYubS7iMeiVa--");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/Fpk2l82g6DhgjYDvKQu_0dJNOIS0");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FiN62Iz3bH4lguFoMNXAEDOe1xMs");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FhbDXDyxh5-GGqNWWPWSc7iZzYk3");

        entity2.setTitle("四个辣妈梦想会南宋点茶体验之旅\n");
        entity2.setTitle_en("TEA PERFORMANCE");
        entity2.setIconImageUrl("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        List<String> images2 = new ArrayList<>();
        entity2.setImageUrls(images2);
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FoouGPf2foPdAwEvuNaK2gXSZzw6");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FtOG-PwaVVQG-Sk-gYlq9fpG1Cjx");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FrP4pdhhhFmzuWlq0yFT8V1hqpNM");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/Fo0vdEmKtqAQaAwp8sr4cLWnMtn7");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FhjxIPCVjQ5WXNaGilhghO0vERYD");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/Fhq-3g8DR99SxJVV8ke-Y4_W-CvJ");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FtQcWmgtgZJte1QJv67K7xWszJHS");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FjA1WGFY_u8pYr5rXSAQL40Qlzwk");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FkmyxqilDd-TGva0T3L9J9AfQci2");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FpSDEF40D7zjHyzXr-3O5nbFWCl6");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/Fo_CDlZdmi8_8C9s4s45oxoo4uSU");


        entity3.setTitle("杭州青年联合会");
        entity3.setTitle_en("TEA PERFORMANCE");
        entity3.setIconImageUrl("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        List<String> images3 = new ArrayList<>();
        entity3.setImageUrls(images3);
        images3.add("http://pazp3d0xt.bkt.clouddn.com/Fr-T4zOYxjiDN3JTVArt4qBqH8h6");
        images3.add("http://pazp3d0xt.bkt.clouddn.com/FqhwX_Fg0T4rTka3Ru4PRoxb9jGZ");
        images3.add("http://pazp3d0xt.bkt.clouddn.com/Fk5l0MZMgm2NrBmhHXPEM_Pbvq9p");
        images3.add("http://pazp3d0xt.bkt.clouddn.com/FtzJSUmqHgrDrD90N0XhoSHcn6d0");

        commonDAO.create(entity1);
        commonDAO.create(entity2);
        commonDAO.create(entity3);
    }

    @Test public void testClear() throws Exception {
        commonDAO.clear(TeaLectureEntity.class);
        commonDAO.clear(TeaDIYEntity.class);
        commonDAO.clear(TeaPerformEntity.class);
    }
}
