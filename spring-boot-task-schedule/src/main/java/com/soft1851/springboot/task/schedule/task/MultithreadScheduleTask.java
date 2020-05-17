package com.soft1851.springboot.task.schedule.task;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.soft1851.springboot.task.schedule.model.Coder;
import com.soft1851.springboot.task.schedule.repository.CodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName MultithreadScheduleTask
 * @Description TODO
 * @Date 2020/5/17  20:53
 * @Version 1.0
 **/
//@Component
//@EnableScheduling
//@EnableAsync
@Slf4j
public class MultithreadScheduleTask {
    @Resource
    private CodeRepository codeRepository;

    @Async
    @Scheduled(fixedRate = 1000)
    public void first() {
        Console.log("第一个异步任务,{},当线程：{}", DateUtil.now(), Thread.currentThread().getName());
    }

    @Async
    @Scheduled(fixedRate = 4000)
    public void second() {
        Console.log("Task two,{},current thread:{}", RandomUtil.randomInt(10, 100), Thread.currentThread().getName());
    }

    @Async
    @Scheduled(fixedDelay = 3000)
    public void getCoder() {
        int index = RandomUtil.randomInt(1, 4);
        Coder coder = codeRepository.findCoderById(index);
        download(coder);
    }

    @Async
    public void download(Coder coder) {
        String template = "D:/code/{}.jpg";
        String path = StrUtil.format(template, IdUtil.simpleUUID());
        HttpUtil.downloadFile(coder.getAvatar(), FileUtil.file(path));
        getQrCode(coder.getUrl(), path);
    }

    @Async
    public void getQrCode(String content, String logo) {
        String template = "D:/code/{}.jpg";
        String file = StrUtil.format(template, IdUtil.simpleUUID());
        QrCodeUtil.generate(content, QrConfig.create().setImg(logo), FileUtil.file(file));
    }

    @Scheduled(fixedRate = 30000)
    public void mailMethod() {
        //发送普通文本邮件
        MailUtil.send(mailMessage(), CollUtil.newArrayList("1836686674@qq.com"), "测试", "邮件来自Hutool测试", false);
        log.info("发送邮件成功");
        //发送HTML格式的邮件,并带邮件
//        MailUtil.send(account,CollUtil.newArrayList("1836686674@qq.com"), "测试", "<h1>邮件来自Hutool测试</h1>", true, FileUtil.file("F:/我的/csv/coderTest.csv"));

        //群发邮件
//        ArrayList<String> tos = CollUtil.newArrayList(
//                "1427177855@qq.com",
//                "1497636356@qq.com",
//                "1836686674@qq.com",
//                "2731964526@qq.com");
//        MailUtil.send(tos, "测试", "邮件来自Hutool群发测试", false);
    }

    @Async
    public MailAccount mailMessage() {
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("1836686674@qq.com");
        account.setUser("1836686674");
        //密码(注意不是登录密码，是网易客户端登录授权码)
        account.setPass("xkoimmrdppvocfci");
        return account;
    }

//    @Scheduled(cron="0 39 20 * * *")
    public void createExcel() {
        List<Coder> coderList = codeRepository.findAll();
        coderList.forEach(System.out::println);
        Coder coder = codeRepository.findCoderById(1);
        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("D:/code/writeTest.xlsx");
        //通过构造方法创建writer
        //ExcelWriter writer = new ExcelWriter("d:/writeTest.xls");

        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();
        //合并单元格后的标题行，使用默认标题样式
        writer.merge(3, "测试标题");
        //一次性写出内容，强制输出标题
        writer.write(coderList, true);
        //关闭writer，释放内存
        writer.close();
    }

}
