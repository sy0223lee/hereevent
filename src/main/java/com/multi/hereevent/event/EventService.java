package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;

import java.util.List;

public interface EventService {
    public int insert(EventDTO event);
    public int update(EventDTO event);
    public int delete(int event_no);
    public EventDTO read(int event_no);
    public List<EventDTO> search(String keyword);
    public List<EventDTO> popList();//전체 행사 조회
    public List<EventDTO> showList();//전체 행사 조회
    //public List<EventDTO> popularList();//인기10순위 리스트,, 관심갯수 그룹바이로 이벤트번호가져오고
    //public List<EventDTO> categoryList();//카테고리별 조회
    //public List<EventDTO> newList(); //오픈예정 행사

    //세부페이지
    public EventDTO getEventDetails(int event_no);
    //eventimage
    EventDTO getEventImage(int event_no);
}

