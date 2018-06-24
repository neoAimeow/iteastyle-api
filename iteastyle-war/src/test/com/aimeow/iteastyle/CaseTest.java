package com.aimeow.iteastyle;

import com.aimeow.iteastyle.dao.CaseDAO;
import com.aimeow.iteastyle.domain.CaseDO;
import com.aimeow.iteastyle.domain.query.CaseQuery;
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
public class CaseTest {
    @Autowired private CaseDAO caseDAO;
    @Test public void testQuery() throws Exception {
        CaseQuery query = new CaseQuery();
        query.setType(100);
        System.out.println(caseDAO.queryCases(query));
    }
    @Test public void testCreate() throws Exception {
        CaseDO caseDO = new CaseDO();
        List<String> imageArray = new ArrayList<>();
        imageArray.add("http://pa74otoy6.bkt.clouddn.com/case-inside2-picture2.png");
        imageArray.add("http://pa74otoy6.bkt.clouddn.com/case-inside2-picture1.png");
        imageArray.add("http://pa74otoy6.bkt.clouddn.com/case-inside2-picture2.png");
        imageArray.add("http://pa74otoy6.bkt.clouddn.com/case-inside2-picture1.png");
        imageArray.add("http://pa74otoy6.bkt.clouddn.com/case-inside2-picture2.png");
        imageArray.add("http://pa74otoy6.bkt.clouddn.com/case-inside2-picture2.png");
        caseDO.setTitle("茶文化讲座8");
        caseDO.setImageArr(imageArray);
        caseDO.setType(102);

        caseDAO.createCase(caseDO);
    }
}
