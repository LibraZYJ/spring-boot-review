package com.soft1851.springboot.task.schedule.task;

import com.soft1851.springboot.task.schedule.model.User;
import com.soft1851.springboot.task.schedule.repository.UserRepository;
import com.soft1851.springboot.task.schedule.service.MailService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SchedulerTask
 * @Description 定时发送邮件
 * @Author Yujie_zhao
 * @Date 2020/5/15
 **/
//@Component
public class SchedulerTask {
    String name="Yujie_Zhao";
    @Resource
    private MailService mailService;
    @Resource
    private TemplateEngine templateEngine;
    @Resource
    private UserRepository userRepository;
    /**
     * 每隔一分钟执行一次
     */
//    @Scheduled(cron="0 39 20 * * *")
//    @Scheduled(fixedRate = 60000)
    private void process(){

        List<User> userList = userRepository.findUserByBirthday();
        for (User user:userList){
            //创建邮件字段
            Context context = new Context();
            context.setVariable("siteTitle", name);
            context.setVariable("permalink", "");
            context.setVariable("title", "寄来的贺卡《生日快乐》");
            context.setVariable("author", "生日祝福语");
            context.setVariable("text", "你的开心我知道，我的烦恼你知道。你的愿望我知道，我的感动你知道。你的生日我知道，我的祝福你收到。让友谊为快乐开道，幸福平安将你围绕！");

            System.out.println("开始对"+user.getUsername()+"发送邮件");
            String to=user.getMail();
            String  subject=name+"寄来的贺卡《生日快乐》";
            // 将字段加载到页面模板中
            String emailContent = templateEngine.process("sendMail", context);
            // 添加附件
            String filePath = "D:\\我的\\picture\\bizhi\\birthday.jpg";
            Map<String, String> imgMap = new HashMap<>();
            //以键值对的形式存入
            imgMap.put("img01", filePath);
            try {
                mailService.sendImgMail(to,subject,emailContent, imgMap);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}