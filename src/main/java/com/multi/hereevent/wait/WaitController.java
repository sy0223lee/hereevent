package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wait")
@RequiredArgsConstructor
public class WaitController {
    private final EventService service;

    @GetMapping("/register")
    public String register(@PathVariable("event_no") int event_no, Model model) {

        EventDTO eventDetails = service.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "waitPage/waitregister";
    }
    @PostMapping("/insert")
    public String register(MemberDTO member){
        //service.waitInsert(member);
        return "redirect:/register";
    }

}
