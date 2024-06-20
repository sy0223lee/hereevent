package com.multi.hereevent.map;

import com.multi.hereevent.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String clicktest(@RequestParam("state") String state, @RequestParam("type") String type, Model model){
        System.out.println("clicktest");
        List<EventDTO> list = mapService.button(state,type);
        model.addAttribute("list",list);
        return "kakaomap/clicktest";
    }
}
