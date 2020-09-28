package com.luka.goodspro.mapper;

import com.luka.goodspro.bean.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {
    Category insert(Category category);

    Long getCategoryIDByName(@Param("categoryName")String categoryName);
}
