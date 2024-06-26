package com.multi.hereevent.map;

import com.multi.hereevent.dto.ButtonDTO;
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
    public List<EventDTO> button(ButtonDTO buttonDTO) {
        return sqlSession.selectList("com.multi.hereevent.map.select",buttonDTO);
    }

    @Override
    public List<EventDTO> selectStill() {
        return sqlSession.selectList("com.multi.hereevent.map.selectStill");
    }
}
