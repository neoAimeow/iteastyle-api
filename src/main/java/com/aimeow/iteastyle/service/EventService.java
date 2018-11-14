package com.aimeow.iteastyle.service;

import com.aimeow.domain.BaseGetList;
import com.aimeow.domain.BaseQuery;
import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.EventEntity;
import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2018/11/6 9:00 PM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Api(value = "/service",tags = {"通用接口"}, description = "通用的接口数据")
@RequestMapping(value = "/service")
@RestController
public interface EventService {
    @ApiOperation(value = "通过GET请求方式获取活动列表")
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    BaseResult<BaseGetList<EventEntity>> getEvents(Integer page, Integer pageSize);

    @ApiOperation(value = "通过GET请求方式通过活动id获取活动详情")
    @RequestMapping(value = "/getEventByEventId", method = RequestMethod.GET)
    BaseResult<EventEntity> getEventByEventId(String eventId);

    @ApiOperation(value = "通过GET请求方式通过活动Title获取活动详情")
    @RequestMapping(value = "/getEventByEventTitle", method = RequestMethod.GET)
    BaseResult<List<EventEntity>> getEventByEventTitle(String eventTitle);
}
