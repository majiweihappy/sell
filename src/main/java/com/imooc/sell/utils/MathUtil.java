package com.imooc.sell.utils;

/**
 * Created by majiwei
 * 2018/11/11 20:23
 */
public class MathUtil
{
    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较两个金额是否相等
     * @param d1
     * @param d2
     * @return (两个数的差满足某个精度则认为相等)
     */
    public static Boolean equals(Double d1, Double d2)
    {
        Double result = Math.abs(d1 - d2);
        if(result < MONEY_RANGE)
        {
            return true;
        }
        return false;
    }
}
