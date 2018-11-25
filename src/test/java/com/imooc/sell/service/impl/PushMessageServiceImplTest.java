package com.imooc.sell.service.impl;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.service.IOrderService;
import com.imooc.sell.service.IPushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest
{

    @Autowired
    private IPushMessageService pushMessageService;

    @Autowired
    private IOrderService orderService;

    @Test
    public void orderStatus()
    {
        OrderDTO orderDTO = orderService.findOne("1540121520322376260");

        pushMessageService.orderStatus(orderDTO);
    }
}