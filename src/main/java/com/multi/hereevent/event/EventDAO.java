package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;

import java.util.Date;
import java.util.List;

public interface EventDAO {
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
    public List<EventDTO> getOpenEvent(String today);
    //예약,대기 높은순 10순위 리스트
    //public List<EventDTO> getPopularEvent();

    //인스타그램 태그

    //세부페이지
    public EventDTO getEventDetails(int event_no);  // 전체 데이터 조회
    //사진 가져오기
    public EventDTO getEventImage(int event_no);


}
