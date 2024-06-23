package com.multi.hereevent.review;

import com.multi.hereevent.dto.ReviewDTO;
import com.multi.hereevent.dto.ReviewImgDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewDAO dao;

    @Transactional
    @Override
    public int insertReview(ReviewDTO review, List<ReviewImgDTO> imgList) {
        if(imgList.isEmpty()){
            return dao.insertReview(review);
        }else{
            dao.insertReview(review);
            return dao.insertReviewImg(imgList);
        }
    }

    @Override
    public int updateReview(ReviewDTO review) {
        return dao.updateReview(review);
    }

    @Override
    public int deleteReview(int review_no) {
        return 0;
    }

    @Override
    public List<ReviewDTO> selectReviewByEventNo(int event_no) {
        return dao.selectReviewByEventNo(event_no);
    }

    @Override
    public List<ReviewDTO> selectReviewByMemberNo(int member_no) {
        return dao.selectReviewByMemberNo(member_no);
    }
}
