package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;

import java.util.List;

public interface EventService {
    //관리자페이지
    //행사 등록
    public int insertEvent(EventDTO event);
    //행사 수정
    public int updateEvent(EventDTO event);
    //행사 삭제
    public int deleteEvent(int event_no);

    //행사이름 검색
    public List<EventDTO> searchEvent(String keyword);
    //전체 팝업 조회
    public List<EventDTO> getAllEvent();

    //별점 높은순 10순위 리스트
    //public List<EventDTO> starList();
    //카테고리별 조회
    //public List<EventDTO> categoryList();

    //오픈예정 행사
    //public List<EventDTO> newList();
    //예약,대기 높은순 10순위 리스트
    //public List<EventDTO> popularList();


    //세부페이지
    public EventDTO getEventDetails(int event_no);
    //eventimage
    EventDTO getEventImage(int event_no);
}

