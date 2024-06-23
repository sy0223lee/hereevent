package com.multi.hereevent.map;

import com.multi.hereevent.dto.ButtonDTO;
import com.multi.hereevent.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {
    private final MapService mapService;

    @GetMapping("/kakaomap.html")
    public String address(){
        System.out.println("카카오지도");
        return "kakaomap/kakaomap";
    }

    @GetMapping("/clicktest")
    public String clicktest(){
        return "kakaomap/clicktest";
    }
    @GetMapping("/clicktest/ajaxtest")
    @ResponseBody
    public List<EventDTO> ajaxtest(@RequestBody ButtonDTO buttonDTO){
        List<EventDTO> list = mapService.button(buttonDTO);
        System.out.println(buttonDTO);
        System.out.println(buttonDTO.getState());
        System.out.println(buttonDTO.getType());
        return list;
    }
}
