package com.luka.goodspro.mapper;

import com.luka.goodspro.bean.Brank;
import com.luka.goodspro.bean.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 品牌mapper
 * @author horo
 */
@Repository
public interface BrankMapper {

    /**
     * 添加品牌
     * @return 商品集合
     */
    Brank insert (Brank brank);

}
