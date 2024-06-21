package com.multi.hereevent.category.interest;

import com.multi.hereevent.dto.CategoryInterestDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CategoryInterestDAOImpl implements CategoryInterestDAO{
    private final SqlSession sqlSession;

    @Override
    public int insertCategoryInterest(int category_no, int member_no) {
        Map<String, Integer> param = new HashMap<>();
        param.put("category_no", category_no);
        param.put("member_no", member_no);
        return sqlSession.insert("com.multi.hereevent.category.insertCategoryInterest", param);
    }

    @Override
    public int updateCategoryInterest(CategoryInterestDTO categoryInterest) {
        return 0;
    }

    @Override
    public int deleteCategoryInterest(int category_no, int member_no) {
        Map<String, Integer> param = new HashMap<>();
        param.put("category_no", category_no);
        param.put("member_no", member_no);
        return sqlSession.delete("com.multi.hereevent.category.deleteCategoryInterest", param);
    }

    @Override
    public List<CategoryInterestDTO> selectCategoryInterestByMemberNo(int memberNo) {
        return sqlSession.selectList("com.multi.hereevent.category.selectCategoryInterestByMemberNo", memberNo);
    }
}
