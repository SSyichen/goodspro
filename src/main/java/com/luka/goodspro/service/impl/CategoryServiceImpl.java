package com.luka.goodspro.service.impl;

import com.luka.goodspro.bean.Category;
import com.luka.goodspro.mapper.CategoryMapper;
import com.luka.goodspro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void insert(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public Long getCategoryIDByName(String categoryName) {
        return categoryMapper.getCategoryIDByName(categoryName);
    }
}
