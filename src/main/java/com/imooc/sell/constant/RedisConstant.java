package com.imooc.sell.constant;

/**
 * Redis常量
 * Created by majiwei
 * 2018/11/19 20:46
 */
public interface RedisConstant
{
    String TOKEN_PREFIX = "token_%s";

    //超时时间2小时
    Integer EXPIRE = 7200;
}
