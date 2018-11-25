package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.utils.EnumUtil;
import com.imooc.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单DTO
 * Created by majiwei
 * 2018/10/21 0021 11:45
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) //废弃的方法
//@JsonInclude(JsonInclude.Include.NON_NULL) //如果有字段是null,则json转换时不返回
public class OrderDTO
{
    /** 订单ID. */
    private String orderId;

    /** 买家姓名. */
    private String buyerName;

    /** 买家电话. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddres;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态. */
    private Integer orderStatus;

    /** 支付状态. */
    private Integer payStatus;

    /** 创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /** 订单详情列表 */
    //这里赋一个初始值new ArrayList<>()，当没有数据时也不会返回null,而是[]，这里该字段非必须，不用设置初始值
    List<OrderDetail> orderDetailList;

    /**
     * 根据code获取订单状态枚举
     * @return
     */
    @JsonIgnore //不需要转json
    public OrderStatusEnum getOrderStatusEnum()
    {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    /**
     * 根据code获取支付状态枚举
     * @return
     */
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum()
    {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
