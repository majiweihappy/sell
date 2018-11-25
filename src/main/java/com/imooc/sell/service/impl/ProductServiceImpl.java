package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.repository.ProductInfoRepository;
import com.imooc.sell.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by majiwei
 * 2018/10/20 0020 18:36
 */
@Service
@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements IProductService
{
    @Autowired
    private ProductInfoRepository repository;


    @Override
    @Cacheable(cacheNames = "product", key = "123")
    public ProductInfo findOne(String productId)
    {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll()
    {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    @Override
    @CachePut(cacheNames = "product", key = "123")
    public ProductInfo save(ProductInfo productInfo)
    {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList)
    {
        // 这个地方不会存在线程安全问题？？？
        for(CartDTO cartDTO : cartDTOList)
        {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if(productInfo == null)
            {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

    /**
     * 会使用redis的锁机制来避免多线程环境下的超卖
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList)
    {
        for(CartDTO cartDTO : cartDTOList)
        {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if(productInfo == null)
            {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0)
            {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId)
    {
        ProductInfo productInfo = repository.findOne(productId);
        if (productInfo == null)
        {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
        }

        if(productInfo.getProductStatus() == ProductStatusEnum.UP.getCode())
        {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId)
    {
        ProductInfo productInfo = repository.findOne(productId);
        if (productInfo == null)
        {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
        }

        if(productInfo.getProductStatus() == ProductStatusEnum.DOWN.getCode())
        {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }
}
