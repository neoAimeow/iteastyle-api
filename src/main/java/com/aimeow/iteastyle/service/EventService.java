package com.aimeow.iteastyle.service;

import com.aimeow.domain.BaseQuery;
import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.EventEntity;
import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created on 2018/11/6 9:00 PM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
public interface EventService {
    @ApiOperation(value = "通过GET请求方式获取活动列表")
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    BaseResult<List<EventEntity>> getEvents(BaseQuery query);

    @ApiOperation(value = "通过GET请求方式通过活动id获取活动详情")
    @RequestMapping(value = "/getEventByEventId", method = RequestMethod.GET)
    BaseResult<EventEntity> getEventByEventId(String eventId);

}
