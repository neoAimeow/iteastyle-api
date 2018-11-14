package com.aimeow.iteastyle;

import java.util.List;

import com.aimeow.domain.BaseGetList;
import com.aimeow.iteastyle.domain.entity.EventEntity;
import com.aimeow.iteastyle.domain.enums.ContentTypeEnum;
import com.aimeow.iteastyle.service.AdminService;
import com.aimeow.iteastyle.service.CommonService;
import com.aimeow.iteastyle.service.EventService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created on 2018/11/10 11:07 PM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class EventTest {
    @Autowired private EventService eventService;
    @Autowired private AdminService adminService;
    @Autowired private CommonService commonService;
    @Test
    public void testQuery() throws Exception {
        System.out.println(commonService.getDataWithTypeInRedis("caseType"));
    }
    @Test
    public void testEvent() throws Exception {
        String param = "{\n"
            + "\t\"title\": \"TitleTest\",\n"
            + "\t\"imageUrl\": \"imageUrl\",\n"
            + "\t\"content\": \"content\"\n"
            + "}";
        Boolean createSuccess =  adminService.create(
            param, ContentTypeEnum.Event.getValue()
        ).getModel();
        Assert.assertEquals(createSuccess, true);

        List<EventEntity> eventEntities = eventService
            .getEventByEventTitle("TitleTest").getModel();
        System.out.println(eventEntities);
        Assert.assertNotEquals(eventEntities.size() , 0);

        if (eventEntities.size() > 0) {
            EventEntity event = eventEntities.get(0);
            Assert.assertEquals(event.getTitle() , "TitleTest");
            Assert.assertEquals(event.getImageUrl() , "imageUrl");
            Assert.assertEquals(event.getContent() , "content");
            EventEntity queryEntity = eventService
                .getEventByEventId(event.getId()).getModel();
            Assert.assertEquals(queryEntity.getId() , event.getId());
            Assert.assertEquals(queryEntity.getTitle() , "TitleTest");
            Assert.assertEquals(queryEntity.getImageUrl() , "imageUrl");
            Assert.assertEquals(queryEntity.getContent() , "content");

            Boolean deleteSuccess = adminService.delete(
                queryEntity.getId() , ContentTypeEnum.Event.getValue()
            ).getModel();
            Assert.assertEquals(deleteSuccess, true);

            EventEntity queryAfterDeleteEntity = eventService
                .getEventByEventId(event.getId()).getModel();

            Assert.assertEquals(queryAfterDeleteEntity, null);
        }
    }

}
