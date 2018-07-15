package com.aimeow.iteastyle;

import com.aimeow.iteastyle.base.tools.CommonDAO;
import com.aimeow.iteastyle.base.tools.CommonData;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.TeaBreakServiceEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.Souvenir.TeaGiftSouvenirEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.TeaGiftServiceEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.drinkWay.TeaGiftWayEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.mind.TeaGiftMindEntity;
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
        giftServiceEntity.setMind(this.getmindEntity());
        commonData.edit(giftServiceEntity , TeaGiftServiceEntity.class);
    }

    private TeaGiftSouvenirEntity getSouvenirEntity() {
        TeaGiftSouvenirEntity souvenirEntity = new TeaGiftSouvenirEntity();
        return souvenirEntity;
    }

    private TeaGiftWayEntity getWayEntity() {
        TeaGiftWayEntity wayEntity = new TeaGiftWayEntity();
        return wayEntity;
    }

    private TeaGiftMindEntity getmindEntity() {
        TeaGiftMindEntity mindEntity = new TeaGiftMindEntity();
        return mindEntity;
    }
}
