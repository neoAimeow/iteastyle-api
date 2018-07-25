package com.aimeow.iteastyle;

import com.aimeow.domain.BaseQuery;
import com.aimeow.tools.CommonDAO;
import com.aimeow.tools.CommonData;
import com.aimeow.iteastyle.domain.entity.service.TeaDIYEntity;
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
public class TeaDIYTest {
    @Autowired
    CommonData commonData;

    @Autowired
    CommonDAO commonDAO;

    @Test public void testQuery() throws Exception {
        System.out.println(commonDAO.queryList(new BaseQuery() , TeaDIYEntity.class, null , null) );
    }

    @Test public void create() throws Exception {
        TeaDIYEntity entity1 = new TeaDIYEntity();

        entity1.setTitle("棒棒糖&甜甜圈DIY&松饼");
        entity1.setTitle_en("PATTING DIY");
        entity1.setIconImageUrl("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");
        List<String> images1 = new ArrayList<>();
        entity1.setImageUrls(images1);
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FpSRdYb4nuDFLMzboZCFMQkDD5aG");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FnfCo4z3n3MqkDCQDdX0XItEJyq0");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FhiUy7DeqkYkYafCkSgHjhktH6QN");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FvivK7QQyyzGHGgEOy7j01jLTrxb");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FsJ79E7iv9wBvdRwY90qdlDjSIpt");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FujSIA1TOPFe7RMVjaYI3ugzh6Ik");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FuKM7RgZeBNlRHASiMVHmy-VAdss");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/Firm5kpO3-MF1PYfgrXj9o6SWT2K");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/Fq1qfgY8j4dP2KTCAKQvNwEQ_Aq5");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FvZTFGbshn-p73OyXnjKUFYFwEIR");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/Fok9sXAZYAXjeT1lZPAPZLd1RteF");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FhYqXUr427tvEtGr5YtF2-QG6wJZ");
        images1.add("http://pazp3d0xt.bkt.clouddn.com/FsmannvvfoTfGr59QV8W-XjDz-kk");

        commonDAO.create(entity1);

    }
}
