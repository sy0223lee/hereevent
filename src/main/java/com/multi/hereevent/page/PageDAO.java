package com.multi.hereevent.page;

import com.multi.hereevent.dto.PageDTO;

public interface PageDAO {
    PageDTO getEventDetails(int event_no);
    }