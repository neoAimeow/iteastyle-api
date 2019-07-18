package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.entity.EventEntity;
import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceEntity;
import com.aimeow.iteastyle.tools.domain.BaseGetList;
import com.aimeow.iteastyle.tools.domain.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2018/11/6 9:00 PM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@RequestMapping(value = "/service")
@RestController
public interface EventService {
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    BaseResult<BaseGetList<EventEntity>> getEvents(Integer page, Integer pageSize);

    @RequestMapping(value = "/getEventByEventId", method = RequestMethod.GET)
    BaseResult<EventEntity> getEventByEventId(String eventId);

    @RequestMapping(value = "/getEventByEventTitle", method = RequestMethod.GET)
    BaseResult<List<EventEntity>> getEventByEventTitle(String eventTitle);
}
