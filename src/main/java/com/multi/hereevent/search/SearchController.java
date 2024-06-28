package com.multi.hereevent.search;

import com.multi.hereevent.event.EventEntity;
import com.multi.hereevent.event.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SearchController {
    private EventRepository eventRepository;
    @Autowired
    private SearchService searchService;

    @GetMapping("/event/search")
    public String searchEvents(@RequestParam("keyword") String keyword, Model model) {
        List<EventEntity> events = searchService.searchEvents(keyword);
        model.addAttribute("events", events);
        model.addAttribute("keyword", keyword);
        return "search/searchResults";
    }
}
