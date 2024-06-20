package com.multi.hereevent.event.interest;

import com.multi.hereevent.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class EventInterestDAOImpl implements EventInterestDAO{
    private final SqlSession sqlSession;

    @Override
    public int insertEventInterest(int event_no, int member_no) {
        Map<String, Integer> params = new HashMap<>();
        params.put("event_no", event_no);
        params.put("member_no", member_no);
        return sqlSession.insert("com.multi.hereevent.event.insertEventInterest", params);
    }

    @Override
    public int deleteEventInterest(int event_no, int member_no) {
        Map<String, Integer> params = new HashMap<>();
        params.put("event_no", event_no);
        params.put("member_no", member_no);
        return sqlSession.delete("com.multi.hereevent.event.deleteEventInterest", params);
    }

    @Override
    public List<EventDTO> selectEventInterestByMemberNo(int member_no) {
        return sqlSession.selectList("com.multi.hereevent.event.selectEventInterestByMemberNo", member_no);
    }
}
