package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class EventDAOImpl implements EventDAO{
    private final SqlSession sqlSession;

    @Override
    public int insertEvent(EventDTO event) {
        return sqlSession.insert("com.multi.hereevent.event.insertEvent",event);
    }

    @Override
    public int updateEvent(EventDTO event) {
        return sqlSession.update("com.multi.hereevent.event.updateEvent", event);
    }

    @Override
    public int deleteEvent(int event_no) {
        return sqlSession.delete("com.multi.hereevent.event.deleteEvent", event_no);
    }

    @Override
    public List<EventDTO> searchEvent(String keyword) {
        return sqlSession.selectList("com.multi.hereevent.event.searchEvent", keyword);
    }

    @Override
    public List<EventDTO> getAllEvent() {
        return sqlSession.selectList("com.multi.hereevent.event.getAllEvent");
    }

    @Override
    public List<EventDTO> getListStarRank() {
        return sqlSession.selectList("com.multi.hereevent.event.getEventByStarRank");
    }

    @Override
    public List<EventDTO> selectEventByCategoryNo(int category_no) {
        //System.out.println("DAONO===>>>"+category_no);
        return sqlSession.selectList("com.multi.hereevent.event.selectEventByCategory", category_no);
    }

    @Override
    public List<EventDTO> getOpenEvent() {
        return sqlSession.selectList("com.multi.hereevent.event.getOpenEvent");
    }

    @Override
    public List<EventDTO> getPopularEvent() {
        return sqlSession.selectList("com.multi.hereevent.event.getPopularEvent");
    }

    //세부페이지
    @Override
    public EventDTO getEventDetails(int event_no) {
        return sqlSession.selectOne("com.multi.hereevent.event.getEventDetails", event_no);
    }

    @Override
    public EventDTO getEventDetails(int event_no, int member_no) {
        Map<String, Integer> param = new HashMap<>();
        param.put("event_no", event_no);
        param.put("member_no", member_no);
        return sqlSession.selectOne("com.multi.hereevent.event.getEventDetailsWithInterest", param);
    }

    @Override
    public EventDTO getEventImage(int event_no) {
        return sqlSession.selectOne("com.multi.hereevent.event.getEventImage", event_no);
    }
    //예약하기
    @Override
    public int insertReserve(ReservationDTO reservation) {
        return sqlSession.insert("com.multi.hereevent.event.insertReserve", reservation);
    }

    // 크롤링
    @Override
    public int insertCrawlingEvent(EventDTO event) {
        return sqlSession.insert("com.multi.hereevent.event.insertCrawlingEvent", event);
    }

    @Override
    public String selectEventNoByEventName(String eventName) {
        return sqlSession.selectOne("com.multi.hereevent.event.selectEventNoByEventName", eventName);
    }

}
