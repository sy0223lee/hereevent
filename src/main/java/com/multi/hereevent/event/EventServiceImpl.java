package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventDAO dao;

    @Override
    public int insertCrawlingEvent(EventDTO event) {
        return dao.insertCrawlingEvent(event);
    }

    @Override
    public int selectEventNoByEventName(String eventName) {
        return Integer.parseInt(dao.selectEventNoByEventName(eventName));
    }
}