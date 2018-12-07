package com.jian.sell.service.impl;

import com.jian.sell.dataobject.SellerInfo;
import com.jian.sell.repository.SellerInfoRepository;
import com.jian.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openId) {
        return sellerInfoRepository.findByOpenId(openId);
    }
}
