package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.service.ISellerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest
{
    private static final String OPENID = "abc";

    @Autowired
    private ISellerService sellerService;

    @Test
    public void findSellerInfoByOpenid()
    {
        SellerInfo result = sellerService.findSellerInfoByOpenid(OPENID);
        assertEquals(OPENID, result.getOpenid());
    }
}