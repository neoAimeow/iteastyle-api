package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.EventEntity;
import com.aimeow.iteastyle.service.EventService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventServiceImpl implements EventService {

    @Override
    public BaseResult<EventEntity> getEventByEventId(String eventId) {
        return null;
    }

    @Override
    public BaseResult<List<EventEntity>> getEvents(Integer page, Integer pageSize) {
        return null;
    }
}
