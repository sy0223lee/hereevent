package com.multi.hereevent.page;

import com.multi.hereevent.dto.EventDTO;

public interface PageDAO {
    EventDTO getEventDetails(int eventNo);
}
