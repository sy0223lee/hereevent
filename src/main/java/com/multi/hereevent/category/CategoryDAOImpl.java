package com.multi.hereevent.category;

import com.multi.hereevent.dto.CategoryDTO;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO{
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
