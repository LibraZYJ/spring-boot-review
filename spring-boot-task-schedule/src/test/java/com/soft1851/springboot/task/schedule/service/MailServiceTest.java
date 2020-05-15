package com.soft1851.springboot.task.schedule.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MailServiceTest {

    @Resource
    private MailService mailService;

    @Test
    void sendSimpleTextMail() {
        String to = "1836686674@qq.com";
        String subject = "Springboot 发送简单邮件";
        String content = "<h3>第一封Springboot 简单文本邮件<h3>";
        mailService.sendSimpleTextMail(to,subject,content);
    }

    @Test
    void sendHtmlMail() throws Exception{
//        for (int i = 0; i<=20;i++){
            String to = "sun2512881187@qq.com";
            String subject = "来自赵玉杰的问候";
            String content = "<h1>富强、民主、文明、和谐<h1><hr/><自由、平等、公正、法治><hr/><爱国、敬业、诚信、友善>";
            mailService.sendHtmlMail(to,subject,content);
//        }
    }

    @Test
    void sendAttachmentMail() throws Exception {
        String to = "sun2512881187@qq.com";
        String subject = "来自赵玉杰的问候";
        String content = "<h1>富强、民主、文明、和谐<h1><hr/><自由、平等、公正、法治><hr/><爱国、敬业、诚信、友善>";
        String filePath = "pom.xml";
        mailService.sendAttachmentMail(to,subject,content,filePath,filePath);
    }

    @Test
    void sendImgMail() throws Exception{
        String to = "1836686674@qq.com";
        String subject = "Springboot 发送 img 邮件";
        String content = "<h1>第一封Springboot 简单文本邮件<h1><br/><img src=\"cid:img01\"/>";
        String imgPath = "D:\\我的\\picture\\bizhi\\001.jpg";
        Map<String,String> imgMap = new HashMap<>();
        //以键值对的形式存入
        imgMap.put("img01",imgPath);
        mailService.sendImgMail(to,subject,content,imgMap);
    }
}