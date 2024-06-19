package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.WaitDTO;

import java.util.List;

public interface WaitService {
    WaitDTO waitLogin(WaitDTO wait);

    int waitInsert(WaitDTO wait);

    List<WaitDTO> waitList();

    WaitDTO waitDetail(int wait_no);
    int waitDelete(int wait_no);


}
