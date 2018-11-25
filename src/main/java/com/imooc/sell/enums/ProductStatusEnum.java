package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 商品状态枚举
 */
@Getter
public enum ProductStatusEnum implements CodeEnum
{
    UP(0, "上架"),
    DOWN(1, "下架")
    ;

    private Integer code;

    private String msg;

    ProductStatusEnum(Integer cocde, String msg)
    {
        this.code = cocde;
        this.msg = msg;
    }
}
