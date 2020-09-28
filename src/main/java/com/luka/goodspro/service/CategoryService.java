package com.luka.goodspro.service;

import com.luka.goodspro.bean.Category;

public interface CategoryService {
    void insert(Category category);

    Long getCategoryIDByName(String categoryName);
}
