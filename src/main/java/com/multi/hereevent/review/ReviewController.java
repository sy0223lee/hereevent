package com.multi.hereevent.review;

import com.multi.hereevent.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @PostMapping("/review/insert")
    public String insertReview(ReviewDTO review){

        return "";
    }
}
