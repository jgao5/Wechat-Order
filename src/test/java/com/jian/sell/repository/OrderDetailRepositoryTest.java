package com.jian.sell.repository;

import com.jian.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456780");
        orderDetail.setOrderId("123457");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("123432");
        orderDetail.setProductName("Apple");
        orderDetail.setProductPrice(new BigDecimal(15.5));
        orderDetail.setProductQuantity(6);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);

    }


    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("1111123");

        Assert.assertNotEquals(0, orderDetailList.size());

    }

}