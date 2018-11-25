package com.imooc.sell.form;

import lombok.Data;

/**
 * Created by majiwei
 * 2018/11/17 20:02
 */
@Data
public class CategoryForm
{
    /** 类目ID */
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
