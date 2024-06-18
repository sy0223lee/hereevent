package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.ReviewDTO;
import com.multi.hereevent.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;
    private final ReviewService reviewService;

    @GetMapping("/main")
    public String mainPage() {
        return "main/test";
    }
    @GetMapping("/test")
    public String test() {
        return "main/Test";
    }


    //행사검색(프론트 아직)
    @GetMapping("/searchlist")
    public ModelAndView searchlist(@RequestParam("keyword") String keyword) {
        ModelAndView mav = new ModelAndView("main/search");
        List<EventDTO> searchlist = eventService.searchEvent(keyword);
        mav.addObject("searchlist",searchlist);
        return mav;
    }

    //전체행사조회(프론트 아직)
    @GetMapping("/alleventlist")
    public ModelAndView getAllEvent(){
        ModelAndView mav = new ModelAndView("main/alllistTest");
        List<EventDTO> alleventlist = eventService.getAllEvent();
        mav.addObject("alleventlist",alleventlist);
        return mav;
    }

    //오픈예정행사(프론트 아직)
    @GetMapping("/openlist")
    public ModelAndView getOpenEvent(){
        ModelAndView mav = new ModelAndView("main/listTest");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        List<EventDTO> openlist = eventService.getOpenEvent(today);
        mav.addObject("openlist",openlist);
        mav.addObject("today", today);
        return mav;
    }

    //예약/대기많은행사 top10(프론트 아직)
    @GetMapping("/popularlist")
    public ModelAndView getPopularEvent(){
        ModelAndView mav = new ModelAndView("main/popularlistTest");
        List<EventDTO> popularlist = eventService.getPopularEvent();
        mav.addObject("popularlist",popularlist);
        return mav;
    }

//   세부페이지
    @GetMapping("/{event_no}")
    public String getEventDetails(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = eventService.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "detailedPage/detailedPage";
    }
    //상세정보
    @GetMapping("/content/{event_no}")
    public String showContent(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = eventService.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "detailedPage/content";
    }
    //길찾기
    @GetMapping("/navigation/{event_no}")
    public String showNavigation(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = eventService.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "detailedPage/navigation";
    }
    //예약
    @GetMapping("/reservation/{event_no}")
    public String showReservation(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = eventService.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);

        return "detailedPage/reservation";
    }
    //후기
    @GetMapping("/review/{event_no}")
    public String showReview(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = eventService.getEventDetails(event_no);
        List<ReviewDTO> reviewList = reviewService.selectReviewByEventNo(event_no);
        model.addAttribute("event", eventDetails);
        model.addAttribute("reviewList", reviewList);
        return "detailedPage/review";
    }

    //이벤트 사진 가져오기
    @GetMapping("/image/{eventNo}")
    @ResponseBody
    public EventDTO getEventImage(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = eventService.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return eventService.getEventImage(event_no);
    }
}

