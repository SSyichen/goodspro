package com.luka.goodspro.magic;

import com.luka.goodspro.bean.Goods;
import com.luka.goodspro.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * 最终商品详情页爬取
 * @author horo
 */
public class GoodsRepoPageProcessor implements PageProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(GoodsRepoPageProcessor.class);
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");


    @Override
    public void process(Page page) {
        Goods goods = null;
        //TODO 封装商品信息
        try {
            goods = BeanUtils.getBeanByPage(page, Goods.class);
        } catch (Exception e) {
            LOG.error("bean封装时发生异常...", e);
        }
        /**
         * 先从缓存取，取不到数据库取 取到添加到缓存
         * Long categoryId = goodsService.getCategoryIDByName(goods.getCategory());
         * Long brandId = goodsService.getCrandIDByName(goods.getBrand());
         * goods.setcategory(categoryId);
         * goods.setbrand(brandId);
         *
         * 保存信息
         * goodsService.Save(goods);
         */
        System.err.println(goods);
        //TODO 尝试根据分类名称和商家名字从缓存获取分类ID和品牌ID     如果获取不到则进行新增并赋予商品信息进行保存然后将分类品牌信息进行缓存

    }

    @Override
    public Site getSite() {
        return site;
    }
}
