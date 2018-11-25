package com.imooc.sell.converter;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by majiwei
 * 2018/10/21 0021 16:55
 */
public class OrderMaster2OrderDTOConverter
{
    public static OrderDTO convert(OrderMaster orderMaster)
    {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList)
    {
        return orderMasterList.stream().map(e ->
                convert(e)
            ).collect(Collectors.toList());
    }
}
