package com.sioo.wechatreboot.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
* @Description: 配置类
* @Param:
* @return:
* @Author: jt.Qu
*/
@Setter
@Getter
@ConfigurationProperties(prefix = "com.sioo.wechat.reboot")
public class WechatRebootProperties {
 
    public static final String DEFAULT_WEBHOOK = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=6b7f3950-f6ae-4d35-bb53-818834a326bf";

    /**
     * 第一个hook地址
     */
    private String chatbot_webhook = DEFAULT_WEBHOOK;

    /**
     * 第二个hook地址
     */
    private String chatbot_webhook2 = DEFAULT_WEBHOOK;

    /**
     * 第三个hook地址
     */
    private String chatbot_webhook3 = DEFAULT_WEBHOOK;

}