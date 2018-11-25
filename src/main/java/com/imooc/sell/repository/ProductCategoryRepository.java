package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品类目DAO层
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>
{
    /**
     * 根据类目编号List查询类目list
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
