package com.sioo.wechatreboot.invoke;

import com.sioo.wechatreboot.wechat.SendResult;
import com.sioo.wechatreboot.wechat.WxChatbotClient;
import com.sioo.wechatreboot.wechat.message.MarkdownMessage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

/****
 * @description: 视频短信模版新增推送
 * @version:1.0.0
 * @author jt.Qu
 * @data Created in 2020/5/20 10:40
 *
 */
@Setter
@Getter
public class VideoTemplateWechatReboot {

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

    public SendResult sendTemplateMarkdownMessage( String header, String userName, String templateTitle, String templateTag, String templateName,String time,String userType,String source) throws IOException {
        String WEBHOOK = CHATBOT_WEBHOOK;
        MarkdownMessage message = new MarkdownMessage();
        message.add(MarkdownMessage.getHeaderText(3, header));
        message.add(MarkdownMessage.getGreenText("账户名:【 "+userName+" 】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("账户类型:【 "+userType+" 】-【 "+source+" 】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("模版主题:【 "+ templateTitle +"】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("模版类型:【 "+ templateTag +"】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("模版名称:【 "+ templateName +" 】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("模版新增时间:【 "+ time +" 】"));
        message.add("\n\n");
        return WxChatbotClient.send(WEBHOOK, message);
    }
    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: jt.Qu
     */
    public SendResult pushushConfMarkdownMessage( String header, String userName, String state, String pushType,String pushUrl,String time,String desc) throws IOException {
        String WEBHOOK = CHATBOT_WEBHOOK;
        MarkdownMessage message = new MarkdownMessage();
        message.add(MarkdownMessage.getHeaderText(3, header));
        message.add(MarkdownMessage.getGreenText("账户名:【 "+userName+" 】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getWarningText("推送类型:【 "+ pushType +" 】"));
        message.add("\n\n");
//        message.add(MarkdownMessage.getGreenText("账户类型:【 "+userType+" 】-【 "+source+" 】"));
//        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("推送地址:【 "+ pushUrl +"】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getRedText("状态:【 "+ state +"】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getItalicText("描述:【 "+ desc +"】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("推送配置禁用时间:【 "+ time +" 】"));
        message.add("\n\n");
        return WxChatbotClient.send(WEBHOOK, message);
    }

    /**
     * 普通报警格式
     * @param header
     * @param content
     * @param currentDateTimeStr
     * @return
     * @throws IOException
     */
    public SendResult commonAlert( String header, String content,String currentDateTimeStr) throws IOException {
        String WEBHOOK = CHATBOT_WEBHOOK;
        MarkdownMessage message = new MarkdownMessage();
        message.add(MarkdownMessage.getHeaderText(3, header));
        message.add(MarkdownMessage.getGreenText(content));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("当前时间: "+ currentDateTimeStr));
        message.add("\n\n");
        return WxChatbotClient.send(WEBHOOK, message);
    }
}
