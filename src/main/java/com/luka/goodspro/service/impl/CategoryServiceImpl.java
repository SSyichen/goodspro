package com.luka.goodspro.service.impl;

import com.luka.goodspro.bean.Category;
import com.luka.goodspro.constant.Constants;
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
        //类别
        boolean categoryFlag = Constants.categoryMap.containsKey(categoryName);
        if (categoryFlag){
            return Constants.categoryMap.get(categoryName);
        }

        Long categoryId = categoryMapper.getCategoryIDByName(categoryName);
        if (categoryId != null){
            Constants.categoryMap.put(categoryName, categoryId);
            return categoryId;
        }
        Category category = Category.builder().name(categoryName).build();
        categoryMapper.insert(category);
        Constants.categoryMap.put(categoryName, category.getId());
        return category.getId();
    }
}
