package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * 消息推送接口
 */
public interface IPushMessageService
{
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
