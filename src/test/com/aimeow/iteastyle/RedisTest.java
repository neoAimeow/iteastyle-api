package com.aimeow.iteastyle;

import com.aimeow.tools.RedisUtil;
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
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void testQuery () throws Exception {
        System.out.println(redisUtil.get("hello"));
    }

    @Test public void testInsert() throws Exception {
        redisUtil.set("hello" , "world");
    }
//
}
