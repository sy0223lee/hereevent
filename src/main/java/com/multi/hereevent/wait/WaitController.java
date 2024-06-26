package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.WaitDTO;
import com.multi.hereevent.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        if(!service.canInsert(waitTel)){

            redirectAttributes.addAttribute("error", "이미 다른 팝업스토어에 대기 중 입니다.");

        }else {
            service.waitInsert(wait);


        }
        redirectAttributes.addAttribute("event_no", wait.getEvent_no());
        redirectAttributes.addAttribute("success", "true");
        return "redirect:/wait/register/event/{event_no}";
    }


    @GetMapping("/login")
    public String loginPage(){
        return "waitPage/waitlogin";
    }
    @PostMapping("/login")
    public String login(WaitDTO wait, Model model, RedirectAttributes redirectAttributes) {
        WaitDTO loginMyWait = service.waitLogin(wait);
        System.out.println(loginMyWait);
        WaitDTO waitDetailTel = service.waitDetailTel(wait.getWait_tel());
        System.out.println(waitDetailTel);
        model.addAttribute("wait", loginMyWait);
        redirectAttributes.addAttribute("wait_no", waitDetailTel.getWait_no());
        return "redirect:/wait/mywait/{wait_no}";

    }

    @GetMapping("/mywait/{wait_no}")
    public String mywait(@PathVariable("wait_no") int wait_no, Model model) {
        WaitDTO eventDetail = service.EventDetail(wait_no);
        System.out.println(eventDetail);
        model.addAttribute("event", eventDetail);
        return "waitPage/mywait";
    }
    @PostMapping("/updateState")
    @ResponseBody
    public String updateState(WaitDTO wait) {
        service.updateStateToVisit(wait);
        return "redirect:/wait/mywait/" + wait.getWait_no();
    }
    @PostMapping("/position")

    public String getWaitingPosition(@RequestParam("event_no") int event_no, @RequestParam("wait_no") int wait_no, Model model) {
        int position = service.getWaitingPosition(event_no, wait_no);
        int waitingCount = service.getWaitingCount(event_no);
        model.addAttribute("position", position);
        model.addAttribute("waitingCount", waitingCount);
        return "waitPage/mywait";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("wait_no") int wait_no) {
        service.waitDelete(wait_no);
        return "redirect:/event/main";
    }






}
