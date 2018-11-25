package com.imooc.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by majiwei
 * 2018/10/20 0020 18:12
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable
{
    private static final long serialVersionUID = 3217452228987179836L;

    @Id
    private String productId;
    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图,存一个链接地址 */
    private String productIcon;

    /** 状态, 0正常1下架 */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号 */
    private Integer categoryType;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    /**
     * 获取商品状态枚举
     * @return
     */
    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum()
    {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
