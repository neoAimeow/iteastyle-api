package com.aimeow.iteastyle;


import com.aimeow.iteastyle.dao.CaseTypeDAO;
import com.aimeow.iteastyle.domain.CaseTypeDO;
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
    @Autowired private CaseTypeDAO caseTypeDAO;

    @Test public void testQuery() throws Exception {
        System.out.println(caseTypeDAO.getCaseTypes());
    }

    @Test public void testQueryByCaseCode() throws Exception {
        System.out.println(caseTypeDAO.getCaseTypeByTypeCode(101));
    }
    @Test public void testCreate() throws Exception {
        CaseTypeDO caseTypeDO = new CaseTypeDO();
        caseTypeDO.setType(105);
        caseTypeDO.setTypeName("茶艺表演");
        caseTypeDO.setTypeNameEn("TEA PERFORMANCE");
        caseTypeDO.setTypeImage("http://pa74otoy6.bkt.clouddn.com/case-performance.png");
        caseTypeDO.setTypeIcon("http://pa74otoy6.bkt.clouddn.com/opaque-logo.png");

        caseTypeDAO.createCaseType(caseTypeDO);
    }
}
