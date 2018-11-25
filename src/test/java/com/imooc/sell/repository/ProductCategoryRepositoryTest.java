package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest
{

    @Autowired
    private ProductCategoryRepository repository;

    /**
     * 测试查询一个类目
     */
    @Test
    public void findOneTest()
    {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    /**
     * 测试添加一个类目
     */
    @Test
    @Transactional //测试时这个事务会完全回滚，避免测试数据保留到数据库
    public void saveTest()
    {
        ProductCategory productCategory = new ProductCategory("女生最爱", 3);
        ProductCategory result = repository.save(productCategory);
        assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest()
    {
        List<Integer> list = Arrays.asList(1,2,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);

        assertNotEquals(0, result.size());
    }

}