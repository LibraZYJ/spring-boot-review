package com.soft1851.springboot.task.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @author Yujie_Zhao
 * @ClassName AsyncTaskService
 * @Description TODO
 * @Date 2020/5/16  16:12
 * @Version 1.0
 **/
@Service
@Slf4j
public class AsyncTaskService {
    @Resource
    private MailService mailService;

    @Async
    public void asyncTask(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理数据中");

    }

    @Async
    public void mailTask() throws MessagingException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理数据中");
        String to = "1836686674@qq.com";
        String subject = "来自赵玉杰的问候";
        String content = "<h1>富强、民主、文明、和谐<h1><hr/><自由、平等、公正、法治><hr/><爱国、敬业、诚信、友善>";
        mailService.sendHtmlMail(to,subject,content);
    }
}
