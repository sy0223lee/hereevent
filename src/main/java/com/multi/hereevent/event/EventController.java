package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.fileupload.FileUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    private EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping("/main")
    public String mainPage() {
        return "main/mainPage";
    }



    //행사검색(프론트 아직)
    @GetMapping("/searchlist")
    public String searchPage() {
        return "main/search";
    }
    @PostMapping("/searchlist")
    public ModelAndView searchlist(@RequestParam("keyword") String keyword) {
        ModelAndView mav = new ModelAndView("main/search");
        List<EventDTO> searchlist = service.searchEvent(keyword);
        mav.addObject("searchlist",searchlist);
        return mav;
    }
    //전체행사조회(프론트 아직)
    @GetMapping("/alleventlist")
    public ModelAndView getAllEvent(){
        ModelAndView mav = new ModelAndView("main/alllistTest");
        List<EventDTO> alleventlist = service.getAllEvent();
        mav.addObject("alleventlist",alleventlist);
        return mav;
    }

    //오픈예정행사(프론트 아직)
    @GetMapping("/openlist")
    public ModelAndView getOpenEvent(){
        ModelAndView mav = new ModelAndView("main/mainPage");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        List<EventDTO> openlist = service.getOpenEvent(today);
        mav.addObject("openlist",openlist);
        return mav;
    }

    //예약/대기많은행사 top10(프론트 아직)
    @GetMapping("/popularlist")
    public ModelAndView getPopularEvent(){
        ModelAndView mav = new ModelAndView("main/popularlistTest");
        List<EventDTO> popularlist = service.getPopularEvent();
        mav.addObject("popularlist",popularlist);
        return mav;
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

