package com.soft1851.springboot.task.schedule.task;

import com.soft1851.springboot.task.schedule.service.MailService;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yujie_Zhao
 * @ClassName Task3
 * @Description TODO
 * @Date 2020/5/15  16:17
 * @Version 1.0
 **/
//@Component
public class Task3 {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
    @Resource
    private MailService mailService;


//    @Scheduled(cron="0 30 16 * * *")
    public void TimingBirthday() throws MessagingException {
        System.out.println(Thread.currentThread().getName()+" Time5:  现在时间"+dtf.format(LocalDateTime.now()));
        String to = "1836686674@qq.com";
        String subject = "生日快乐";
        String content = "<h1>宝贝生日快乐<h1><br/><img src=\"cid:img01\"/>";
        String imgPath = "D:\\我的\\picture\\bizhi\\birthday.jpg";
        Map<String,String> imgMap = new HashMap<>();
        //以键值对的形式存入
        imgMap.put("img01",imgPath);
        mailService.sendImgMail(to,subject,content,imgMap);
    }

}
