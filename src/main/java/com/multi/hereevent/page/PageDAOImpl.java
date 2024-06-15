package com.multi.hereevent.page;

import com.multi.hereevent.dto.EventDTO;
import org.springframework.stereotype.Repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PageDAOImpl implements PageDAO {
    @Autowired
    private SqlSession sqlSessionTemplate;

    @Override
    public EventDTO getEventDetails(int event_no) {

        return sqlSessionTemplate.selectOne("com.multi.hereevent.page.getEventDetails", event_no);

    }
}
