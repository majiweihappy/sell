package com.imooc.sell.repository;

import com.imooc.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by majiwei
 * 2018/11/18 11:05
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String>
{
    SellerInfo findByOpenid(String openid);
}
