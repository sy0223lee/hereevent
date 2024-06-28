package com.multi.hereevent.search;

import com.multi.hereevent.event.EventEntity;
import com.multi.hereevent.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    /*private List<String> data;
    public SearchService(){

    }

    public List<String> search(String query){
        List<String> results = new ArrayList<>();
        for(String item:data){
            if(item.toLowerCase().contains(query.toLowerCase())){
                results.add(item);
            }
        }
        return results;
    }*/
    @Autowired
    private EventRepository eventRepository;

    public List<EventEntity> searchEvents(String keyword) {
        List<EventEntity> searchlist = eventRepository.findByNameContaining(keyword);
        return searchlist;
    }
}
