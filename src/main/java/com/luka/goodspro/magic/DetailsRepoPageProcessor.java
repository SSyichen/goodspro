package com.luka.goodspro.magic;

import com.luka.goodspro.bean.Goods;
import com.luka.goodspro.pipeline.GoodsModelPipeline;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 遍历三级分类下所有page页，并将匹配到的商品详细url添加到爬取列表
 * @author horo
 */
public class DetailsRepoPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");

    @Override
    public void process(Page page) {

        String nextStr = page.getHtml().xpath("//a[@id='hl_next']/@href").toString();
        String nextUrl = getUrl(page.getUrl().toString(), nextStr);

        List<String> urls = page.getHtml().regex("http://www.bzjw.com/supply/SupplyDetail_\\d*_\\d*.cfml").all();
        Set<String> urlsSet = new HashSet<>(urls);
        OOSpider.create(Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36")
                , new GoodsModelPipeline(), Goods.class)
                .addUrl(urlsSet.toArray(new String[urlsSet.size()])).thread(8).run();

        page.addTargetRequest(nextUrl);
    }

    private String getUrl(String urlResource, String nextUrl){
        if(StringUtils.isEmpty(nextUrl)){
            return "not found";
        }
        String[] urlSplit = nextUrl.split("/");
        int lastIndex = urlResource.lastIndexOf("/");
        return urlResource.substring(0, lastIndex + 1) + urlSplit[urlSplit.length - 1];
    }

    @Override
    public Site getSite() {
        return site;
    }
}
