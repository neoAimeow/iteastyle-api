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
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.process.TeaBreakProcessItemEntity;
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

        wayEntity.setTitle("&#xe9e7; 预定方式");
        menu.setTitle("&#xe9e7; 茶歇菜单");
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
        itemEntity1.setTitle_en("Afternoon Tea");
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
        processEntity.setTitle("订购流程");
        processEntity.setTitle_en("ORDER PROCESS");
//        processEntity.setProcesses("ORDER PROCESS");
        List<TeaBreakProcessItemEntity> list = new ArrayList<>();
        processEntity.setProcesses(list);
        TeaBreakProcessItemEntity itemEntity1 = new TeaBreakProcessItemEntity();
        TeaBreakProcessItemEntity itemEntity2 = new TeaBreakProcessItemEntity();
        TeaBreakProcessItemEntity itemEntity3 = new TeaBreakProcessItemEntity();
        TeaBreakProcessItemEntity itemEntity4 = new TeaBreakProcessItemEntity();
        TeaBreakProcessItemEntity itemEntity5 = new TeaBreakProcessItemEntity();
        TeaBreakProcessItemEntity itemEntity6 = new TeaBreakProcessItemEntity();
        TeaBreakProcessItemEntity itemEntity7 = new TeaBreakProcessItemEntity();
        TeaBreakProcessItemEntity itemEntity8 = new TeaBreakProcessItemEntity();
        list.add(itemEntity1);
        list.add(itemEntity2);
        list.add(itemEntity3);
        list.add(itemEntity4);
        list.add(itemEntity5);
        list.add(itemEntity6);
        list.add(itemEntity7);
        list.add(itemEntity8);

        itemEntity1.setTitle("售前咨询");
        itemEntity1.setContent("茶歇服务完成后请于当日内支付尾款");

        itemEntity2.setTitle("确认订单");
        itemEntity2.setContent("确认选择的产品和服务清单");

        itemEntity3.setTitle("线上预定");
        itemEntity3.setContent("线上预定");

        itemEntity4.setTitle("接单合作");
        itemEntity4.setContent("根据合同的产品清单制作新鲜茶歇产品");

        itemEntity5.setTitle("订单配送");
        itemEntity5.setContent("按合同上约定的送达时间准时送达产品");

        itemEntity6.setTitle("摆台服务");
        itemEntity6.setContent("现场服务人员布置茶歇摆台与装饰");

        itemEntity7.setTitle("售后服务");
        itemEntity7.setContent("对产品及服务有不满意对地方请及时联系客服小tea");

        itemEntity8.setTitle("支付尾款");
        itemEntity8.setContent("电话或微信联络杭式下午茶小tea，了解产品及服务");


        return processEntity;
    }

    private TeaBreakNoteEntity mockNoteEntity() throws Exception {
        TeaBreakNoteEntity noteEntity = new TeaBreakNoteEntity();
        noteEntity.setTitle("订购须知");
        noteEntity.setTitle_en("ORDER INSTRUCTIONS");
        List<String> notes = new ArrayList<>();
        noteEntity.setNotes(notes);
        notes.add("杭式下午茶<span style='color:#9dc135'>目前支持杭州地区订购</span>，全国其他地区暂未开通；");
        notes.add("订单金额<span style='color:#9dc135'>1500元起订</span>，所有订单请<span style='color:#9dc135'>提前48小时预约</span>并支付预定金；");
        notes.add("高端个性化定制请<span style='color:#9dc135'>提前7天预约</span>；");
        notes.add("<span style='color:#9dc135'>杭州市区内免费送货</span>，其他地区（余杭、萧山等）交通费另计；");
        notes.add("杭式下午茶提供<span style='color:#9dc135'>茶歇现场服务人员</span>，并提供现场摆盘服务、装饰布置等服务；");
        notes.add("活动结束后，现场器具如有丢失损坏，100元金额以内属正常损耗，无须赔偿，100元金额以上需按器具价格进行赔偿；");
        notes.add("如在订购后解除订购，我们将按照实际制作量按比例扣除预定订金。");
        return noteEntity;
    }

    private TeaBreakOrderModeEntity mockOrderModeEntity() throws Exception {
        TeaBreakOrderModeEntity orderModeEntity = new TeaBreakOrderModeEntity();
        orderModeEntity.setTitle("订购方式");
        orderModeEntity.setTitle_en("ORDERING WAYS");
        orderModeEntity.setQrTitle("公众号预定");
        orderModeEntity.setQrImageUrl("http://pa74otoy6.bkt.clouddn.com/contactus-QRcode.png");
        return orderModeEntity;
    }

}
