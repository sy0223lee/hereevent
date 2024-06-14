package com.multi.hereevent.page;

import com.multi.hereevent.dto.EventDTO;

public interface PageService {
    EventDTO getEventDetails(int event_no);
}