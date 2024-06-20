package com.multi.hereevent.event.interest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
