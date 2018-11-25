package com.imooc.sell.utils;

import java.util.Random;

/**
 * Created by majiwei
 * 2018/10/21 0021 12:13
 */
public class KeyUtil
{
    /**
     * 商城唯一的主键
     * 格式：时间+随机数
     * 加上synchronized避免在多线程下重复
     * @return
     */
    public static synchronized String getUniqueKey()
    {
        Random random = new Random();
        //生成6位随机数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
