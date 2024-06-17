package com.multi.hereevent.page;

import com.multi.hereevent.dto.EventDTO;

public interface PageDAO {
    public EventDTO getEventDetails(int event_no);
}
