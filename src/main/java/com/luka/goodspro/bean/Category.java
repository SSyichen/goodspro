package com.luka.goodspro.bean;

import lombok.Builder;
import lombok.Data;

/**
 * 分类
 */
@Data
@Builder
public class Category {
    private Long id;
    private String name;
}
