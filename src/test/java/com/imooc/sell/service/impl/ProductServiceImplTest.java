package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest
{
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne()
    {
        ProductInfo productInfo = this.productService.findOne("123456");
        assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findUpAll()
    {
        List<ProductInfo> productInfoList = productService.findUpAll();
        assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll()
    {
        // 查询第0页，每页显示2条
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
//        System.out.println(productInfoPage.getTotalElements());
        assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    public void save()
    {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productService.save(productInfo);
        assertNotNull(result);
    }

    @Test
    public void onSale()
    {
        ProductInfo productInfo = productService.onSale("123456");
        assertEquals(ProductStatusEnum.UP.getCode(), productInfo.getProductStatus());
    }

    @Test
    public void offSale()
    {
        ProductInfo productInfo = productService.offSale("123456");
        assertEquals(ProductStatusEnum.DOWN.getCode(), productInfo.getProductStatus());
    }
}