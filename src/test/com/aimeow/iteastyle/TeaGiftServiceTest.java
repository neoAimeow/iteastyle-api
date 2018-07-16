package com.aimeow.iteastyle;

import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.TeaBreakServiceEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.Souvenir.TeaGiftSouvenirEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.TeaGiftServiceEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.drinkWay.TeaGiftWayEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.drinkWay.TeaGiftWayItemEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.mind.TeaGiftMindEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.mind.TeaGiftMindItemElementEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.mind.TeaGiftMindItemEntity;
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
public class TeaGiftServiceTest {
    @Autowired
    CommonData commonData;

    @Autowired
    CommonDAO commonDAO;

    @Test
    public void testQuery() throws Exception {
        System.out.println(commonData.getData(TeaGiftServiceEntity.class));
    }

    @Test public void testEdit() throws Exception {
        TeaGiftServiceEntity giftServiceEntity = new TeaGiftServiceEntity();
        giftServiceEntity.setSouvenir(this.getSouvenirEntity());
        giftServiceEntity.setWay(this.getWayEntity());
        giftServiceEntity.setMind(this.getMindEntity());
        commonData.edit(giftServiceEntity , TeaGiftServiceEntity.class);
    }

    private TeaGiftSouvenirEntity getSouvenirEntity() {
        TeaGiftSouvenirEntity souvenirEntity = new TeaGiftSouvenirEntity();
        souvenirEntity.setTitle("杭州伴手礼");
        souvenirEntity.setTitle_en("TEA SOUVENIR");
        souvenirEntity.setContent("西湖龙井、九曲红梅、桂花龙井。都是最具杭城特色的茶品。是赠送外地友人的不二选择，也是外来游客的必选物品。<br>" +
                "“研茶园杭州伴手礼”概念是将杭州的地方文化与礼品的概念相结合，以茶叶的呈现形式予以表达，具有典型的地域文化艺术特色。<br>" +
                "伴手礼是代表着人与人之间情感的联系，只是一份小小的伴手礼却代表送礼者的心意，可谓礼轻情意重。");
        souvenirEntity.setImageUrl("http://pazp3d0xt.bkt.clouddn.com/TEA%20SOUVENIR.png");
        return souvenirEntity;
    }

    private TeaGiftWayEntity getWayEntity() {
        TeaGiftWayEntity wayEntity = new TeaGiftWayEntity();
        wayEntity.setTitle("冲饮方式");
        wayEntity.setTitle_en("DRINKING WAY");
        wayEntity.setImageUrl("http://pazp3d0xt.bkt.clouddn.com/DRINKING%20WAY.png");

        List<TeaGiftWayItemEntity> itemEntities = new ArrayList<>();
        wayEntity.setWays(itemEntities);
        TeaGiftWayItemEntity itemEntity1 = new TeaGiftWayItemEntity();
        TeaGiftWayItemEntity itemEntity2 = new TeaGiftWayItemEntity();
        TeaGiftWayItemEntity itemEntity3 = new TeaGiftWayItemEntity();
        TeaGiftWayItemEntity itemEntity4 = new TeaGiftWayItemEntity();

        itemEntities.add(itemEntity1);
        itemEntities.add(itemEntity2);
        itemEntities.add(itemEntity3);
        itemEntities.add(itemEntity4);

        itemEntity1.setTitle("投茶");
        itemEntity1.setContent("投入3G茶叶于玻璃杯中");


        itemEntity2.setTitle("洗茶");
        itemEntity2.setContent("往杯中注入开水（西湖龙井、桂花龙井水温均为85度，九曲红梅水温约95度），茶水比例约1/3，摇动后，快速洗去第一泡茶汤。");


        itemEntity3.setTitle("注水冲泡");
        itemEntity3.setContent("再往杯中注入开水（西湖龙井、桂花龙井水温均为85度，九曲红梅水温约95度），约7分满，待茶叶吸水舒张。");

        itemEntity4.setTitle("品饮");
        itemEntity4.setContent("浸泡3-5分钟，即可饮茶香茶韵，可冲泡4次以上。");

        return wayEntity;
    }

    private TeaGiftMindEntity getMindEntity() throws Exception {
        TeaGiftMindEntity mindEntity = new TeaGiftMindEntity();
        mindEntity.setTitle("伴手心意");
        mindEntity.setTitle_en("TEA SOUVENIR");

        List<TeaGiftMindItemEntity> mindItemEntities = new ArrayList<>();
        mindEntity.setMinds(mindItemEntities);
        TeaGiftMindItemEntity itemEntity1 = new TeaGiftMindItemEntity();
        TeaGiftMindItemEntity itemEntity2 = new TeaGiftMindItemEntity();
        TeaGiftMindItemEntity itemEntity3 = new TeaGiftMindItemEntity();
        mindItemEntities.add(itemEntity1);
        mindItemEntities.add(itemEntity2);
        mindItemEntities.add(itemEntity3);

        itemEntity1.setItemTitle("西湖龙井简介");
        itemEntity1.setItemContent("西湖龙井位列我国十大名茶之一，具有1200多年历史，明代列为上品，清顺治列为贡品。清乾隆游览杭州西湖时，盛赞龙井茶，并把狮峰山下胡公庙前的十八棵茶树封为“御茶”。<br>龙井茶素有“色绿、香郁、味醇、形美”四绝著称于世，其外形挺直削尖、扁平俊秀、光滑匀齐、色泽绿中显黄。龙井冲泡后，香气清高持久，香郁若兰；汤色杏绿，清澈明亮，叶底嫩绿，匀齐成朵，芽芽直立，栩栩如生。品饮茶汤，沁人心脾，齿间留芳，回味无穷。");
        itemEntity1.setItemImageUrl("http://pazp3d0xt.bkt.clouddn.com/SOUVENIR-A.png");

        itemEntity2.setItemTitle("九曲红梅简介");
        itemEntity2.setItemContent("九曲红梅，这个富有诗意的茶叶产自人间天堂——杭州，或许是沾染了这座城市的浪漫气息，它因此也成为了中国众多茶叶中少数几个以文化命名的茶。尽管生产九曲红梅的茶因面积和产量占浙江省的份额甚少，但因其品质独特，成为杭州市的十大名茶之一，被誉为“万绿丛中一点红”，早在1915年，就拿过巴拿马万国博览会的金奖。因其茶形虬曲，茶性温和，茶味香甜，茶韵悠绵，有红梅之品格及茶文化等诸原因，故又以红梅称之。这是我国茶名中少有以文化命名的名茶。");
        itemEntity2.setItemImageUrl("http://pazp3d0xt.bkt.clouddn.com/Souvenir-B.png");

        itemEntity3.setItemTitle("桂花龙井简介");
        itemEntity3.setItemContent("桂子月中落，天香云外飘。农历八月的杭州，整座城市弥漫着桂花的香甜气息，也勾起很多杭州人旧时的记忆。杭州市花——桂花，与来自春日西湖龙井旁的问候在入秋季节进行跨越时空的交接。以秋季桂香为经，春日龙井为纬，经纬交织间，融合两种最能代表杭州的花草芳香，于雅致中更见一座城市的风情万千。于丹桂飘香之际感觉到春天的问候，于遥远的地方感觉到西湖秋夜明月如同碧水。");
        itemEntity3.setItemImageUrl("http://pazp3d0xt.bkt.clouddn.com/Souvenir-C.png");


        itemEntity1.setElements(this.getMindItem1());
        itemEntity2.setElements(this.getMindItem2());
        itemEntity3.setElements(this.getMindItem3());


        return mindEntity;
    }

    private List<TeaGiftMindItemElementEntity> getMindItem1() throws Exception {
        List<TeaGiftMindItemElementEntity> elementEntities1 = new ArrayList<>();

        TeaGiftMindItemElementEntity elementEntity11 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity12 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity13 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity14 = new TeaGiftMindItemElementEntity();
        elementEntities1.add(elementEntity11);
        elementEntities1.add(elementEntity12);
        elementEntities1.add(elementEntity13);
        elementEntities1.add(elementEntity14);
        elementEntity11.setNumber("HZ001");
        elementEntity11.setElementName("龙井茶特级 A");
        elementEntity11.setWrap("单罐礼盒");
        elementEntity11.setSize("50g*1罐");
        elementEntity11.setPrice(82.00);

        elementEntity12.setNumber("HZ002");
        elementEntity12.setElementName("西湖龙井特级 A");
        elementEntity12.setWrap("单罐礼盒");
        elementEntity12.setSize("65g*1罐");
        elementEntity12.setPrice(188.00);

        elementEntity13.setNumber("HZ003");
        elementEntity13.setElementName("桂花龙井 A");
        elementEntity13.setWrap("单罐礼盒");
        elementEntity13.setSize("65g*1罐");
        elementEntity13.setPrice(132.00);

        elementEntity14.setNumber("HZ004");
        elementEntity14.setElementName("九曲红梅特级 A");
        elementEntity14.setWrap("单罐礼盒");
        elementEntity14.setSize("65g*1罐");
        elementEntity14.setPrice(105.00);
        return elementEntities1;
    }

    private List<TeaGiftMindItemElementEntity> getMindItem2() throws Exception {
        List<TeaGiftMindItemElementEntity> elementEntities1 = new ArrayList<>();

        TeaGiftMindItemElementEntity elementEntity11 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity12 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity13 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity14 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity15 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity16 = new TeaGiftMindItemElementEntity();
        elementEntities1.add(elementEntity11);
        elementEntities1.add(elementEntity12);
        elementEntities1.add(elementEntity13);
        elementEntities1.add(elementEntity14);
        elementEntities1.add(elementEntity15);
        elementEntities1.add(elementEntity16);
        elementEntity11.setNumber("HZ005");
        elementEntity11.setElementName("龙井茶特级 B");
        elementEntity11.setWrap("双罐礼盒");
        elementEntity11.setSize("50g*2罐");
        elementEntity11.setPrice(160.00);

        elementEntity12.setNumber("HZ006");
        elementEntity12.setElementName("西湖龙井特级 B");
        elementEntity12.setWrap("双罐礼盒");
        elementEntity12.setSize("65g*2罐");
        elementEntity12.setPrice(372.00);

        elementEntity13.setNumber("HZ007");
        elementEntity13.setElementName("桂花龙井 B");
        elementEntity13.setWrap("双罐礼盒");
        elementEntity13.setSize("65g*2罐");
        elementEntity13.setPrice(260.00);

        elementEntity14.setNumber("HZ008");
        elementEntity14.setElementName("九曲红梅特级 B");
        elementEntity14.setWrap("双罐礼盒");
        elementEntity14.setSize("65g*2罐");
        elementEntity14.setPrice(206.00);

        elementEntity15.setNumber("HZ009");
        elementEntity15.setElementName("龙凤呈祥 A");
        elementEntity15.setWrap("双罐礼盒");
        elementEntity15.setSize("龙井茶特级50g+九曲红梅特级65g");
        elementEntity15.setPrice(183.00);

        elementEntity16.setNumber("HZ010");
        elementEntity16.setElementName("龙凤呈祥 B");
        elementEntity16.setWrap("双罐礼盒");
        elementEntity16.setSize("西湖龙井茶特级65g+九曲红梅特级65g");
        elementEntity16.setPrice(289.00);
        return elementEntities1;
    }

    private List<TeaGiftMindItemElementEntity> getMindItem3() throws Exception {
        List<TeaGiftMindItemElementEntity> elementEntities1 = new ArrayList<>();

        TeaGiftMindItemElementEntity elementEntity11 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity12 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity13 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity14 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity15 = new TeaGiftMindItemElementEntity();
        TeaGiftMindItemElementEntity elementEntity16 = new TeaGiftMindItemElementEntity();
        elementEntities1.add(elementEntity11);
        elementEntities1.add(elementEntity12);
        elementEntities1.add(elementEntity13);
        elementEntities1.add(elementEntity14);
        elementEntities1.add(elementEntity15);
        elementEntities1.add(elementEntity16);
        elementEntity11.setNumber("HZ011");
        elementEntity11.setElementName("龙井茶特级 C");
        elementEntity11.setWrap("三罐木盒");
        elementEntity11.setSize("50g*3罐");
        elementEntity11.setPrice(270.00);

        elementEntity12.setNumber("HZ012");
        elementEntity12.setElementName("西湖龙井特级 C");
        elementEntity12.setWrap("三罐木盒");
        elementEntity12.setSize("65g*3罐");
        elementEntity12.setPrice(588.00);

        elementEntity13.setNumber("HZ013");
        elementEntity13.setElementName("桂花龙井 C");
        elementEntity13.setWrap("三罐木盒");
        elementEntity13.setSize("65g*3罐");
        elementEntity13.setPrice(420.00);

        elementEntity14.setNumber("HZ014");
        elementEntity14.setElementName("九曲红梅特级 C");
        elementEntity14.setWrap("三罐木盒");
        elementEntity14.setSize("65g*3罐");
        elementEntity14.setPrice(339.00);

        elementEntity15.setNumber("HZ015");
        elementEntity15.setElementName("印象西湖 A");
        elementEntity15.setWrap("三罐木盒");
        elementEntity15.setSize("龙井茶特级50g+九曲红梅特级65g+桂花龙井65g");
        elementEntity15.setPrice(343.00);

        elementEntity16.setNumber("HZ016");
        elementEntity16.setElementName("印象西湖 B");
        elementEntity16.setWrap("三罐木盒");
        elementEntity16.setSize("西湖龙井茶特级65g+九曲红梅特级65g+桂花龙井65G");
        elementEntity16.setPrice(449.00);
        return elementEntities1;
    }
}
