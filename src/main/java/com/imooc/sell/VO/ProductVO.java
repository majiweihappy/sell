package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * Created by majiwei
 * 2018/10/20 0020 19:17
 */
@Data
public class ProductVO implements Serializable
{
    private static final long serialVersionUID = 3355332619015620687L;

    /** 类目名称 */
    //自己取名字要易读，返回前端序列化为json对象时会自动转
    @JsonProperty("name")
    private String categoryName;

    /** 类目编号 */
    @JsonProperty("type")
    private Integer categoryType;

    /**商品列表 */
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
