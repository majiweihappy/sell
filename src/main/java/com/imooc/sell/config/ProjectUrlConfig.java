package com.imooc.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by majiwei
 * 2018/11/18 11:48
 */
@Data
@ConfigurationProperties("projectUrl")
@Component
public class ProjectUrlConfig
{
    /**
     * 微信公众平台授权url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    public String wechatOpenAuthorize;

    /**
     * 点餐系统的url
     */
    public String sell;
}
