package com.soft1851.springboot.task.schedule.service;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @author Yujie_Zhao
 * @ClassName MailService
 * @Description TODO
 * @Date 2020/5/15  15:29
 * @Version 1.0
 **/
public interface MailService {
    /**
     * 发送简单的文本邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleTextMail(String to,String subject,String content);

    void sendHtmlMail(String to,String subject,String content) throws MessagingException;

    void sendAttachmentMail(String to,String subject,String content,String... fileArr) throws MessagingException;

    void sendImgMail(String to, String subject, String content, Map<String,String> imgMap) throws MessagingException;


}
