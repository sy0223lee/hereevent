package com.multi.hereevent.event.interest;

import com.multi.hereevent.dto.EventDTO;

import java.util.List;

public interface EventInterestService {
    int insertEventInterest(int event_no, int member_no);
    int deleteEventInterest(int event_no, int member_no);
    List<EventDTO> selectEventInterestByMemberNo(int member_no);
}
