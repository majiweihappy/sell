package com.imooc.sell.dataobject.mapper;

import com.imooc.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest
{
    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryName","师兄最不爱");
        map.put("categoryType","101");
        int result = mapper.insertByMap(map);

        assertEquals(1,result);
    }

    @Test
    public void insertByObject()
    {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("师兄最不爱");
        productCategory.setCategoryType(102);
        int result = mapper.insertByObject(productCategory);
        assertEquals(1,result);
    }

    @Test
    public void findByCategoryType()
    {
        ProductCategory result = mapper.findByCategoryType(102);
        assertNotNull(result);

    }

    @Test
    public void findByCategoryName()
    {
        List<ProductCategory> result = mapper.findByCategoryName("师兄最不爱");
        assertNotEquals(0, result.size());

    }

    @Test
    public void updateByCategoryType()
    {
        int result = mapper.updateByCategoryType("师兄最不爱的分类", 102);
        assertEquals(1, result);
    }

    @Test
    public void updateByObject()
    {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("师兄最不爱");
        productCategory.setCategoryType(102);

        int result = mapper.updateByObject(productCategory);
        assertEquals(1, result);
    }

    @Test
    public void deleteByCategoryType()
    {
        int result = mapper.deleteByCategoryType(102);
        assertEquals(1, result);
    }

    @Test
    public void selectByCategoryType()
    {
        ProductCategory result = mapper.selectByCategoryType(101);
        assertNotNull(result);
    }
}