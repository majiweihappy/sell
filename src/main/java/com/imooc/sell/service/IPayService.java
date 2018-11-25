package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * 订单支付接口
 */
public interface IPayService
{
    /** 发起支付. */
    PayResponse create(OrderDTO orderDTO);

    /** 异步通知. */
    PayResponse notify(String notifyData);

    /** 退款. */
    RefundResponse refund(OrderDTO orderDTO);
}
