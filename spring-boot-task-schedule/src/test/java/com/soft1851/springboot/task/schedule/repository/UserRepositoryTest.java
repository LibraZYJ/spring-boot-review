package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    void testSave() {
        User user = User.builder()
                .username("孙鑫龙")
                .password("123")
                .birthday(LocalDateTime.now())
                .mail("sun2512881187@qq.com")
                .build();
        userRepository.save(user);
//        userRepository.save(user);

//        List<User> users = new ArrayList<>();
//        for (int i = 1; i <= 20; i++) {
//            User testUser = User.builder()
//                    .username("user" + i)
//                    .mail("user" + i + "@qq.com")
//                    .password("123456")
//                    .build();
//            users.add(testUser);
//        }
//        userRepository.saveAll(users);
//        userRepository.saveAll(users);
    }
    @Test
    void findUserByBirthday() {
        List<User> users = userRepository.findUserByBirthday();
        users.forEach(user -> System.out.println("今天生日："+user.getUsername()));

    }
}