package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseGetList;
import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.EventEntity;
import com.aimeow.iteastyle.domain.query.EventQuery;
import com.aimeow.iteastyle.service.EventService;
import com.aimeow.tools.CommonDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventServiceImpl implements EventService {
    @Autowired private CommonDAO commonDAO;

    @Override
    public BaseResult<EventEntity> getEventByEventId(String eventId) {
        BaseResult<EventEntity> result = new BaseResult<>();
        try {
            result.setModel(commonDAO.queryById(eventId , EventEntity.class));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<BaseGetList<EventEntity>> getEvents(Integer page, Integer pageSize) {
        BaseResult<BaseGetList<EventEntity>> result = new BaseResult<BaseGetList<EventEntity>>();
        BaseGetList baseGetList = new BaseGetList();
        try {
            baseGetList.setPage(page);
            baseGetList.setPageSize(pageSize);

            EventQuery eventQuery = new EventQuery();
            eventQuery.setPageSize(pageSize);
            eventQuery.setPage(page);

            List<EventEntity> entities = commonDAO.queryList(
                    eventQuery , EventEntity.class, null , null);
            for (EventEntity eventEntity: entities) {
                if (StringUtils.isEmpty(eventEntity.getImageUrl())) {
                    eventEntity.setImageUrl("http://pazp3d0xt.bkt.clouddn.com/if%20no%20img.jpg");
                }
            }
            baseGetList.setTotalCount(commonDAO.count(eventQuery , EventEntity.class));
            baseGetList.setItems(entities);
            result.setModel(baseGetList);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }
}
