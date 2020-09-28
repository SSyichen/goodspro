package com.luka.goodspro.service.impl;

import com.luka.goodspro.bean.Goods;
import com.luka.goodspro.mapper.GoodsMapper;
import com.luka.goodspro.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author horo
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAll() {
        return goodsMapper.selectGoodsAll();
    }

    @Override
    public void insert(Goods goods) {
        goodsMapper.insert(goods);
    }
}
