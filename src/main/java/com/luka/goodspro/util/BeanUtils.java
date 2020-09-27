package com.luka.goodspro.util;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.Formatter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * entity工具类
 * @author horo
 */
public class BeanUtils {

    public static <T>T getBeanByPage(Page page, Class<T> cls) throws IllegalAccessException, InstantiationException {
        T t = cls.newInstance();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldValue = null;
            if (field.isAnnotationPresent(ExtractBy.class)){
                ExtractBy extractBy = field.getAnnotation(ExtractBy.class);
                fieldValue = page.getHtml().xpath(extractBy.value()).toString();
            }
            if (fieldValue != null && field.isAnnotationPresent(Formatter.class)){
                String formatStr = field.getAnnotation(Formatter.class).value()[0];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
                fieldValue = LocalDateTime.parse(fieldValue.toString(), formatter);
            }
            field.set(t, fieldValue);
        }
        return t;
    }

}
