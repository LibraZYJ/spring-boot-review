package com.soft1851.springboot.task.schedule.test;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;

import javax.annotation.Resource;

/**
 * @author Yujie_Zhao
 * @ClassName JasyptTest
 * @Description TODO
 * @Date 2020/5/16  22:54
 * @Version 1.0
 **/
@Slf4j
public class JasyptTest {
    @Resource
    private StringEncryptor encryptor;


    public  void contextLoads() {
        String url = encryptor.encrypt("jdbc:mysql://127.0.0.1:3306/test2?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("root");
        System.out.println("database url:"+url);
        System.out.println("database name:"+name);
        System.out.println("database password:"+password);
        log.info(String.valueOf(url.length()>0));
        log.info(String.valueOf(name.length()>0));
        log.info(String.valueOf(password.length()>0));
    }

    public static void main(String[] args){
//        contextLoads();
    }
}
