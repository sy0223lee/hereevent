package com.multi.hereevent.event;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
public class EventController {
    private EventService service;

    public EventController(EventService service) {
        this.service = service;
    }


}
