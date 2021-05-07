package com.sioo.wechatreboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
* @Description: 校验配置信息是否正确
* @Param:
* @return:
* @Author: jt.Qu
*/
public class WechatRebootCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String webhook = context.getEnvironment().getProperty("com.sioo.wechat.reboot.chatbot-webhook");
        String webhook2 = context.getEnvironment().getProperty("com.sioo.wechat.reboot.chatbot-webhook2");
        String webhook3 = context.getEnvironment().getProperty("com.sioo.wechat.reboot.chatbot-webhook3");

        /** 校验是否将配置信息填写完整*/
        if (StringUtils.isEmpty(webhook)) {
            throw new RuntimeException("缺失chatbot-webhook信息");
        } else if (StringUtils.isEmpty(webhook2)) {
            throw new RuntimeException("缺失chatbot-webhook2信息");
        } else if (StringUtils.isEmpty(webhook3)) {
            throw new RuntimeException("缺失chatbot-webhook3信息");
        } else {
            return true;
        }
    }
}