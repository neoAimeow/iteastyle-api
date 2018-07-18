package com.aimeow.iteastyle;

import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.aimeow.iteastyle.domain.entity.CaseTypeEntity;
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
public class CaseTypeTest {
    @Autowired
    CommonData commonData;

    @Autowired
    CommonDAO commonDAO;

    @Test public void testQuery () throws Exception {
        System.out.println(commonDAO.queryAllList(CaseTypeEntity.class));
    }

    @Test public void testModified() throws Exception {
        CaseTypeEntity caseTypeEntity1 = new CaseTypeEntity();
        caseTypeEntity1.setType(101);
        caseTypeEntity1.setTypeName("茶点茶饮");
        caseTypeEntity1.setTypeNameEn("TEA DESSERT");
        caseTypeEntity1.setTypeImage("http://pazp3d0xt.bkt.clouddn.com/pd-tea-dessert-wap.png");
        caseTypeEntity1.setTypeIcon("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        CaseTypeEntity caseTypeEntity2 = new CaseTypeEntity();
        caseTypeEntity2.setType(102);
        caseTypeEntity2.setTypeName("茶文化讲座");
        caseTypeEntity2.setTypeNameEn("TEA CULTURE SEMINAR");
        caseTypeEntity2.setTypeImage("http://pazp3d0xt.bkt.clouddn.com/pt-seminar-wap.png");
        caseTypeEntity2.setTypeIcon("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        CaseTypeEntity caseTypeEntity3 = new CaseTypeEntity();
        caseTypeEntity3.setType(103);
        caseTypeEntity3.setTypeName("DIY活动");
        caseTypeEntity3.setTypeNameEn("DIY ACTIVITES");
        caseTypeEntity3.setTypeImage("http://pazp3d0xt.bkt.clouddn.com/pd-diy-wap.jpg");
        caseTypeEntity3.setTypeIcon("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        CaseTypeEntity caseTypeEntity4 = new CaseTypeEntity();
        caseTypeEntity4.setType(104);
        caseTypeEntity4.setTypeName("茶歇定制");
        caseTypeEntity4.setTypeNameEn("TEA BREAK CUSTOMISATION");
        caseTypeEntity4.setTypeImage("http://pazp3d0xt.bkt.clouddn.com/pd-customisation-wap.png");
        caseTypeEntity4.setTypeIcon("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        CaseTypeEntity caseTypeEntity5 = new CaseTypeEntity();
        caseTypeEntity5.setType(105);
        caseTypeEntity5.setTypeName("茶艺表演");
        caseTypeEntity5.setTypeNameEn("TEA PERFORMANCE");
        caseTypeEntity5.setTypeImage("http://pazp3d0xt.bkt.clouddn.com/pd-performance-wap.jpg");
        caseTypeEntity5.setTypeIcon("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");
        commonDAO.create(caseTypeEntity1);
        commonDAO.create(caseTypeEntity2);
        commonDAO.create(caseTypeEntity3);
        commonDAO.create(caseTypeEntity4);
        commonDAO.create(caseTypeEntity5);

    }

    @Test public void testClear() throws Exception {
        commonDAO.clear(CaseTypeEntity.class);
    }

}
