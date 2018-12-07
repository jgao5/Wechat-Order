package com.jian.sell.service;


import com.jian.sell.dataobject.SellerInfo;

/**
 * 卖家端
 */
public interface SellerService {

    /**
     * 通过openId查询卖家信息
     * @param openId
     * @return
     */
    SellerInfo findSellerInfoByOpenId(String openId);

}
