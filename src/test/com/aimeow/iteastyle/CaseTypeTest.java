package com.aimeow.iteastyle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aimeow.iteastyle.domain.entity.CaseEntity;
import com.aimeow.tools.CommonDAO;
import com.aimeow.tools.CommonData;
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
        System.out.println(commonDAO.queryAllList(CaseTypeEntity.class,null,null));
    }

    @Test public void testModified() throws Exception {
        CaseTypeEntity caseTypeEntity1 = new CaseTypeEntity();
        caseTypeEntity1.setRank(3);
        caseTypeEntity1.setType(102);
        caseTypeEntity1.setTypeName("茶事活动");
        caseTypeEntity1.setTypeNameEn("Tea activities");
        caseTypeEntity1.setTypeImage("http://pazp3d0xt.bkt.clouddn.com/pt-seminar-wap.png");
        caseTypeEntity1.setTypeIcon("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        CaseTypeEntity caseTypeEntity2 = new CaseTypeEntity();
        caseTypeEntity2.setRank(4);

        caseTypeEntity2.setType(103);
        caseTypeEntity2.setTypeName("DIY活动");
        caseTypeEntity2.setTypeNameEn("DIY ACTIVITES");
        caseTypeEntity2.setTypeImage("http://pazp3d0xt.bkt.clouddn.com/pd-diy-wap.jpg");
        caseTypeEntity2.setTypeIcon("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        CaseTypeEntity caseTypeEntity3 = new CaseTypeEntity();
        caseTypeEntity3.setRank(1);
        caseTypeEntity3.setType(104);
        caseTypeEntity3.setTypeName("茶歇定制");
        caseTypeEntity3.setTypeNameEn("TEA BREAK CUSTOMISATION");
        caseTypeEntity3.setTypeImage("http://pazp3d0xt.bkt.clouddn.com/pd-customisation-wap.png");
        caseTypeEntity3.setTypeIcon("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        CaseTypeEntity caseTypeEntity4 = new CaseTypeEntity();
        caseTypeEntity4.setRank(2);

        caseTypeEntity4.setType(105);
        caseTypeEntity4.setTypeName("杭州伴手礼");
        caseTypeEntity4.setTypeNameEn("TEA HAND COURTESY");
        caseTypeEntity4.setTypeImage("http://pazp3d0xt.bkt.clouddn.com/pd-performance-wap.jpg");
        caseTypeEntity4.setTypeIcon("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");
        commonDAO.create(caseTypeEntity3);

        commonDAO.create(caseTypeEntity4);
        commonDAO.create(caseTypeEntity1);
        commonDAO.create(caseTypeEntity2);

    }

    @Test public void testClear() throws Exception {
        commonDAO.clear(CaseTypeEntity.class);
    }

    @Test public void testEdit() throws Exception {
        Map<String , Object> map = new HashMap<>();
        map.put("type",101);
        List<CaseEntity> caseEntityList = commonDAO.queryByParam(map, CaseEntity.class, null , null);
        System.out.println(caseEntityList);

        for (CaseEntity entity:caseEntityList) {
            entity.setType(104);
            commonDAO.update(entity,CaseEntity.class);
        }
    }

}
