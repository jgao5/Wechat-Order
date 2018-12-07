package com.jian.sell.service.impl;

import com.jian.sell.dataobject.SellerInfo;
import com.jian.sell.service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private static final String OPENID = "1234567";

    @Autowired
    private SellerService sellerService;

    @Test
    public void findSellerInfoByOpenId() {
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenId(OPENID);
        Assert.assertEquals(OPENID, sellerInfo.getOpenId());
    }
}