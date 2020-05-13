package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.cascade.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Resource
    private UserRepository userRepository;


    @Test
    public void testSave() {

        List<User> users = new ArrayList<>(Arrays.asList(
                User.builder().userName("zyj").passWord("123").nickName("zyj").email("1836686674@qq.com").build())
                );
        // 保存多个
        userRepository.saveAll(users);
    }
    @Test
    void findByUserName() {
        User user = userRepository.findByUserName("zyj");
        log.info(String.valueOf(user));
    }

    @Test
    void findByUserNameOrEmail() {
        User user = userRepository.findByUserNameOrEmail("zyj","1836686674@qq.com");
        log.info(String.valueOf(user));
    }

}