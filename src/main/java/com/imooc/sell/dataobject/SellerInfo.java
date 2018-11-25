package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by majiwei
 * 2018/11/18 11:03
 */
@Data
@Entity
public class SellerInfo
{
    @Id
    private String sellerId;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 微信openid */
    private String openid;
}
