package com.sioo.wechatreboot.invoke;

import com.sioo.wechatreboot.wechat.SendResult;
import com.sioo.wechatreboot.wechat.WxChatbotClient;
import com.sioo.wechatreboot.wechat.message.MarkdownMessage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

/**
 * @Description: 数据转移项目报警
 * @Param: 
 * @return: 
 * @Author: jt.Qu
 */
@Setter
@Getter
public class HysmsTransferWechatReboot {

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
     * @Description: 批次/明细 转后企业微信报警
     * @Param: "数据转移[批次]从MongoDB转到mysql提醒", count, (System.currentTimeMillis()-l), date, currentDateTimeStr
     * @return: 
     * @Author: jt.Qu
     */
    public SendResult msgTransferMarkdownMessage( String header, int count, Long millis, String date, String currentDateTimeStr) throws IOException {
        String WEBHOOK = CHATBOT_WEBHOOK;
        MarkdownMessage message = new MarkdownMessage();
        message.add(MarkdownMessage.getHeaderText(3, header));
        message.add(MarkdownMessage.getGreenText("数据日期:【 "+ date +"】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("数据量:【 "+count+" 】条"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("耗时:【 "+millis+" 】毫秒 =【 "+(millis/1000L/60L)+" 】分钟"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("当前时间:【 "+ currentDateTimeStr +" 】"));
        message.add("\n\n");
        return WxChatbotClient.send(WEBHOOK, message);
    }
    /**
     * @Description: 明细转数据完毕后生成文件报警
     * @Param: 
     * @return: 
     * @Author: jt.Qu
     */
    public SendResult msgTransferCreateFileMarkdownMessage( String header, int count, String date, Long millis, String currentDateTimeStr) throws IOException {
        String WEBHOOK = CHATBOT_WEBHOOK;
        MarkdownMessage message = new MarkdownMessage();
        message.add(MarkdownMessage.getHeaderText(3, header));
        message.add(MarkdownMessage.getGreenText("数据日期:【 "+ date +"】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("写入文件数据量:【 "+count+" 】条"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("耗时:【 "+millis+" 】毫秒 =【 "+(millis/1000L/60L)+" 】分钟"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("当前时间:【 "+ currentDateTimeStr +" 】"));
        message.add("\n\n");
        return WxChatbotClient.send(WEBHOOK, message);
    }
    /**
     * @Description: 生成分区报警
     * @Param:  "[-自动生成分区-]完毕提醒", table, partName,(System.currentTimeMillis() - l), currentDateTimeStr
     * @return: 
     * @Author: jt.Qu
     */
    public SendResult createPartitionMarkdownMessage( String header, String table, String partName, Long millis, String currentDateTimeStr) throws IOException {
        String WEBHOOK = CHATBOT_WEBHOOK;
        MarkdownMessage message = new MarkdownMessage();
        message.add(MarkdownMessage.getHeaderText(3, header));
        message.add(MarkdownMessage.getGreenText("表名:【 "+table+" 】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("生成分区名:【 "+partName+" 】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("耗时:【 "+millis+" 】毫秒 =【 "+(millis/1000L/60L)+" 】分钟"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("当前时间:【 "+ currentDateTimeStr +" 】"));
        message.add("\n\n");
        return WxChatbotClient.send(WEBHOOK, message);
    }

    /**
     * 删除历史审核队列7天前的数据，报警
     * @param header
     * @param startDate
     * @param currentDateTimeStr
     * @return
     * @throws IOException
     */
    public SendResult deleteRealeaseDataTaskMarkdownMessage( String header, String startDate, String currentDateTimeStr,long countBefore,long countAfter) throws IOException {
        String WEBHOOK = CHATBOT_WEBHOOK;
        MarkdownMessage message = new MarkdownMessage();
        message.add(MarkdownMessage.getHeaderText(3, header));
        message.add(MarkdownMessage.getGreenText("删除日期:【 "+startDate+" 】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("当前时间:【 "+ currentDateTimeStr +" 】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("删除数据:【 "+ countBefore +" 】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("当前剩余数据:【 "+ countAfter +" 】"));
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
        message.add(MarkdownMessage.getGreenText("内容:【 "+ content +"】"));
        message.add("\n\n");
        message.add(MarkdownMessage.getGreenText("当前时间:【 "+ currentDateTimeStr +" 】"));
        message.add("\n\n");
        return WxChatbotClient.send(WEBHOOK, message);
    }
}
