package com.aimeow.iteastyle;

import com.aimeow.domain.BaseQuery;
import com.aimeow.tools.CommonDAO;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.menu.MenuEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.menu.MenuItemEntity;
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
public class MenuTest {
    @Autowired
    CommonDAO commonDAO;
    @Test
    public void testQuery() throws Exception {
        System.out.println(commonDAO.queryList(new BaseQuery() , MenuEntity.class, null , null) );
    }

    @Test public void testCreateMenu1() throws Exception {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setTitle("A款茶歇/48元人均");
        menuEntity.setSort(0);
        List<MenuItemEntity> itemEntities = new ArrayList<>();
        menuEntity.setItems(itemEntities);
        MenuItemEntity itemEntity1 = new MenuItemEntity();
        MenuItemEntity itemEntity2 = new MenuItemEntity();
        MenuItemEntity itemEntity3 = new MenuItemEntity();
        itemEntities.add(itemEntity1);
        itemEntities.add(itemEntity2);
        itemEntities.add(itemEntity3);
        itemEntity1.setTitle("点 心");
        itemEntity1.setIcon("&#xe9ea;");
        List<String> desserts = new ArrayList<>();
        desserts.add("特色茶曲奇");
        desserts.add("抹茶慕斯");
        desserts.add("水果布丁");
        desserts.add("抹茶泡芙");
        desserts.add("双色巧克力蛋糕");
        itemEntity1.setDesserts(desserts);

        itemEntity2.setTitle("水果拼盘");
        itemEntity2.setIcon("&#xe9ec;");
        List<String> desserts2 = new ArrayList<>();
        desserts2.add("西瓜");
        desserts2.add("橙子");
        desserts2.add("圣女果");
        itemEntity2.setDesserts(desserts2);

        itemEntity3.setTitle("饮 料");
        itemEntity3.setIcon("&#xe9eb;");
        List<String> desserts3 = new ArrayList<>();
        desserts3.add("抹茶拿铁");
        desserts3.add("桂花龙井茶");
        itemEntity3.setDesserts(desserts3);

        commonDAO.create(menuEntity);
    }

    @Test public void testCreateMenu2() throws Exception {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setTitle("B款茶歇/68元人均 <span style='color:red'>&#xe7a8;</span>");
        menuEntity.setSort(1);
        List<MenuItemEntity> itemEntities = new ArrayList<>();
        menuEntity.setItems(itemEntities);
        MenuItemEntity itemEntity1 = new MenuItemEntity();
        MenuItemEntity itemEntity2 = new MenuItemEntity();
        MenuItemEntity itemEntity3 = new MenuItemEntity();
        itemEntities.add(itemEntity1);
        itemEntities.add(itemEntity2);
        itemEntities.add(itemEntity3);
        itemEntity1.setTitle("点 心");
        itemEntity1.setIcon("&#xe9ea;");
        List<String> desserts = new ArrayList<>();
        desserts.add("抹茶慕斯");
        desserts.add("水果布丁");
        desserts.add("抹茶泡芙");
        desserts.add("纸杯蛋糕");
        desserts.add("特色茶曲奇");
        desserts.add("抹茶瑞士卷");
        desserts.add("双色巧克力蛋糕");
        itemEntity1.setDesserts(desserts);

        itemEntity2.setTitle("水果拼盘");
        itemEntity2.setIcon("&#xe9ec;");
        List<String> desserts2 = new ArrayList<>();
        desserts2.add("西瓜");
        desserts2.add("橙子");
        desserts2.add("哈密瓜");
        desserts2.add("火龙果");
        itemEntity2.setDesserts(desserts2);

        itemEntity3.setTitle("饮 料");
        itemEntity3.setIcon("&#xe9eb;");
        List<String> desserts3 = new ArrayList<>();
        desserts3.add("抹茶拿铁");
        desserts3.add("洛神花茶");
        desserts3.add("水果茶");
        itemEntity3.setDesserts(desserts3);

        commonDAO.create(menuEntity);
    }

    @Test public void testCreateMenu3() throws Exception {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setTitle("C款茶歇/88元人均");
        menuEntity.setSort(2);
        List<MenuItemEntity> itemEntities = new ArrayList<>();
        menuEntity.setItems(itemEntities);
        MenuItemEntity itemEntity1 = new MenuItemEntity();
        MenuItemEntity itemEntity2 = new MenuItemEntity();
        MenuItemEntity itemEntity3 = new MenuItemEntity();
        itemEntities.add(itemEntity1);
        itemEntities.add(itemEntity2);
        itemEntities.add(itemEntity3);
        itemEntity1.setTitle("点 心");
        itemEntity1.setIcon("&#xe9ea;");
        List<String> desserts = new ArrayList<>();
        desserts.add("蓝莓挞");
        desserts.add("栗子蛋糕");
        desserts.add("抹茶慕斯");
        desserts.add("水果布丁");
        desserts.add("抹茶泡芙");
        desserts.add("盆栽蛋糕");
        desserts.add("抹茶瑞士卷");
        desserts.add("特色茶曲奇");
        desserts.add("双色巧克力蛋糕");
        desserts.add("芒果抹茶慕斯球");
        itemEntity1.setDesserts(desserts);

        itemEntity2.setTitle("水果拼盘");
        itemEntity2.setIcon("&#xe9ec;");
        List<String> desserts2 = new ArrayList<>();
        desserts2.add("西瓜");
        desserts2.add("橙子");
        desserts2.add("圣女果");
        desserts2.add("哈密瓜");
        desserts2.add("火龙果");
        desserts2.add("时令果串");
        itemEntity2.setDesserts(desserts2);

        itemEntity3.setTitle("饮 料");
        itemEntity3.setIcon("&#xe9eb;");
        List<String> desserts3 = new ArrayList<>();
        desserts3.add("抹茶拿铁");
        desserts3.add("玫瑰红茶拿铁");
        desserts3.add("洛神花茶");
        desserts3.add("水果茶");
        itemEntity3.setDesserts(desserts3);

        commonDAO.create(menuEntity);
    }

    @Test public void testClear() throws Exception {
        commonDAO.clear(MenuEntity.class);
    }

}
