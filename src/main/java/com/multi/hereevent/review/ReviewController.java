package com.multi.hereevent.review;

import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.dto.ReviewDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes("member")
public class ReviewController {
    private final ReviewService service;

    // 이벤트 상세페이지에서 리뷰 조회
    // EventController에 작성

    // 리뷰 작성은 이벤트 상세페이지에서
    @PostMapping("/review/insert")
    public String insertReview(ReviewDTO review){
        int result = service.insertReview(review);
        if(result > 0){
            return "redirect:/event/" + review.getEvent_no();
        }else {
            return "common/errorPage";
        }
    }

    // 마이페이지에서 리뷰 조회
    @GetMapping("/myreview")
    public String myReviewPage(Model model){
        MemberDTO member = (MemberDTO) model.getAttribute("member");
        assert member != null;
        List<ReviewDTO> reviewList = service.selectReviewByMemberNo(member.getMember_no());
        model.addAttribute("reviewList", reviewList);
        return "mypage/myreview";
    }

    // 리뷰 수정과 삭제는 마이페이지에서
    @GetMapping("/myreview/update")
    public String updateReview(ReviewDTO review){
        int result = service.updateReview(review);
        if(result > 0){
            return "redirect:/myreview";
        }else {
            return "common/errorPage";
        }
    }
    @GetMapping("/myreview/delete")
    public String deleteReview(String event_no){
        int result = service.deleteReview(Integer.parseInt(event_no));
        if(result > 0){
            return "redirect:/myreview";
        }else {
            return "common/errorPage";
        }
    }
}
