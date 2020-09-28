package com.luka.goodspro.service;

import com.luka.goodspro.bean.Goods;

import java.util.List;

/**
 * 商品服务类
 * @author horo
 */
public interface GoodsService {
    /**
     * 查询所有商品
     * @return
     */
    List<Goods> findAll();

    void insert (Goods goods);

}
