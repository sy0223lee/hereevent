package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.fileupload.FileUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    private EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping("/main")
    public String main() {
        return "main/mainPage";
    }
    @GetMapping("/test")
    public String test() {
        return "main/Test";
    }
    @GetMapping("/write")
    public String write() {
        return "event/event_write";
    }

//   세부페이지
    @GetMapping("/{event_no}")
    public String getEventDetails(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = service.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "detailedPage/detailedPage";
    }
    //상세정보
    @GetMapping("/content/{event_no}")
    public String showContent(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = service.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "detailedPage/content";
    }
    //길찾기
    @GetMapping("/navigation/{event_no}")
    public String showNavigation(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = service.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "detailedPage/navigation";
    }
    //예약
    @GetMapping("/reservation/{event_no}")
    public String showReservation(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = service.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);

        return "detailedPage/reservation";
    }
    //후기
    @GetMapping("/review/{event_no}")
    public String showReview(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = service.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "detailedPage/review";
    }

    //이벤트 사진 가져오기

    @GetMapping("/image/{eventNo}")
    @ResponseBody
    public EventDTO getEventImage(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = service.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return service.getEventImage(event_no);
    }
}

