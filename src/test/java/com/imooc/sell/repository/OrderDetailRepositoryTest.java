package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest
{

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save()
    {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("1111112");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("11155");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductQuantity(30);

        OrderDetail result = repository.save(orderDetail);
        assertNotNull(result);
    }

    @Test
    public void findByOrderId()
    {
        List<OrderDetail> orderDetailList = repository.findByOrderId("1111111");
        assertNotEquals(0, orderDetailList.size());
    }
}