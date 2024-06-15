package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;

import java.util.List;

public interface EventDAO {
    public int insert(EventDTO event);//행사 등록
    public int update(EventDTO event);//행사 수정
    public int delete(int event_no);//행사 삭제
    public EventDTO read(int event_no);// 행사 상세보기
    public List<EventDTO> search(String keyword);//행사이름 검색
    public List<EventDTO> eventList();//전체 행사 조회
    //public List<EventDTO> popularList();//인기10순위 리스트,, 관심갯수 그룹바이로 이벤트번호가져오고
    //public List<EventDTO> categoryList();//카테고리별 조회
    //public List<EventDTO> newList(); //오픈예정 행사

    //세부페이지
    public EventDTO getEventDetails(int event_no);  // 전체 데이터 조회
    //사진 가져오기
    public EventDTO getEventImage(int event_no);


}
