package com.multi.hereevent.search;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/search")
    public String search(){
        return "search/search";
    }
    @PostMapping("/search")
    public String searchResults(@RequestParam("query") String query, Model model){
        List<String> results = searchService.search(query);
        model.addAttribute("query", query);
        model.addAttribute("results", results); //나중에 실제 검색 결과로 대체, 데이터 들어오면 변경
        return "search/searchResults";
    }
}
