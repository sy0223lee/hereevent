package com.multi.hereevent.map;

import com.multi.hereevent.dto.EventDTO;

import java.util.List;

public interface MapService {
    List<EventDTO> button (String state, String type);
}
