package com.sioo.wechatreboot.configuration;

import com.sioo.wechatreboot.invoke.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @Description: 自动装配配置
* @Param:
* @return:
* @Author: jt.Qu
*/
@Configuration
@ConditionalOnClass({InvokeWechatReboot.class,JvmWechatReboot.class})
//@Conditional(WechatRebootCondition.class)
@EnableConfigurationProperties(WechatRebootProperties.class)
public class RebootAutoConfiguration {
 
    /**
     * 注入属性类
     */
    @Autowired
    private WechatRebootProperties wechatRebootProperties;
 
    /**
    * @Description: 在当前上下文中没有 InvokeWechatReboot 类时创建类
    * @Param:
    * @return:
    * @Author: jt.Qu
    */
    @Bean
    @ConditionalOnMissingBean(InvokeWechatReboot.class)
    public InvokeWechatReboot invokeWechatReboot() {
        InvokeWechatReboot invokeWechatReboot = new InvokeWechatReboot();
        invokeWechatReboot.setCHATBOT_WEBHOOK(wechatRebootProperties.getChatbot_webhook());
        invokeWechatReboot.setCHATBOT_WEBHOOK2(wechatRebootProperties.getChatbot_webhook2());
        invokeWechatReboot.setCHATBOT_WEBHOOK3(wechatRebootProperties.getChatbot_webhook3());
        return invokeWechatReboot;
    }

    /**
     * @Description: 在当前上下文中没有 JvmWechatReboot 类时创建类
     * @Param:
     * @return:
     * @Author: jt.Qu
     */
    @Bean
    @ConditionalOnMissingBean(JvmWechatReboot.class)
    public JvmWechatReboot jvmWechatReboot() {
        JvmWechatReboot jvmWechatReboot = new JvmWechatReboot();
        jvmWechatReboot.setCHATBOT_WEBHOOK(wechatRebootProperties.getChatbot_webhook());
        return jvmWechatReboot;
    }

    /**
     * @Description: 在当前上下文中没有 VideoTemplateWechatReboot 类时创建类
     * @Param:
     * @return:
     * @Author: jt.Qu
     */
    @Bean
    @ConditionalOnMissingBean(VideoTemplateWechatReboot.class)
    public VideoTemplateWechatReboot videoTemplateWechatReboot() {
        VideoTemplateWechatReboot videoTemplateWechatReboot = new VideoTemplateWechatReboot();
        videoTemplateWechatReboot.setCHATBOT_WEBHOOK(wechatRebootProperties.getChatbot_webhook());
        videoTemplateWechatReboot.setCHATBOT_WEBHOOK2(wechatRebootProperties.getChatbot_webhook2());
        videoTemplateWechatReboot.setCHATBOT_WEBHOOK3(wechatRebootProperties.getChatbot_webhook3());
        return videoTemplateWechatReboot;
    }
    /**
     * @Description: 数据转移项目生成bean
     * @Param: 
     * @return: 
     * @Author: jt.Qu
     */
    @Bean
    @ConditionalOnMissingBean(HysmsTransferWechatReboot.class)
    public HysmsTransferWechatReboot HysmsTransferWechatReboot() {
        HysmsTransferWechatReboot hysmsTransferWechatReboot = new HysmsTransferWechatReboot();
        hysmsTransferWechatReboot.setCHATBOT_WEBHOOK(wechatRebootProperties.getChatbot_webhook());
        hysmsTransferWechatReboot.setCHATBOT_WEBHOOK2(wechatRebootProperties.getChatbot_webhook2());
        hysmsTransferWechatReboot.setCHATBOT_WEBHOOK3(wechatRebootProperties.getChatbot_webhook3());
        return hysmsTransferWechatReboot;
    }

    /**
     * @Description: 在当前上下文中没有 transfernetWechatReboot 类时创建类
     * @Param:
     * @return:
     * @Author: jt.Qu
     */
    @Bean
    @ConditionalOnMissingBean(TransfernetWechatReboot.class)
    public TransfernetWechatReboot transfernetWechatReboot() {
        TransfernetWechatReboot transfernetWechatReboot = new TransfernetWechatReboot();
        transfernetWechatReboot.setCHATBOT_WEBHOOK(wechatRebootProperties.getChatbot_webhook());
        transfernetWechatReboot.setCHATBOT_WEBHOOK2(wechatRebootProperties.getChatbot_webhook2());
        transfernetWechatReboot.setCHATBOT_WEBHOOK3(wechatRebootProperties.getChatbot_webhook3());
        return transfernetWechatReboot;
    }
}