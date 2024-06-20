package com.multi.hereevent.event.interest;

public interface EventInterestDAO {
    int insertEventInterest(int event_no, int member_no);
    int deleteEventInterest(int event_no, int member_no);
}
