package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.dto.WaitDTO;
import com.multi.hereevent.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import java.util.List;

@Controller
@RequestMapping("/wait")
@RequiredArgsConstructor
public class WaitController {
    private final WaitService service;
    private final EventService eventService;

    @GetMapping("/register/event/{event_no}")
    public String register(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = eventService.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "waitPage/waitregister";
    }
    @PostMapping("/insert")
    public String register(WaitDTO wait, RedirectAttributes redirectAttributes, @RequestParam("wait_tel") String waitTel){
        System.out.println(wait);
        service.waitInsert(wait);
        redirectAttributes.addAttribute("event_no", wait.getEvent_no());
        if(!service.canInsert(waitTel)){
            return "redirect:/wait/register/event/{event_no}";
        }else{
            return "redirect:/waitregister?error=waitExists";
        }
    }


    @GetMapping("/login")
    public String loginPage() {
        return "waitPage/waitlogin";
    }
    @PostMapping("/login")
    public String login(WaitDTO wait, Model model) {
        WaitDTO waitLogin = service.waitLogin(wait);
        model.addAttribute("wait",waitLogin);
        return "redirect:/wait/waitPage/waitlist";
    }


    @GetMapping("/list")
    public String waitlist(WaitDTO wait, Model model) {
        System.out.println(wait);
        model.addAttribute("wait", wait);
        return "waitPage/waitlist";
    }




}
