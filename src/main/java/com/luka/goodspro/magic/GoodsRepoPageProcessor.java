package com.luka.goodspro.magic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * 最终商品详情页爬取
 * @author horo
 */
public class GoodsRepoPageProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        //TODO 封装商品信息
        String title = html.xpath("//h2[@id='span_big_title']/text()").toString();

        //TODO 尝试根据分类名称和商家名字从缓存获取分类ID和品牌ID     如果获取不到则进行新增并赋予商品信息进行保存然后将分类品牌信息进行缓存

    }

    @Override
    public Site getSite() {
        return null;
    }
}
