package com.multi.hereevent.review;

import com.multi.hereevent.dto.ReviewDTO;
import com.multi.hereevent.dto.ReviewImgDTO;

import java.util.List;

public interface ReviewService {
    int insertReview(ReviewDTO review, List<ReviewImgDTO> imgList); // 리뷰 등록
    int updateReview(ReviewDTO review); // 리뷰 수정
    int deleteReview(int review_no); // 리뷰 삭제
    ReviewDTO selectReview(int review_no);
    List<ReviewDTO> selectReviewByEventNo(int event_no); // 이벤트 번호에 해당하는 리뷰 조회
    List<ReviewDTO> selectReviewByMemberNo(int member_no); // 회원 번호에 해당하는 리뷰 조회
}
