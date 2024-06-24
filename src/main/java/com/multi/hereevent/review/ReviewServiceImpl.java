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

    @Transactional
    @Override
    public int deleteReview(int review_no) {
        dao.deleteReviewImg(review_no);
        return dao.deleteReview(review_no);
    }

    @Transactional
    @Override
    public ReviewDTO selectReviewWithEventImg(int review_no) {
        ReviewDTO review = dao.selectReviewWithEventImg(review_no);
        review.setReview_imgs(dao.selectReviewImgs(review_no));
        return review;
    }

    @Transactional
    @Override
    public List<ReviewDTO> selectReviewByEventNo(int event_no) {
        List<ReviewDTO> reviewList = dao.selectReviewByEventNo(event_no);
        for(ReviewDTO review : reviewList){
            review.setReview_imgs(dao.selectReviewImgs(review.getReview_no()));
        }
        return reviewList;
    }

    @Transactional
    @Override
    public List<ReviewDTO> selectReviewByMemberNo(int member_no) {
        List<ReviewDTO> reviewList = dao.selectReviewByMemberNo(member_no);
        for(ReviewDTO review : reviewList){
            review.setReview_imgs(dao.selectReviewImgs(review.getReview_no()));
        }
        return reviewList;
    }
}
