package com.jian.sell.converter;

import com.jian.sell.dataobject.OrderMaster;
import com.jian.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMaster2orderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMastersList){

        return orderMastersList.stream().map(e ->
                convert(e))
                .collect(Collectors.toList());
    }
}
