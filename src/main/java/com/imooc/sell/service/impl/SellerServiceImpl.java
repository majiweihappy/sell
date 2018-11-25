package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.repository.SellerInfoRepository;
import com.imooc.sell.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by majiwei
 * 2018/11/18 11:17
 */
@Service
public class SellerServiceImpl implements ISellerService
{
    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid)
    {
        return repository.findByOpenid(openid);
    }
}
