package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品信息DAO层
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>
{
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
