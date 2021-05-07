package com.sioo.wechatreboot.invoke;

import com.sioo.wechatreboot.wechat.SendResult;
import com.sioo.wechatreboot.wechat.WxChatbotClient;
import com.sioo.wechatreboot.wechat.message.MarkdownMessage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

/****
 * @description:JVM监控报警机器人
 * @version:1.0.0
 * @author jt.Qu
 * @data Created in 2019/11/12 3:58 下午
 *
 */
@Setter
@Getter
public class JvmWechatReboot {

    /**
     * 机器人回调地址
     */
    private String CHATBOT_WEBHOOK;

    /**
     * @Description:机器人发送JVM信息
     *
     * @param: [header, freeMemory, totalMemory, maxMemory, actualAvailableMemory, critical, memoryPercent, judgeValue, signatureName, packageName]
     * @return: com.sioo.wechatreboot.wechat.SendResult
     * @auther: jt.Qu
     */
    public SendResult sendJvmMarkdownMessage(String header, long freeMemory,
                                             long totalMemory, long maxMemory,
                                             long actualAvailableMemory, String critical,
                                             String memoryPercent, Boolean judgeValue,
                                             String signatureName,String declaringTypeName) throws IOException {
        MarkdownMessage message = new MarkdownMessage();
        message.add(MarkdownMessage.getHeaderText(3, header));
            //空闲内存
            message.add(MarkdownMessage.getGreenText("当前JVM空闲内存:【 " + freeMemory + "M" +"】"));
            message.add("\n\n");
            //总内存
            message.add(MarkdownMessage.getGreenText("当前JVM内存总量:【 " + totalMemory + "M" +"】"));
            message.add("\n\n");
            //最大内存
            message.add(MarkdownMessage.getGreenText("JVM试图使用的最大内存:【 " + maxMemory + "M" +"】"));
            message.add("\n\n");
            //实际可用内存
            message.add(MarkdownMessage.getGreenText("JVM实际可用内存:【 " + actualAvailableMemory + "M" +"】"));
            message.add("\n\n");
            //阀值
            message.add(MarkdownMessage.getGreenText("阈值:【 " + critical + "】"));
            message.add("\n\n");
            //可用内存占有率
            message.add(MarkdownMessage.getGreenText("JVM实际可用内存占有率:【 " + memoryPercent +"】"));
            message.add("\n\n");
            //是否低于阀值
            message.add(MarkdownMessage.getGreenText("是否低于阈值:【 " + judgeValue +"】"));
            message.add("\n\n");
            //准备执行的类+方法名
            message.add(MarkdownMessage.getGreenText("目标方法所属类的方法:【 " + declaringTypeName + "." + signatureName +"】"));
            message.add("\n\n");
        return WxChatbotClient.send(CHATBOT_WEBHOOK, message);
    }
}
