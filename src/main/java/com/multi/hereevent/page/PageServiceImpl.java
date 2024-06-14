package com.multi.hereevent.page;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.page.PageDAO;
import com.multi.hereevent.page.PageService;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl implements PageService {

    private final PageDAO pageDAO;

    public PageServiceImpl(PageDAO eventDAO) {
        this.pageDAO = eventDAO;
    }

    @Override
    public EventDTO getEventDetails(int event_no) {
        return pageDAO.getEventDetails(event_no);
    }
}