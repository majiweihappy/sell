package com.imooc.sell.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * Created by majiwei
 * 2018/10/20 0020 19:09
 */
@Data
public class ResultVO<T> implements Serializable
{
    private static final long serialVersionUID = 8848731630266574133L;

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    //该字段必须，如果没有设置不要返回null,则需要设置一个初始值""(看需求字段是否必须)
    private String msg;

    /** 具体内容 */
    private T data;
}
