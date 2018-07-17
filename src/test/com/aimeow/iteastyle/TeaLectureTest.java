package com.aimeow.iteastyle;

import com.aimeow.iteastyle.base.domain.BaseQuery;
import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.aimeow.iteastyle.domain.entity.service.TeaLectureEntity;
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
public class TeaLectureTest {
    @Autowired
    CommonData commonData;

    @Autowired
    CommonDAO commonDAO;
    @Test
    public void testQuery() throws Exception {
        System.out.println(commonDAO.queryList(new BaseQuery() , TeaLectureEntity.class, null , null) );
    }

    @Test public void create() throws Exception {
        TeaLectureEntity entity1 = new TeaLectureEntity();
        TeaLectureEntity entity2 = new TeaLectureEntity();
        TeaLectureEntity entity3 = new TeaLectureEntity();
        entity1.setTitle("商贸界别组活动");
        entity1.setTitle_en("TEA CULTURE SEMINAR");
        entity1.setIconImageUrl("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");
        List<String> images1 = new ArrayList<>();
        entity1.setImageUrls(images1);
        images1.add("http://pazp3d0xt.bkt.clouddn.com/Flgiabw8HM02KE5qWL3zhjVpa3y0");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FoMXZ-kPtqrwC30rh23k_4nPTVXm");

        entity2.setTitle("品茗西湖");
        entity2.setTitle_en("TEA CULTURE SEMINAR");
        entity2.setIconImageUrl("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        List<String> images2 = new ArrayList<>();
        entity2.setImageUrls(images2);
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FotA4DwbqwJQXkrqpynmt2foRS1c");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FquXXJbIkHK90s0BVFPc0Q44oH4x");
        images2.add("http://pazp3d0xt.bkt.clouddn.com/FnX-cn_5kQyFfCZXQ7F3qPfaISSh");


        entity3.setTitle("辉瑞制药");
        entity3.setTitle_en("TEA CULTURE SEMINAR");
        entity3.setIconImageUrl("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        List<String> images3 = new ArrayList<>();
        entity3.setImageUrls(images3);
        images3.add("http://pazp3d0xt.bkt.clouddn.com/FrTdzYeHhfMddbg9uxR-xE8lVOPc");
        images3.add("http://pazp3d0xt.bkt.clouddn.com/FkAvGPM3ryHduN-V7ogVlD5yNhkI");
        images3.add("http://pazp3d0xt.bkt.clouddn.com/FuuirjttNytspnIc1C6kTysAkj68");
        images3.add("http://pazp3d0xt.bkt.clouddn.com/FlqIQkIncLjent65ghg3ggdyROsI");

        commonDAO.create(entity1);
        commonDAO.create(entity2);
        commonDAO.create(entity3);
    }
}
