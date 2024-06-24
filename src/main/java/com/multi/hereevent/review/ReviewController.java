package com.multi.hereevent.review;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.dto.ReviewDTO;
import com.multi.hereevent.dto.ReviewImgDTO;
import com.multi.hereevent.event.EventService;
import com.multi.hereevent.fileupload.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes("member")
public class ReviewController {
    private final ReviewService reviewService;
    private final EventService eventService;
    private final FileUploadService fileUploadService;

    // 이벤트 상세페이지에서 리뷰 조회
    // EventController에 작성

    // 리뷰 작성은 이벤트 상세페이지에서
    @PostMapping("/review/insert")
    public String insertReview(ReviewDTO review) throws IOException {
        List<MultipartFile> fileList = review.getFiles();
        List<ReviewImgDTO> imgList = fileUploadService.uploadReviewImg(fileList);
        int result = reviewService.insertReview(review, imgList);
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
        List<ReviewDTO> reviewList = reviewService.selectReviewByMemberNo(member.getMember_no());
        model.addAttribute("reviewList", reviewList);
        return "mypage/myreview";
    }

    // 리뷰 수정과 삭제는 마이페이지에서
    @GetMapping("/myreview/update")
    public String updateReviewPage(@RequestParam("review_no") String review_no, Model model){
        ReviewDTO review = reviewService.selectReviewWithEventImg(Integer.parseInt(review_no));
        model.addAttribute("review", review);
        return "mypage/editReview";
    }
    @PostMapping("/myreview/update")
    public String updateReview(ReviewDTO review){
        int result = reviewService.updateReview(review);
        if(result > 0){
            return "redirect:/myreview";
        }else {
            return "common/errorPage";
        }
    }
    @PostMapping("/myreview/delete")
    public String deleteReview(@RequestParam("review_no") String review_no){
        int result = reviewService.deleteReview(Integer.parseInt(review_no));
        if(result > 0){
            return "redirect:/myreview";
        }else {
            return "common/errorPage";
        }
    }
}
