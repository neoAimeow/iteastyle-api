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

    @Test public void testCreate() throws Exception {
        CaseTypeDO caseTypeDO = new CaseTypeDO();
        caseTypeDO.setType(101);
        caseTypeDO.setTypeName("茶点茶饮");
        caseTypeDO.setTypeNameEn("TEA DESSERT");
        caseTypeDO.setTypeImage("TEA DESSERT");
        caseTypeDO.setTypeIcon("TEA DESSERT");

        caseTypeDAO.createCaseType(caseTypeDO);
    }
}
