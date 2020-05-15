package com.soft1851.springboot.task.schedule.service.impl;


import com.soft1851.springboot.task.schedule.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * @author Yujie_Zhao
 * @ClassName MailServiceImpl
 * @Description TODO
 * @Date 2020/5/15  15:31
 * @Version 1.0
 **/
@Service
@Slf4j
public class MailServiceImpl implements MailService {
    /**
     * 读入配置文件中的邮件发送者设置
     */
    @Value("${spring.mail.username}")
    private String from;
    @Resource
    private JavaMailSender mailSender;


    @Override
    public void sendSimpleTextMail(String to, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);
        mailSender.send(message);
        log.info("文件邮件发送成功!" ,to);
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        //true为HTML邮件
        mimeMessageHelper.setText(content,true);
        mailSender.send(message);
        log.info("文件邮件发送成功！" ,to);
    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String... fileArr) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        //true为HTML邮件
        mimeMessageHelper.setText(content,true);
//        添加附件
        for (String filePath : fileArr){
            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            if (fileSystemResource.exists()){
                String fileName = fileSystemResource.getFilename();
                assert fileName != null;
                mimeMessageHelper.addAttachment(fileName,fileSystemResource);
            }
        }
        mailSender.send(mimeMessage);
        log.info("文件邮件发送成功！" ,to);
    }

    @Override
    public void sendImgMail(String to, String subject, String content, Map<String, String> imgMap) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        //true为HTML邮件
        mimeMessageHelper.setText(content,true);
//        添加图片
        for(Map.Entry<String,String>entry:imgMap.entrySet()){
            FileSystemResource fileSystemResource = new FileSystemResource((new File(entry.getValue())));
            if (fileSystemResource.exists()){
                mimeMessageHelper.addInline(entry.getKey(),fileSystemResource);
            }
        }
        mailSender.send(mimeMessage);
        log.info("图片邮件发送成功！" ,to);
    }
}
