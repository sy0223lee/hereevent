package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;

import java.util.List;

public interface EventDAO {
    public int insertCrawlingEvent(EventDTO event); // 크롤링한 이벤트 등록
    public String selectEventNoByEventName(String eventName); // 이벤트 이름으로 이벤트 번호 조회
}