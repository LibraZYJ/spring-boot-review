package com.soft1851.springboot.task.schedule;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Tao
 * @version 1.0
 * @ClassName DatabaseTest
 * @Description TODO
 * @date 2020-05-16 20:52
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
public class DatabaseTest {
    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void contextLoads() {
        String url = encryptor.encrypt("jdbc:mysql://127.0.0.1:3306/test2?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("root");
        System.out.println("database url:"+url);
        System.out.println("database name:"+name);
        System.out.println("database password:"+password);
        Assert.assertTrue(url.length()>0);
        Assert.assertTrue(name.length()>0);
        Assert.assertTrue(password.length()>0);
    }
}
