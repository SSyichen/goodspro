package com.luka.goodspro.controller;

import com.luka.goodspro.bean.Goods;
import com.luka.goodspro.magic.HBBZJListRepoPageProcessor;
import com.luka.goodspro.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

import java.util.List;

/**
 * 商品controller
 * @author horo
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 查询所有商品信息
     * @return 商品集合
     */
    @RequestMapping("/findAll")
    public List<Goods> findAll(){
        return goodsService.findAll();
    }

    public String magicGoods(){
        Spider.create(new HBBZJListRepoPageProcessor())
                //从"http://www.bzjw.com/supply/11"开始抓
                .addUrl("http://www.bzjw.com/supply/11")
                //开启5个线程抓取
                .thread(1)
                //启动爬虫
                .run();
        return "success";
    }

}
