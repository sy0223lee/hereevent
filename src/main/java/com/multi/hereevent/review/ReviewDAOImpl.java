package com.multi.hereevent.review;

import com.multi.hereevent.dto.ReviewDTO;
import com.multi.hereevent.dto.ReviewImgDTO;
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
        return sqlSession.insert("com.multi.hereevent.review.insertReview", review);
    }

    @Override
    public int insertReviewImg(List<ReviewImgDTO> imgList) {
        return sqlSession.insert("com.multi.hereevent.review.insertReviewImg", imgList);
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
        return sqlSession.selectList("com.multi.hereevent.review.selectReviewByEventNo", event_no);
    }

    @Override
    public List<ReviewDTO> selectReviewByMemberNo(int member_no) {
        return sqlSession.selectList("com.multi.hereevent.review.selectReviewByMemberNo", member_no);
    }

    @Override
    public List<ReviewImgDTO> selectReviewImgs(int review_no) {
        return sqlSession.selectList("com.multi.hereevent.review.selectReviewImgs", review_no);
    }
}
