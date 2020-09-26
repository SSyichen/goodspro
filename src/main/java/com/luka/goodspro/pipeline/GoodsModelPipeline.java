package com.luka.goodspro.pipeline;

import com.luka.goodspro.bean.Goods;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.HashMap;
import java.util.Map;

public class GoodsModelPipeline implements PageModelPipeline<Goods> {
    static volatile Map<String,Object> map = new HashMap<String,Object>();


    @Override
    public void process(Goods goods, Task task) {
        System.out.println(goods);
    }



    public String parseString (Object o){
        if (o == null){
            return "";
        }else{
            String[] split = o.toString().split(":");
            if (split.length > 1){
                return split[1];
            }else{
                return "";
            }
        }
    }
}
