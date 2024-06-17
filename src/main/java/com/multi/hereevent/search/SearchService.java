package com.multi.hereevent.search;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private List<String> data;
    public SearchService(){
        //확인용 데이터
        data = new ArrayList<>();
        data.add("떡볶이 팝업스토어");
        data.add("아이돌 팝업스토어");
        data.add("성수 팝업스토어");
        data.add("캐릭터 팝업스토어");
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
