package com.jian.sell.service.impl;

import com.jian.sell.dataobject.OrderDetail;
import com.jian.sell.dto.OrderDTO;
import com.jian.sell.enums.OrderStatusEnum;
import com.jian.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String buyerOpenid = "110110";

    private final String orderId = "1528517689183588500";

    @Test
    /** 创建订单. */
    public void create() {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerAddress("农光南里");
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("13522708863");
        orderDTO.setBuyerOpenid(buyerOpenid);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(3);
        orderDetailList.add(o2);


        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    /** 查询单个订单. */
    public void findById() {

        OrderDTO result = orderService.findById(orderId);
        log.info("[查询单个订单] result={}", result);

        Assert.assertEquals(orderId, result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest request =  PageRequest.of(  0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(buyerOpenid, request);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findById(orderId);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findById(orderId);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findById(orderId);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void list() {
        PageRequest request =  PageRequest.of(  0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        //Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
        Assert.assertTrue("查询所有订单", orderDTOPage.getTotalElements() > 0);
    }
}