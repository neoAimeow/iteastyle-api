package com.aimeow.iteastyle;

import com.aimeow.iteastyle.Application;
import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.aimeow.iteastyle.domain.enums.StatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

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
//        ProductShowerQuery query = new ProductShowerQuery();
//        query.setPage(1);
//        query.setPageSize(10);
//        Map<String,String> map = new HashMap<>();
//        map.put("title" , "中式古典");
//        System.out.println(commonDAO.queryList(query , ProductShowerDO.class));
    }

    @Test
    public void testModified() throws Exception {

    }
}
