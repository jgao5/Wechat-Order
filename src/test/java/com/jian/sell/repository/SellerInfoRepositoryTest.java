package com.jian.sell.repository;

import com.jian.sell.dataobject.SellerInfo;
import com.jian.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setOpenId("1234567");
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");

        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenId() {
        SellerInfo sellerInfo = repository.findByOpenId("1234567");
        Assert.assertEquals("1234567", sellerInfo.getOpenId());

    }
}