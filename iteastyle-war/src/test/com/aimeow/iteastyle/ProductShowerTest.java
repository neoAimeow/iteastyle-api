package com.aimeow.iteastyle;

import com.aimeow.iteastyle.Application;
import com.aimeow.iteastyle.dao.ProductShowerDAO;
import com.aimeow.iteastyle.domain.ProductShowerDO;
import com.aimeow.iteastyle.domain.query.ProductShowerQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ProductShowerTest {
    @Autowired ProductShowerDAO productShowerDAO;
    @Test public void testQuery() throws Exception {
        ProductShowerQuery query = new ProductShowerQuery();
        query.setStatus(0);
        query.setPage(1);
        query.setPageSize(10);
        System.out.println(productShowerDAO.queryProductShowers(query));
    }

    @Test public void testCreate() throws Exception {
        ProductShowerDO productShowerDO = new ProductShowerDO();

        productShowerDO.setTitle("抹茶费南雪18");
        productShowerDO.setContent("抹茶费南雪是一种小糕点\n" +
                "就爱这一抹绿啊\n" +
                "高油高糖什么的就是好吃\n" +
                "抹茶控溺爱的小宠物～");
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("http://pa74otoy6.bkt.clouddn.com/product-inside-picture1.png");
        imageUrls.add("http://pa74otoy6.bkt.clouddn.com/product-inside-picture2.png");
        productShowerDO.setImageArr(imageUrls);
        productShowerDAO.createProductShower(productShowerDO);
    }
    @Test public void testRemove() throws Exception {
        productShowerDAO.deleteProductShowerById("5b2f883d3067c60dda2aa2b7");
    }
}
