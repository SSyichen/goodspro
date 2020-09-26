package com.luka.goodspro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luka.goodspro.mapper")
public class GoodsproApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsproApplication.class, args);
    }

}
