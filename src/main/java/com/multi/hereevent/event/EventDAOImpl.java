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
}
