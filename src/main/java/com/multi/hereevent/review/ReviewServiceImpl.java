package com.multi.hereevent.review;

import com.multi.hereevent.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private ReviewDAO dao;

    @Override
    public int insertReview(ReviewDTO review) {
        return 0;
    }

    @Override
    public int updateReview(ReviewDTO review) {
        return 0;
    }

    @Override
    public int deleteReview(int review_no) {
        return 0;
    }

    @Override
    public List<ReviewDTO> selectReviewByEventNo(int event_no) {
        return List.of();
    }

    @Override
    public List<ReviewDTO> selectReviewByMemberNo(int member_no) {
        return List.of();
    }
}