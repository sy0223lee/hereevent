package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;

import java.util.List;

public interface EventService {
    public int insertCrawlingEvent(EventDTO event);
    public int selectEventNoByEventName(String eventName);
}