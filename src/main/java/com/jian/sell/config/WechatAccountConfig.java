package com.jian.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    //商户号
    private String mchId;

    //商户秘钥
    private String mchKey;

    //商户证书路径
    private String keyPath;

    //微信支付异步通知地址
    private String notifyUrl;

}
