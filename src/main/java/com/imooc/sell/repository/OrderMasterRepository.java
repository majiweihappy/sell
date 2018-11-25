package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单主表DAO层
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String>
{
    //按照买家的openid分页查询该用户的订单详情
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
