package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * 买家service接口
 */
public interface IBuyerService
{
    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancel(String openid, String orderId);
}
