package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;

import java.util.List;

public interface EventDAO {
    public int insert(EventDTO event);//행사 등록
    public int update(EventDTO event);//행사 수정
    public int delete(int event_no);//행사 삭제

    public EventDTO read(int event_no);// 행사 상세보기
    public List<EventDTO> search(String keyword);//행사이름 검색
    public List<EventDTO> popList();//전체 팝업 조회
    public List<EventDTO> showList();//전체 전시회 조회-> 수정필요
    //public List<EventDTO> starList();//별점 높은순 10순위 리스트
    //public List<EventDTO> popularList();//예약,대기 높은순 10순위 리스트
    //public List<EventDTO> categoryList();//카테고리별 조회
    //public List<EventDTO> newList(); //오픈예정 행사

    //세부페이지
    public EventDTO getEventDetails(int event_no);  // 전체 데이터 조회
    //사진 가져오기
    public EventDTO getEventImage(int event_no);


}
