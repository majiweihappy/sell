package com.imooc.sell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.sell.dataobject.mapper")
@EnableCaching//启动缓存
public class SellApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SellApplication.class, args);
    }
}
