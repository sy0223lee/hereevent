package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService{
    private EventDAO dao;

    @Autowired
    public EventServiceImpl(EventDAO dao) {
        this.dao = dao;
    }

    @Override
    public int insertEvent(EventDTO event) {
        return dao.insertEvent(event);
    }

    @Override
    public int updateEvent(EventDTO event) {
        return dao.updateEvent(event);
    }

    @Override
    public int deleteEvent(int event_no) {
        return dao.deleteEvent(event_no);
    }

    @Override
    public List<EventDTO> searchEvent(String keyword) {
        return dao.searchEvent(keyword);
    }

    @Override
    public List<EventDTO> getAllEvent() {
        return dao.getAllEvent();
    }



    //세부페이지
    @Override
    public EventDTO getEventDetails(int event_no) {
        return dao.getEventDetails(event_no);
    }

    //사진 가져오기
    @Override
    public EventDTO getEventImage(int event_no) {
        return dao.getEventImage(event_no);
    }
}
