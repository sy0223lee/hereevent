package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDAOImpl implements EventDAO{
    SqlSession sqlSessionTemplate;

    @Autowired
    public EventDAOImpl(SqlSession sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    @Override
    public int insertEvent(EventDTO event) {
        return sqlSessionTemplate.insert("com.multi.hereevent.event.insertEvent",event);
    }

    @Override
    public int updateEvent(EventDTO event) {
        return sqlSessionTemplate.update("com.multi.hereevent.event.updateEvent", event);
    }

    @Override
    public int deleteEvent(int event_no) {
        return sqlSessionTemplate.delete("com.multi.hereevent.event.deleteEvent", event_no);
    }

    @Override
    public List<EventDTO> searchEvent(String keyword) {
        return sqlSessionTemplate.selectList("com.multi.hereevent.event.searchEvent", keyword);
    }

    @Override
    public List<EventDTO> getAllEvent() {
        return sqlSessionTemplate.selectList("com.multi.hereevent.event.getAllEvent");
    }

    @Override
    public List<EventDTO> getOpenEvent(String today) {
        return sqlSessionTemplate.selectList("com.multi.hereevent.event.getOpenEvent");
    }

    //세부페이지
    @Override
    public EventDTO getEventDetails(int event_no) {

        return sqlSessionTemplate.selectOne("com.multi.hereevent.event.getEventDetails", event_no);

    }

    @Override
    public EventDTO getEventImage(int event_no) {
        return sqlSessionTemplate.selectOne("com.multi.hereevent.event.getEventImage", event_no);
    }

}
