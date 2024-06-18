package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventDAO dao;

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

    @Override
    public List<EventDTO> selectEventByCategoryNo(int category_no) {
        return dao.selectEventByCategoryNo(category_no);
    }

//    @Override
//    public List<EventDTO> getOpenEvent(String today) {
//        return dao.getOpenEvent(today);
//    }

//    @Override
//    public List<EventDTO> getPopularEvent() {
//        return dao.getPopularEvent();
//    }


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
  
    // 크롤링
    @Override
    public int insertCrawlingEvent(EventDTO event) {
        return dao.insertCrawlingEvent(event);
    }

    @Override
    public int selectEventNoByEventName(String eventName) {
        return Integer.parseInt(dao.selectEventNoByEventName(eventName));
    }


}
