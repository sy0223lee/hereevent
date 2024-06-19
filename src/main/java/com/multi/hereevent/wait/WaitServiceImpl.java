package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
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
    public List<WaitDTO> waitList() {
        return List.of();
    }

    @Override
    public WaitDTO waitDetail(int wait_no) {
        return dao.waitDetail(wait_no);
    }

    @Override
    public int waitDelete(int wait_no) {
        return 0;
    }
}
