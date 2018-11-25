package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * Sell异常类
 * Created by majiwei
 * 2018/10/21 0021 11:59
 */
@Getter
public class SellException extends RuntimeException
{

    private Integer code;

    public SellException(ResultEnum resultEnum)
    {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message)
    {
        super(message);
        this.code = code;
    }
}
