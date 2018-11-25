package com.imooc.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by majiwei
 * 2018/11/7 20:14
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController
{
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code)
    {
        //微信访问链接进入该方法：
//        https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx586bdc49715f1780&redirect_uri=http://majiwei.natapp1.cc/sell/weixin/auth&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect

        log.info("进入auth方法");
        log.info("code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx586bdc49715f1780&secret=38b0b20a699dbe53814cd18513927fe8&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
        //返回的response是json格式的，包含openid
    }

    //eg.
    //code=011uYrgd0zOA9t1Wawdd0OWogd0uYrg3
    //response={"access_token":"15_GcdB9xKO-RHyNGVuStO8BtdgQHG3tV2SQz-85AsNh7KM09
    // -zeuryiIt33lJAy_JBqBscrS2f6ho0gV3IBz8U0mbJm2hsuaBoGZqyi_xdlPI","expires_in":7200,
    // "refresh_token":"15_HmTpltkK2MUxijTYbci-Msz8b7QPLPlUbd
    // -4pwXNggyKPqjupdBcZQFQpPojJQDVdAQQI0bR0Pr0GJiGSDy7HMwsYz4bA5ciqvrF_kmgt8A",
    // "openid":"oRGce1LF9a3HPvVGeBVwNx1MGxek","scope":"snsapi_base"}
}
