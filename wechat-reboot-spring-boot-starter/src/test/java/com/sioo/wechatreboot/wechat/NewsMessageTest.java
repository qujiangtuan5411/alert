package com.sioo.wechatreboot.wechat;

import com.sioo.wechatreboot.wechat.message.NewsArticle;
import com.sioo.wechatreboot.wechat.message.NewsMessage;
import org.junit.Test;

/** 
* @Description:
* @Param:
* @return:
* @Author: jt.Qu
*/
public class NewsMessageTest {

    private WxChatbotClient client = new WxChatbotClient();

    @Test
    public void testSendNewsMessage() throws Exception {

    	NewsArticle article=new NewsArticle();
    	article.setTitle("视频短信监控报警服务已上线");
    	article.setDescription("视频短信服务报警监控项目上线,点击连接查看");
    	article.setUrl("http://47.100.105.125:18769/#/wallboard");
    	article.setPicurl("http://vsm.200696.com:19089/sioovm-up-2.0.0.png");
    	
    	NewsMessage message=new NewsMessage();
    	message.addNewsArticle(article);
    	SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK2, message);
        System.out.println(result);
    }

}