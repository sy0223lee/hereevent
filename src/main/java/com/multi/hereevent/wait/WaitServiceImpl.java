package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.dto.WaitDTO;
import com.multi.hereevent.event.EventDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
@RequiredArgsConstructor
public class WaitServiceImpl implements WaitService {
    private final WaitDAO dao;
    private final EventDAO eventDAO;

    @Override
    public WaitDTO waitLogin(WaitDTO wait) {
        return dao.waitLogin(wait);
    }

    @Override
    public int waitInsert(WaitDTO wait) {
        return dao.waitInsert(wait);
    }

    @Override
    public List<WaitDTO> getWaitList() {
        List<WaitDTO> waitlist = dao.getWaitList();
        return waitlist;
    }

    @Override
    public WaitDTO read(String wait_tel) {
        return null;
    }

    @Override
    public WaitDTO waitDetail(int wait_no) {
        return dao.waitDetail(wait_no);
    }

    @Override
    public WaitDTO EventDetail(int wait_no) {
        return dao.eventDetails(wait_no);
    }

    @Override
    public WaitDTO waitDetailTel(String wait_tel) {

        return dao.waitDetailTel(wait_tel);
    }

    @Override
    public int waitDelete(int wait_no) {

        return dao.delete(wait_no);
    }


    @Override
    public int getWaitingPosition(int event_no, int wait_no) {
        List<WaitDTO> waitingList = dao.whenIgetInNo(event_no);
        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).getWait_no() == wait_no) {
                return i + 1;
            }
        }
        return -1;
    }

    @Override
    public int getWaitingCount(int event_no) {
        List<WaitDTO> waitingList = dao.whenIgetInNo(event_no);
        return waitingList.size();
    }

    @Override
    public int updateStateToVisit(WaitDTO wait) {
        return dao.updateState(wait);
    }


    @Override
    public boolean canInsert(String wait_tel) {
        WaitDTO existingWait = dao.findByWaitTelAndState(wait_tel);
        return existingWait == null;
    }
    @Override
    public String getEntranceWaitTime(int event_no, int wait_no) {
        EventDTO event = eventDAO.getEventDetails(event_no);
        int waitLimit = event.getWait_limit();

        List<WaitDTO> waitingList = dao.getWaitingListByEventNo(event_no);
        waitingList.sort((w1, w2) -> Integer.compare(w1.getWait_no(), w2.getWait_no()));

        int position = -1;
        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).getWait_no() == wait_no) {
                position = i;
                break;
            }
        }

        if (position == -1) {
            throw new IllegalArgumentException("Invalid wait_no: " + wait_no);
        }

        if (position < waitLimit) {
            return "즉시 입장 가능합니다.";
        }

        for (int i = position - waitLimit; i >= 0; i -= waitLimit) {
            if ("visit".equals(waitingList.get(i).getState())) {
                LocalDateTime visitTime = waitingList.get(i).getWait_date().plusMinutes(30 * ((position - i) / waitLimit));
                return visitTime.format(DateTimeFormatter.ofPattern("HH:mm"));
            }
        }

        return "입장 가능 시간을 계산할 수 없습니다."; // default value if no valid visit state found
    }




}
