package com.multi.hereevent.map;

import com.multi.hereevent.dto.ButtonDTO;
import com.multi.hereevent.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService{
    private final MapDAO dao;

    @Override
    public List<EventDTO> button(ButtonDTO buttonDTO) {
        return dao.button(buttonDTO);
    }
}
