package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest
{
    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";
    private final String ORDER_ID = "1540110777635418356";

    @Test
    public void create()
    {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("廖师兄");
        orderDTO.setBuyerAddres("慕课网");
        orderDTO.setBuyerPhone("12345678912");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1234568");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);

        assertNotNull(result);
    }

    @Test
    public void findOne()
    {
        OrderDTO result = orderService.findOne(ORDER_ID);

        log.info("【查询单个订单】result={}", result);
        assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList()
    {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> result = orderService.findList(BUYER_OPENID, request);

        assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void cancel()
    {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish()
    {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid()
    {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void list()
    {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> result = orderService.findList(request);

//        assertNotEquals(0, result.getTotalElements());

        //让断言模式更规范，可以使用这种形式
        assertTrue("查询所有的订单列表", result.getTotalElements() > 0);
    }
}