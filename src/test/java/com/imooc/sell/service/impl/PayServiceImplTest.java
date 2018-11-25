package com.imooc.sell.service.impl;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.service.IOrderService;
import com.imooc.sell.service.IPayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest
{
    @Autowired
    private IPayService payService;

    @Autowired
    private IOrderService orderService;

    @Test
    public void create() throws Exception
    {
        OrderDTO orderDTO = orderService.findOne("1540121520322376260");
        payService.create(orderDTO);
    }

    @Test
    public void refund()
    {
        OrderDTO orderDTO = orderService.findOne("1540122222088582214");
        payService.refund(orderDTO);
    }
}