package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.repository.ProductCategoryRepository;
import com.imooc.sell.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目service层实现类
 * Created by majiwei
 * 2018/10/20 0020 17:47
 */
@Service
public class CategoryServiceImpl implements ICategoryService
{
    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId)
    {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll()
    {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList)
    {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory)
    {
        return repository.save(productCategory);
    }
}
