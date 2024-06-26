package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.dto.WaitDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class WaitServiceImpl implements WaitService {
    private final WaitDAO dao;

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
        return 0;
    }

    @Override
    public int getWaitingPosition(int event_no, int wait_no) {
        List<WaitDTO> waitingList = dao.getWaitingListByEventNo(event_no);
        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).getWait_no() == wait_no) {
                return i + 1;
            }
        }
        return -1;
    }

    @Override
    public int getWaitingCount(int event_no) {
        List<WaitDTO> waitingList = dao.getWaitingListByEventNo(event_no);
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


}
