package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest
{

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "110110";

    @Test
    public void save()
    {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("11231231455");
        orderMaster.setBuyerAddres("慕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid()
    {
        PageRequest pageRequest = new PageRequest(1, 3);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, pageRequest);

//        System.out.println(result.getTotalElements());
        assertNotEquals(0, result.getTotalElements());
    }
}