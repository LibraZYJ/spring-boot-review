package com.soft1851.springboot.task.schedule.task;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;

/**
 * @author Yujie_Zhao
 * @ClassName Task3
 * @Description TODO
 * @Date 2020/5/15  16:17
 * @Version 1.0
 **/

//@Component
//@EnableScheduling
//@EnableAsync
//@Slf4j
public class Task3 {

    @Scheduled(fixedRate = 10000)
    public void mailMethod(){
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("1836686674@qq.com");
        account.setUser("1836686674");
        //密码(注意不是登录密码，是网易客户端登录授权码)
        account.setPass("xkoimmrdppvocfci");
        //发送普通文本邮件
        MailUtil.send(account, CollUtil.newArrayList("1836686674@qq.com"), "测试", "邮件来自Hutool测试", false);

        //发送HTML格式的邮件,并带邮件
//        MailUtil.send(account,CollUtil.newArrayList("1427177855@qq.com"), "测试", "<h1>邮件来自Hutool测试</h1>", true, FileUtil.file("F:/我的/csv/coderTest.csv"));

        //群发邮件
        ArrayList<String> tos = CollUtil.newArrayList(
                "1427177855@qq.com",
                "1497636356@qq.com",
                "1836686674@qq.com",
                "2731964526@qq.com");

        MailUtil.send(tos, "测试", "邮件来自Hutool群发测试", false);
//        MailUtil.send(account, CollUtil.newArrayList(
//                "1427177855@qq.com",
//                "1497636356@qq.com",
//                "1836686674@qq.com",
//                "2731964526@qq.com"),
//                "测试",
//                "<h1>邮件来自Hutool测试</h1>",
//                true,
//                FileUtil.file("F:/我的/csv/coderTest.csv"));
    }
}
