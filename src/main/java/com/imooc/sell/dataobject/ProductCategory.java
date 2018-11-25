package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * Created by majiwei
 * 2018/10/20 0020 16:26
 * product_category
 */
@Entity
@Data
@DynamicUpdate //动态更新
public class ProductCategory
{
    /** 类目id. */
    @Id //主键
    @GeneratedValue //自增
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType)
    {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory()
    {
    }
}
