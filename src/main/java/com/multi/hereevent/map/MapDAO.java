package com.multi.hereevent.map;

import com.multi.hereevent.dto.ButtonDTO;
import com.multi.hereevent.dto.EventDTO;


import java.util.List;

public interface MapDAO {
    /*메인에서 뭐 클릭하면 지도관련창이 메인상태에서 밑으로나 옆으로 쭉 열리면 좋을듯*/
    List<EventDTO> button (ButtonDTO buttonDTO);

}
