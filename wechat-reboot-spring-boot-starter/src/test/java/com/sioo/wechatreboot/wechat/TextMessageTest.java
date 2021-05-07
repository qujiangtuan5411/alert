package com.sioo.wechatreboot.wechat;

import com.sioo.wechatreboot.wechat.message.TextMessage;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:
* @Param:
* @return:
* @Author: jt.Qu
*/
public class TextMessageTest {


    @Test
    public void testSendTextMessageWithAtAndAtAll() throws Exception {
        TextMessage message = new TextMessage("sioovm-manager经检测可能有问题,请相关同事注意!");
        List<String> mentionedMobileList=new ArrayList<String>();
        mentionedMobileList.add("17612155892");//@群内成员  手机号
        message.setMentionedMobileList(mentionedMobileList);
        message.setIsAtAll(true);//@所有人
        SendResult result = WxChatbotClient.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }
}