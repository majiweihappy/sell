package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * service层接口
 */
public interface ICategoryService
{
    /**
     * 查询单个类目
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有类目
     * @return
     */
    List<ProductCategory>  findAll();

    /**
     * 根据类目编号list查询类目list
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 新增/更新类目
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
