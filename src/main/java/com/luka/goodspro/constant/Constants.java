package com.luka.goodspro.constant;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 常量类
 * @author horo
 */
public class Constants {

    public static volatile ConcurrentMap<String, Long> categoryMap = new ConcurrentHashMap<>(300);
    public static volatile ConcurrentMap<String, Long> brandMap = new ConcurrentHashMap<>(300);

}
