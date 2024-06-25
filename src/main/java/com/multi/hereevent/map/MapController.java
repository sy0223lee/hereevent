package com.multi.hereevent.map;

import com.multi.hereevent.dto.ButtonDTO;
import com.multi.hereevent.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String clicktest(Model model){
        List<EventDTO> list = mapService.selectStill();
        model.addAttribute("list", list);
        return "kakaomap/clicktest";
    }

    @PostMapping("/clicktest/ajaxtest")
    @ResponseBody
    public List<EventDTO> ajaxtest(ButtonDTO buttonDTO){
        List<EventDTO> list = mapService.button(buttonDTO);
        System.out.println(buttonDTO);
        System.out.println(buttonDTO.getType());
        System.out.println(buttonDTO.getState());
        return list;
    }
}
