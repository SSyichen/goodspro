package com.luka.goodspro.mapper;

import com.luka.goodspro.bean.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品mapper
 * @author horo
 */
@Repository
public interface GoodsMapper {

    /**
     * 查询所有商品
     * @return 商品集合
     */
    List<Goods> selectGoodsAll();

    void insert (Goods goods);

}
