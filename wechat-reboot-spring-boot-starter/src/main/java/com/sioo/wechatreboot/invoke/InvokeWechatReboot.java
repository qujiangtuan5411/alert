package com.sioo.wechatreboot.invoke;

import com.sioo.wechatreboot.wechat.SendResult;
import com.sioo.wechatreboot.wechat.WxChatbotClient;
import com.sioo.wechatreboot.wechat.message.MarkdownMessage;
import com.sioo.wechatreboot.wechat.message.NewsArticle;
import com.sioo.wechatreboot.wechat.message.NewsMessage;
import com.sioo.wechatreboot.wechat.message.TextMessage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/****
 * @description：发送微信机器人提醒
 * @version：1.0.0
 * @author jt.Qu
 * @data Created in 2019/10/24 2:51 PM
 *
 */
@Setter
@Getter
public class InvokeWechatReboot {

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

    /**
    * @Description: 发送一般消息
    * @Param:
    * @return:
    * @Author: jt.Qu
    */
    public SendResult sendRebot(String instance,Boolean notifycation) throws IOException {
            TextMessage message = new TextMessage(instance);
            List<String> mentionedMobileList=new ArrayList<String>();
            //@群内成员  手机号
            //mentionedMobileList.add("17612155892");
            message.setMentionedMobileList(mentionedMobileList);
            //@所有人
            message.setIsAtAll(notifycation);
            return WxChatbotClient.send(CHATBOT_WEBHOOK, message);
    }

    /**
    * @Description: 发送markdown消息
    * @Param:
    * @return:
    * @Author: jt.Qu
    */
    public SendResult sendDownMarkdownMessage(Boolean flage,String header,String instance,String status,String serviceUrl,String exception,String exceptionMessage) throws IOException {
        String WEBHOOK = "";
        MarkdownMessage message = new MarkdownMessage();
        message.add(MarkdownMessage.getHeaderText(3, header));
        if(instance.equals("sioovm-component")){
            instance+="（视频短信组件服务）";
            WEBHOOK = CHATBOT_WEBHOOK2;
        }else if(instance.equals("sioovm-manager")){
            instance+="（视频短信后台服务）";
            WEBHOOK = CHATBOT_WEBHOOK2;
        }else if(instance.equals("sioovm-client")){
            instance+="（视频短信客户端服务）";
            WEBHOOK = CHATBOT_WEBHOOK2;
        }else if(instance.equals("sioovm-echo-handler")){
            instance+="（视频短信回调推送服务）";
            WEBHOOK = CHATBOT_WEBHOOK2;
        }else if(instance.equals("sioohy-client")){
            instance+="（新客户端服务）";
            WEBHOOK = CHATBOT_WEBHOOK;
        }
        if(flage){
            message.add(MarkdownMessage.getGreenText("服务名称:【 "+instance+"】"));
            message.add("\n\n");
            message.add(MarkdownMessage.getGreenText("服务状态:【 "+status+"】"));
            message.add("\n\n");
            message.add(MarkdownMessage.getGreenText("服务地址:【 "+serviceUrl+"】"));
            if(null!=exception){
                message.add("\n\n");
                message.add(MarkdownMessage.getGreenText("服务异常:【 "+exception+"】"));
                message.add("\n\n");
                message.add(MarkdownMessage.getGreenText("异常原因:【 "+exceptionMessage+"】"));
            }
        }else {
            message.add(MarkdownMessage.getRedText("服务名称:【 "+instance+"】"));
            message.add("\n\n");
            message.add(MarkdownMessage.getRedText("服务状态:【 "+status+"】"));
            message.add("\n\n");
            message.add(MarkdownMessage.getRedText("服务地址:【 "+serviceUrl+"】"));
            if(null!=exception){
                message.add("\n\n");
                message.add(MarkdownMessage.getRedText("服务异常:【 "+exception+"】"));
                message.add("\n\n");
                message.add(MarkdownMessage.getRedText("异常原因:【 "+exceptionMessage+"】"));
            }
        }
        message.add("\n\n");
        return WxChatbotClient.send(WEBHOOK, message);
    }

    public SendResult sendLimitMarkdownMessage(Boolean limit,String header,String userName,String company,String state,String limitTime,String ip,String ipAddress) throws IOException {
        String WEBHOOK = CHATBOT_WEBHOOK;
        MarkdownMessage message = new MarkdownMessage();
        message.add(MarkdownMessage.getHeaderText(3, header));
            message.add(MarkdownMessage.getGreenText("账户名:【 "+ userName+ " 】"));
            message.add("\n\n");
            message.add(MarkdownMessage.getGreenText("公司名称:【 "+ company +" 】"));
            message.add("\n\n");
            message.add(MarkdownMessage.getGreenText("账户状态:【 "+ state +"】"));
            message.add("\n\n");
            if(limit){
                message.add(MarkdownMessage.getGreenText("新客户端限制登陆时间:【 "+ limitTime +"分钟 】"));
                message.add("\n\n");
            }else {
                message.add(MarkdownMessage.getWarningText("停用该账户:【 "+ userName +" 】"));
                message.add("\n\n");
            }
            message.add(MarkdownMessage.getGreenText("ip:【 "+ (null == ip ? "未知ip" : ip) +" 】"));
            message.add("\n\n");
            message.add(MarkdownMessage.getGreenText("ip地址:【 "+ (null == ipAddress ? "未知地址" : ipAddress) +" 】"));
            message.add("\n\n");
        return WxChatbotClient.send(WEBHOOK, message);
    }

    public SendResult sendNewsMessage() throws IOException {
        NewsArticle article=new NewsArticle();
        article.setTitle("spring boot starter");
        article.setDescription("测试spi-手写spring boot starter启动类");
        article.setUrl("http://47.100.105.125:18769/#/wallboard");
        article.setPicurl("http://vsm.200696.com:19089/springboot.png");
        NewsMessage message=new NewsMessage();
        message.addNewsArticle(article);
        return WxChatbotClient.send(CHATBOT_WEBHOOK3, message);
    }
}
