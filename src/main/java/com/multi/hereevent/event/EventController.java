package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {
    private final EventService service;
    
    @GetMapping("/test")
    public String test() {
        return "main/bootTest";
    }
    @GetMapping("/main")
    public String mainPage() {
        return "main/mainPage";
    }
    @GetMapping("/test2")
    public String test2(Model model) {
        List<EventDTO> alleventlist = service.getAllEvent();
        model.addAttribute("alleventlist",alleventlist);
        List<EventDTO> openlist = service.getOpenEvent();
        model.addAttribute("openlist",openlist);
        List<EventDTO> popularlist = service.getPopularEvent();
        model.addAttribute("popularlist",popularlist);
        return "main/mainPage2";
    }

    //행사검색(프론트 아직)
    @GetMapping("/searchlist")
    public String searchPage() {
        return "main/search";
    }
    @PostMapping("/searchlist")
    public String searchlist(@RequestParam("keyword") String keyword, Model model) {
        List<EventDTO> searchlist = service.searchEvent(keyword);
        model.addAttribute("searchlist",searchlist);
        return "main/search";
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
    @PostMapping("/reservation")
    public String Reservation(ReservationDTO reservation){
        System.out.println(reservation);
        service.insertReserve(reservation);
        return "redirect:/event/test2";
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

    //카테고리별 리스트
    @GetMapping("/list")
    public String listCategory(@RequestParam("category_no") int category_no, Model model){
        //System.out.println("NO==>>"+ category_no);
        List<EventDTO> eventlist = service.selectEventByCategoryNo(category_no);
       // System.out.println("eventlist=>>>>"+eventlist);
        model.addAttribute("eventlist",eventlist);
        return "event/eventCategoryList";
    }


}

