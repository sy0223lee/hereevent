package com.multi.hereevent.category;

import com.multi.hereevent.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Override
    public int insertCategory(CategoryDTO category) {
        return 0;
    }

    @Override
    public int updateCategory(CategoryDTO category) {
        return 0;
    }

    @Override
    public int deleteCategory(CategoryDTO category) {
        return 0;
    }

    @Override
    public List<CategoryDTO> selectCategoryByName() {
        return List.of();
    }

    @Override
    public List<CategoryDTO> selectCategoryByValue() {
        return List.of();
    }
}
