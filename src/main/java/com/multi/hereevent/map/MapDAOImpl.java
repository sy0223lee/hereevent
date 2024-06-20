package com.multi.hereevent.map;

import com.multi.hereevent.dto.EventDTO;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MapDAOImpl implements MapDAO{
    private final SqlSession sqlSession;

    @Override
    public List<EventDTO> button(String state, String type) {
        List<EventDTO> list = null;
        Map<String,String> map = new HashMap<>();
        map.put(state,"state");
        map.put(type,"type");
        list = sqlSession.selectList("com.multi.hereevent.map.select",map);
        return list;
    }
}
