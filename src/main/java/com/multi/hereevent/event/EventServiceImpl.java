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
    public int insert(EventDTO event) {
        return dao.insert(event);
    }

    @Override
    public int update(EventDTO event) {
        return dao.update(event);
    }

    @Override
    public int delete(int event_no) {
        return dao.delete(event_no);
    }

    @Override
    public EventDTO read(int event_no) {
        return dao.read(event_no);
    }

    @Override
    public List<EventDTO> search(String keyword) {
        return dao.search(keyword);
    }

    @Override
    public List<EventDTO> popList() {
        return List.of();
    }

    @Override
    public List<EventDTO> showList() {
        return List.of();
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
