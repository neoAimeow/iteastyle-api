package com.aimeow.iteastyle;

import com.aimeow.iteastyle.base.domain.BaseQuery;
import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.TeaBreakServiceEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.note.TeaBreakNoteEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.TeaBreakOrderEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.menu.MenuEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.menu.TeaBreakOrderMenuEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.way.TeaBreakOrderWayEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.way.TeaBreakOrderWayItemEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.orderMode.TeaBreakOrderModeEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.process.TeaBreakProcessEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.range.TeaBreakRangeEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.range.TeaBreakRangeItemEntity;
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
public class TeaBreakServiceTest {

    @Autowired
    CommonData commonData;

    @Autowired
    CommonDAO commonDAO;

    @Test
    public void testQuery() throws Exception {
        System.out.println(commonData.getData(TeaBreakServiceEntity.class));
    }

    @Test
    public void editData() throws Exception {
        TeaBreakServiceEntity teaBreakServiceEntity = new TeaBreakServiceEntity();

        teaBreakServiceEntity.setOrder(this.mockOrderEntity());
        teaBreakServiceEntity.setRange(this.mockRangeEntity());
        teaBreakServiceEntity.setProcess(this.mockProcessEntity());
        teaBreakServiceEntity.setNote(this.mockNoteEntity());
        teaBreakServiceEntity.setOrderMode(this.mockOrderModeEntity());

        commonData.edit(teaBreakServiceEntity , TeaBreakServiceEntity.class);
    }

    private TeaBreakOrderEntity mockOrderEntity() throws Exception {
        TeaBreakOrderEntity orderEntity = new TeaBreakOrderEntity();
        orderEntity.setTitle("茶歇预定");
        orderEntity.setTitle_en("RESERVATION");

        TeaBreakOrderWayEntity wayEntity = new TeaBreakOrderWayEntity();
        TeaBreakOrderMenuEntity menu = new TeaBreakOrderMenuEntity();

        orderEntity.setOrderWay(wayEntity);
        orderEntity.setMenu(menu);

        wayEntity.setTitle("&#xe9e7;预定方式");
        menu.setTitle("&#xe9e7;茶歇菜单");
        List<TeaBreakOrderWayItemEntity> itemEntities = new ArrayList<>();

        TeaBreakOrderWayItemEntity itemEntity1 = new TeaBreakOrderWayItemEntity();
        TeaBreakOrderWayItemEntity itemEntity2 = new TeaBreakOrderWayItemEntity();
        TeaBreakOrderWayItemEntity itemEntity3 = new TeaBreakOrderWayItemEntity();
        itemEntities.add(itemEntity1);
        itemEntities.add(itemEntity2);
        itemEntities.add(itemEntity3);
        wayEntity.setItems(itemEntities);

        itemEntity1.setTitle("高端个性化定制");
        itemEntity1.setContent("按照您的个性化需求，茶歇师会为您制定独一无二的产品，预算金额将根据工作量进行相应预算。");
        itemEntity1.setImageUrl("http://pa74otoy6.bkt.clouddn.com/no-one.png");

        itemEntity2.setTitle("人数标准化菜单");
        itemEntity2.setContent("按照您提供的人数，选择菜单，立刻生成预算。");
        itemEntity2.setImageUrl("http://pa74otoy6.bkt.clouddn.com/no-two.png");

        itemEntity3.setTitle("一人一份");
        itemEntity3.setContent("每人平均分配，人手一份，同样根据人数，快速生成预算。");
        itemEntity3.setImageUrl("http://pa74otoy6.bkt.clouddn.com/no-three.png");

        return orderEntity;
    }

    private TeaBreakRangeEntity mockRangeEntity() throws Exception {
        TeaBreakRangeEntity rangeEntity = new TeaBreakRangeEntity();
        rangeEntity.setTitle("服务范围");
        rangeEntity.setTitle_en("SERVICE SCOPE");
        List<TeaBreakRangeItemEntity> rangeItemEntities = new ArrayList<>();
        rangeEntity.setRanges(rangeItemEntities);
        TeaBreakRangeItemEntity itemEntity1 = new TeaBreakRangeItemEntity();
        TeaBreakRangeItemEntity itemEntity2 = new TeaBreakRangeItemEntity();
        TeaBreakRangeItemEntity itemEntity3 = new TeaBreakRangeItemEntity();
        TeaBreakRangeItemEntity itemEntity4 = new TeaBreakRangeItemEntity();
        TeaBreakRangeItemEntity itemEntity5 = new TeaBreakRangeItemEntity();
        TeaBreakRangeItemEntity itemEntity6 = new TeaBreakRangeItemEntity();
        TeaBreakRangeItemEntity itemEntity7 = new TeaBreakRangeItemEntity();
        TeaBreakRangeItemEntity itemEntity8 = new TeaBreakRangeItemEntity();
        rangeItemEntities.add(itemEntity1);
        rangeItemEntities.add(itemEntity2);
        rangeItemEntities.add(itemEntity3);
        rangeItemEntities.add(itemEntity4);
        rangeItemEntities.add(itemEntity5);
        rangeItemEntities.add(itemEntity6);
        rangeItemEntities.add(itemEntity7);
        rangeItemEntities.add(itemEntity8);
        itemEntity1.setMainTitle("公司");
        itemEntity1.setSubTitle("下午茶");
        itemEntity1.setTitle_en("Company Afternoon Tea");
        itemEntity1.setImageUrl("http://pa74otoy6.bkt.clouddn.com/company%20afternoon%20tea.jpg");
        itemEntity1.setTitleImageUrl("http://pa74otoy6.bkt.clouddn.com/no-one.png");

        itemEntity2.setMainTitle("员工");
        itemEntity2.setSubTitle("生日会");
        itemEntity2.setTitle_en("Staff Birthday Party");
        itemEntity2.setImageUrl("http://pa74otoy6.bkt.clouddn.com/staff%20birthday%20party.jpg");
        itemEntity2.setTitleImageUrl("http://pa74otoy6.bkt.clouddn.com/no-two.png");

        itemEntity3.setMainTitle("公司");
        itemEntity3.setSubTitle("年会");
        itemEntity3.setTitle_en("Annual Meeting");
        itemEntity3.setImageUrl("http://pa74otoy6.bkt.clouddn.com/Annual%20Meeting.jpg");
        itemEntity3.setTitleImageUrl("http://pa74otoy6.bkt.clouddn.com/no-three.png");

        itemEntity4.setMainTitle("节日");
        itemEntity4.setSubTitle("庆典");
        itemEntity4.setTitle_en("Festival Celebration");
        itemEntity4.setImageUrl("http://pa74otoy6.bkt.clouddn.com/Festival%20Celebration.jpg");
        itemEntity4.setTitleImageUrl("http://pa74otoy6.bkt.clouddn.com/no-four.png");

        itemEntity5.setMainTitle("高端");
        itemEntity5.setSubTitle("酒会");
        itemEntity5.setTitle_en("High-end Reception");
        itemEntity5.setImageUrl("http://pa74otoy6.bkt.clouddn.com/High-end%20Reception.jpg");
        itemEntity5.setTitleImageUrl("http://pa74otoy6.bkt.clouddn.com/no-five.png");

        itemEntity6.setMainTitle("商务");
        itemEntity6.setSubTitle("接待会");
        itemEntity6.setTitle_en("Business Reception");
        itemEntity6.setImageUrl("http://pa74otoy6.bkt.clouddn.com/Business%20Reception.jpg");
        itemEntity6.setTitleImageUrl("http://pa74otoy6.bkt.clouddn.com/no-six.png");

        itemEntity7.setMainTitle("产品");
        itemEntity7.setSubTitle("发布会");
        itemEntity7.setTitle_en("Product Launch");
        itemEntity7.setImageUrl("http://pa74otoy6.bkt.clouddn.com/Product%20Launch.jpg");
        itemEntity7.setTitleImageUrl("http://pa74otoy6.bkt.clouddn.com/no-seven.png");

        itemEntity8.setMainTitle("开业");
        itemEntity8.setSubTitle("庆典");
        itemEntity8.setTitle_en("Opening Ceremony");
        itemEntity8.setImageUrl("http://pa74otoy6.bkt.clouddn.com/Opening%20Ceremony.jpg");
        itemEntity8.setTitleImageUrl("http://pa74otoy6.bkt.clouddn.com/no-eight.png");

        return rangeEntity;
    }

    private TeaBreakProcessEntity mockProcessEntity() throws Exception {
        TeaBreakProcessEntity processEntity = new TeaBreakProcessEntity();
        return processEntity;
    }

    private TeaBreakNoteEntity mockNoteEntity() throws Exception {
        TeaBreakNoteEntity noteEntity = new TeaBreakNoteEntity();
        return noteEntity;
    }

    private TeaBreakOrderModeEntity mockOrderModeEntity() throws Exception {
        TeaBreakOrderModeEntity orderModeEntity = new TeaBreakOrderModeEntity();
        return orderModeEntity;
    }

}
