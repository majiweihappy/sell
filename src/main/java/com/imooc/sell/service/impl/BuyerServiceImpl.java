package com.imooc.sell.service.impl;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.IBuyerService;
import com.imooc.sell.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 买家service实现类
 * Created by majiwei
 * 2018/10/23 0023 21:28
 */
@Service
@Slf4j
public class BuyerServiceImpl implements IBuyerService
{

    @Autowired
    private IOrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId)
    {
       return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancel(String openid, String orderId)
    {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);

        if(orderDTO == null)
        {
            log.error("【取消订单】查不到该订单, orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDTO);
    }

    /**
     * 校验订单是否是自己的订单
     * @param openid
     * @param orderId
     * @return
     */
    private OrderDTO checkOrderOwner(String openid, String orderId)
    {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null)
        {
            return null;
        }

        //判断是否是自己的订单
        if(!orderDTO.getBuyerOpenid().equals(openid))
        {
            log.error("【查询订单】订单的openid不一致，openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }
}
