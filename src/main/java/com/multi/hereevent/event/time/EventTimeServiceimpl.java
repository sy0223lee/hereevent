package com.multi.hereevent.event.time;

import com.multi.hereevent.dto.EventTimeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventTimeServiceimpl implements EventTimeService{
    private final EventTimeDAO dao;

    @Override
    public int insertEventTimeList(List<EventTimeDTO> eventTimeList) {
        return dao.insertEventTimeList(eventTimeList);
    }
}
