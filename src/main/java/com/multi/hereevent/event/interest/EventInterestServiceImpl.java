package com.multi.hereevent.event.interest;

import com.multi.hereevent.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventInterestServiceImpl implements EventInterestService {
    private final EventInterestDAO dao;

    @Override
    public int insertEventInterest(int event_no, int member_no) {
        return dao.insertEventInterest(event_no, member_no);
    }

    @Override
    public int deleteEventInterest(int event_no, int member_no) {
        return dao.deleteEventInterest(event_no, member_no);
    }

    @Override
    public List<EventDTO> selectEventInterestByMemberNo(int member_no) {
        return dao.selectEventInterestByMemberNo(member_no);
    }
}
