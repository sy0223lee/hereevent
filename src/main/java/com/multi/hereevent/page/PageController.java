package com.multi.hereevent.page;

import com.multi.hereevent.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PageController {

    private final PageService pageService;

    @GetMapping("/event/{event_no}")
    public String getEventDetails(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = pageService.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "detailedPage/detailedPage";
    }

    @GetMapping("/detailedPage/content/{event_no}")
    public String showContent(@PathVariable("event_no") int event_no, Model model) {
        EventDTO eventDetails = pageService.getEventDetails(event_no);
        model.addAttribute("event", eventDetails);
        return "detailedPage/content";
    }

    @GetMapping("/detailedPage/navigation/{event_no}")
    public String showNavigation() {
        return "detailedPage/navigation";
    }

    @GetMapping("/detailedPage/reservation/{event_no}")
    public String showReservation() {
        return "detailedPage/reservation";
    }

    @GetMapping("/detailedPage/review/{event_no}")
    public String showReview() {
        return "detailedPage/review";
    }

}