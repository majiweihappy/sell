package com.imooc.sell.dataobject.dao;

import com.imooc.sell.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by majiwei
 * 2018/11/24 13:05
 */
public class ProductCategoryDao
{

    @Autowired
    private ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map)
    {
        return mapper.insertByMap(map);
    }
}
