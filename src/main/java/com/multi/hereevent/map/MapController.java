package com.multi.hereevent.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
    @GetMapping("/kakaomap.html")
    public String address(){
        System.out.println("카카오지도");
        return "kakaomap/kakaomap";
    }
}
