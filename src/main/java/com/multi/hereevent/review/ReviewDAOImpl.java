package com.multi.hereevent.review;

import com.multi.hereevent.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewDAOImpl implements ReviewDAO{
    private final SqlSession sqlSession;

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
