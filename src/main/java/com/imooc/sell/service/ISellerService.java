package com.imooc.sell.service;

import com.imooc.sell.dataobject.SellerInfo;

/**
 * 卖家端服务接口
 */
public interface ISellerService
{
    /**
     * 通过openid获取卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
