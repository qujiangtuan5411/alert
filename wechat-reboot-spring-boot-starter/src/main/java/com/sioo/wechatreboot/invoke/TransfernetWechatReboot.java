package com.sioo.wechatreboot.invoke;

import com.sioo.wechatreboot.wechat.SendResult;
import com.sioo.wechatreboot.wechat.WxChatbotClient;
import com.sioo.wechatreboot.wechat.message.TextMessage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/****
 * @description: 视频短信模版新增推送
 * @version:1.0.0
 * @author jt.Qu
 * @data Created in 2020/5/20 10:40
 *
 */
@Setter
@Getter
public class TransfernetWechatReboot {

    /**
     * 第一个回调地址
     */
    private String CHATBOT_WEBHOOK;

    /**
     * 第二个回调地址
     */
    private String CHATBOT_WEBHOOK2;

    /**
     * 第三个回调地址
     */
    private String CHATBOT_WEBHOOK3;

    public SendResult sendTransfernetkdownMessage(String instance,Boolean notifycation) throws IOException {
        String WEBHOOK = CHATBOT_WEBHOOK;
        TextMessage message = new TextMessage(instance);
        List<String> mentionedMobileList=new ArrayList<String>();
        //@群内成员  手机号
        message.setMentionedMobileList(mentionedMobileList);
        //@所有人
        message.setIsAtAll(notifycation);
        return WxChatbotClient.send(WEBHOOK, message);
    }
}
