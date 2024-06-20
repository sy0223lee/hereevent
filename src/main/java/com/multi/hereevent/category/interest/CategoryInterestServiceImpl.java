package com.multi.hereevent.category.interest;

import com.multi.hereevent.dto.CategoryInterestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryInterestServiceImpl implements CategoryInterestService {
    private final CategoryInterestDAO dao;

    @Override
    public int insertCategoryInterest(int category_no, int member_no) {
        return dao.insertCategoryInterest(category_no, member_no);
    }

    @Override
    public int updateCategoryInterest(CategoryInterestDTO categoryInterest) {
        return 0;
    }

    @Override
    public int deleteCategoryInterest(int category_no, int member_no) {
        return dao.deleteCategoryInterest(category_no, member_no);
    }

    @Override
    public List<CategoryInterestDTO> selectCategoryInterestByMemberNo(int memberNo) {
        return dao.selectCategoryInterestByMemberNo(memberNo);
    }
}
