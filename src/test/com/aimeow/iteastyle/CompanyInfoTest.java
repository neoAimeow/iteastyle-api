package com.aimeow.iteastyle;

import com.aimeow.iteastyle.Application;
import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.aimeow.iteastyle.domain.DomainObject.CompanyInfoDO;
import com.aimeow.iteastyle.domain.DomainObject.ProductShowerDO;
import com.aimeow.iteastyle.domain.enums.StatusEnum;
import com.aimeow.iteastyle.domain.query.ProductShowerQuery;
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
public class CompanyInfoTest {
    @Autowired
    CommonData commonData;

    @Autowired
    CommonDAO commonDAO;
    @Test
    public void testQuery() throws Exception {
//        System.out.println(commonData.getData(CompanyInfoDO.class));
        ProductShowerQuery query = new ProductShowerQuery();
        query.setStatus(StatusEnum.NORMAL.getStatus());

        System.out.println(commonDAO.count(query , ProductShowerDO.class));
    }

    @Test
    public void testModified() throws Exception {

    }
}
