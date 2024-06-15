package com.multi.hereevent.event;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
