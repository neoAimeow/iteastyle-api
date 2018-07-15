package com.aimeow.iteastyle;

import com.aimeow.iteastyle.base.domain.BaseQuery;
import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.aimeow.iteastyle.domain.entity.service.TeaDIYEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TeaDIYTest {
    @Autowired
    CommonData commonData;

    @Autowired
    CommonDAO commonDAO;
    @Test public void testQuery() throws Exception {
        System.out.println(commonDAO.queryList(new BaseQuery() , TeaDIYEntity.class, null , null) );
    }

}
