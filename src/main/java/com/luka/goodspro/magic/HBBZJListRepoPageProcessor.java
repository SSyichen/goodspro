package com.luka.goodspro.magic;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 一二级分类遍历，并添加三级分类url到爬取列表
 * @author horo
 */
public class HBBZJListRepoPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");


    @Override
    public void process(Page page) {
        Set<String> urls = new HashSet<>(page.getHtml().regex("supply/\\d+/\\d+").all());
        System.err.println(urls);
        //TODO: 筛选出本页面所属分类，判断数据库是否存在，没有则添加并缓存此分类ID
        urls.forEach(url -> {
            Spider.create(new DetailsRepoPageProcessor())
                    //从"http://www.bzjw.com/supply/11"开始抓
                    .addUrl("http://www.bzjw.com/" + url + "/page-1")
                    //开启5个线程抓取
                    .thread(1)
                    //启动爬虫
                    .run();
        });

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        List<Logger> loggerList = loggerContext.getLoggerList();
        loggerList.forEach(logger -> {
            logger.setLevel(Level.INFO);
        });

        for (int i = 11; i <= 16; i++){
            if(i == 16){
                i = 388;
            }
            Spider.create(new HBBZJListRepoPageProcessor())
                    //从"http://www.bzjw.com/supply/11"开始抓
                    .addUrl("http://www.bzjw.com/supply/" + i)
                    //开启5个线程抓取
                    .thread(1)
                    //启动爬虫
                    .run();
        }

    }
}
