package com.multi.hereevent.page;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PageController {
    @GetMapping("/detailedPage")
    public String showDetailedPage() {
        return "detailedPage/detailedPage";
    }
}
