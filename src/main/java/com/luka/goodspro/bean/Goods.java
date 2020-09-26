package com.luka.goodspro.bean;

import com.luka.goodspro.pipeline.GoodsModelPipeline;
import lombok.Data;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.Formatter;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.util.Date;

@Data
@TargetUrl("http://www.bzjw.com/supply/SupplyDetail_\\d*_\\d*.cfml")
@HelpUrl("233")
public class Goods {
    private Integer id;
    //标题
    @ExtractBy("//h2[@id='span_big_title']/text()")
    private String title;
    //规格
    @ExtractBy("//span[@id='span_made']/text()")
    private String specifications;
    //类型id
    private Integer categoryId;
    //分类名称
    @ExtractBy("//span[@id='span_IndustryType']/text()")
    private String categoryName;
    //是否标准件
    @ExtractBy("//span[@id='span_ShowPara']/table/tbody/tr[1]/td[1]/text()")
    private String isStandard;
    //材质
    @ExtractBy("//span[@id='span_ShowPara']/table/tbody/tr[1]/td[1]/text()")
    private String materials;
    //处理
    @ExtractBy("//span[@id='span_ShowPara']/table/tbody/tr[1]/td[1]/text()")
    private String handle;
    //发布时间
    @Formatter("yyyy/MM/dd HH:mm:ss")
    @ExtractBy("//span[@id='span_UpdateTime']/regex('\\d+/\\d+/\\d+\\s\\d+:\\d+:\\d+')")
    private Date createTime;
    //所在地
    @ExtractBy("//span[@id='span_area']/text()")
    private String location;
    //等级
    @ExtractBy("////span[@id='span_ShowPara']/table/tbody/tr[1]/td[1]/text()")
    private String level;
    //硬度
    @ExtractBy("//span[@id='span_ShowPara']/table/tbody/tr[1]/td[1]/text()")
    private String solidity;
    //螺纹类型
    @ExtractBy("//span[@id='span_ShowPara']/table/tbody/tr[1]/td[1]/text()")
    private String threadType;
    //品牌
    private Integer brandId;
    //品牌名称
    @ExtractBy("//span[@id='span_ShowPara']/table/tbody/tr[1]/td[1]/text()")
    private String brandName;
    //标准类型
    @ExtractBy("//span[@id='span_ShowPara']/table/tbody/tr[1]/td[1]/text()")
    private String standardType;
    //标准编号
    @ExtractBy("//span[@id='span_ShowPara']/table/tbody/tr[1]/td[1]/text()")
    private String standardNum;
    //产品详情
    @ExtractBy("//div[@class='txt']/text()")
    private String content;
    //供应商id
    private Integer supplierId;

    @ExtractBy("//div[@class='company_da']/div/h4/a/span/text()")
    private String splname;
    @ExtractBy("//span[@id='span_info']/text()")
    private String spldetails;
    @ExtractBy("//ul[@class='txt']/li[3]/text()")
    private String splphone;
    @ExtractBy("//div[@class='txt1']/p/em/text()")
    private String splmodel;
    @ExtractBy("//span[@id='span_area3']/text()")
    private String spllocation;

    @ExtractBy("//ul[@class='txt']/li[1]/text()")
    private String contactName;
    @ExtractBy("//ul[@class='txt']/li[2]/text()")
    private String contactTel;
    private String email;

}
