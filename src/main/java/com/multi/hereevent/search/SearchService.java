package com.multi.hereevent.search;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private List<String> data;
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
    }
}
