package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventDAOImpl implements EventDAO{
    private final SqlSession sqlSession;

    @Override
    public int insert(EventDTO event) {
        return sqlSessionTemplate.insert("com.multi.hereevent.event.insert",event);
    }

    @Override
    public int update(EventDTO event) {
        return sqlSessionTemplate.update("com.multi.hereevent.event.update", event);
    }

    @Override
    public int delete(int event_no) {
        return sqlSessionTemplate.delete("com.multi.hereevent.event.delete", event_no);
    }

    @Override
    public EventDTO read(int event_no) {
        return sqlSessionTemplate.selectOne("com.multi.hereevent.event.read", event_no);
    }

    @Override
    public List<EventDTO> search(String keyword) {
        return sqlSessionTemplate.selectList("com.multi.hereevent.event.search", keyword);
    }

    @Override
    public List<EventDTO> popList() {
        return sqlSessionTemplate.selectList("com.multi.hereevent.event.selectPop");
    }
    @Override
    public List<EventDTO> showList() {
        return sqlSessionTemplate.selectList("com.multi.hereevent.event.selectShow");
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
