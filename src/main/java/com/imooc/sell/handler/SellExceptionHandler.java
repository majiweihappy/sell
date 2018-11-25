package com.imooc.sell.handler;

import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.config.ProjectUrlConfig;
import com.imooc.sell.exception.ResponseBankException;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.exception.SellerAuthorizeException;
import com.imooc.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by majiwei
 * 2018/11/20 20:01
 */
@ControllerAdvice
public class SellExceptionHandler
{

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException()
    {
        //跳转到微信扫码登录页面
      /*  return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));*/

      return new ModelAndView("redirect:"
      .concat("https://open.weixin.qq.com/connect/qrconnect?appid=wx6ad144e54af67d87&redirect_uri=http%3A%2F%2Fsell.springboot.cn%2Fsell%2Fqr%2FoTgZpwRZivqQJyhxvrxbi8ly9AEA&response_type=code&scope=snsapi_login&state=http%3a%2f%2fmajiwei.natapp1.cc%2fsell%2fseller%2flogin%3fopenid%3doTgZpwRZivqQJyhxvrxbi8ly9AEA"));
    }

    /**
     * 拦截SellException
     * @return
     */
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e)
    {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    /**
     * http头status返回指定的状态码，可以新建一个一场专门处理，然后通过@ResponseStatus处理该异常
     */
    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException()
    {

    }
}
