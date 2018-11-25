package com.imooc.sell.utils;

import com.imooc.sell.enums.CodeEnum;

/**
 * Created by majiwei
 * 2018/11/17 10:47
 */
public class EnumUtil
{
    /**
     * 根据code和枚举类对象获取枚举
     * @param code
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass)
    {
        for (T each : enumClass.getEnumConstants())
        {
            if(code.equals(each.getCode()))
            {
                return each;
            }
        }
        return null;
    }
}
