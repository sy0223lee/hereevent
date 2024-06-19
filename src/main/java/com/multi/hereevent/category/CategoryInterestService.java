package com.multi.hereevent.category;

import com.multi.hereevent.dto.CategoryDTO;
import com.multi.hereevent.dto.CategoryInterestDTO;

import java.util.List;

public interface CategoryInterestService {
    int insertCategoryInterest(int category_no, int member_no);
    int updateCategoryInterest(CategoryInterestDTO categoryInterest);
    int deleteCategoryInterest(int category_no, int member_no);
    List<CategoryInterestDTO> selectCategoryInterestByMemberNo(int memberNo); // 회원이 등록한 관심 카테고리 조회
}
