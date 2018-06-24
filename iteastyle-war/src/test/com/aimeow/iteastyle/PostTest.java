package com.aimeow.iteastyle;

import com.aimeow.iteastyle.dao.PostDAO;
import com.aimeow.iteastyle.domain.PostDO;
import com.aimeow.iteastyle.domain.query.PostQuery;
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
public class PostTest {
    @Autowired PostDAO postDAO;
    @Test public void testQuery() throws Exception {
        PostQuery query = new PostQuery();
        query.setStatus(0);
        query.setPage(1);
        query.setPageSize(10);
        System.out.println(postDAO.queryPosts(query));
    }
    @Test public void testCreate() throws Exception {
        PostDO postDO = new PostDO();
        postDO.setStatus(0);
        postDO.setTitle("这份小确信，您想要么？12");
        postDO.setContent("\n" +
                "\n" +
                "\n" +
                "最近还好吗？\n" +
                "\"还好吧。\"\n" +
                "也许\n" +
                "忙碌中\n" +
                "你忽视了很多小确幸\n" +
                "如果你用心体会\n" +
                "你会发现许多小确幸\n" +
                "\n" +
                "匆匆出门\n" +
                "正好赶上一班车\n" +
                "是小确幸\n" +
                "\n" +
                "高温之时\n" +
                "吃一个甜筒\n" +
                "是小确幸\n" +
                "\n" +
                "遭遇坏事\n" +
                "朋友及时的安慰\n" +
                "是小确幸\n" +
                "\n" +
                "而今天\n" +
                "小TEA也有一份“小确幸”\n" +
                "想邀请各位一起分享\n" +
                "\n" +
                "夏日昼长\n" +
                "工作之余\n" +
                "尝一口曲奇\n" +
                "品一杯清茶\n" +
                "补充体力\n" +
                "恢复能量\n" +
                "这是你我的小确幸");
        postDAO.createPost(postDO);

    }
}
