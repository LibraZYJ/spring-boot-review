package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.cascade.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Resource
    private UserRepository userRepository;

    @Test
    void findByUserNameEqualsAndPasswordEquals() {
        User user = userRepository.findByUserNameEqualsAndPasswordEquals("Libra","123456");
        System.out.println(user);
        assertNotNull(userRepository.findByUserNameEqualsAndPasswordEquals("Libra","123456"));
    }

    @Test
    void findUsersByNickNameLike() {
        //昵称中含有“nick”的人数
//        assertEquals(18, userRepository.findUsersByNickNameLike("%nick%").size());
        List<User> users = userRepository.findUsersByNickNameLike("%nick%");
        System.out.println(users);
    }

    @Test
    void findUsersByAgeGreaterThan() {
        //查询年龄大于20的所有用户
        log.info(String.valueOf(userRepository.findUsersByAgeGreaterThan(20).size()));
    }

    @Test
    void findById() {
        //自定义的JPQL查询，根据id查询
        assertEquals("aaa", userRepository.findById(1L).getUserName());
    }

    @Test
    void updateNickName() {
        //使用save活saveAndFlush方法更新数据，必须要提供所有字段值，否则该字段为空
        User user = User.builder()
                .id(1L)
                .userName("修改名称")
                .email("123456789@qq.com")
                .password("修改密码")
                .nickName("修改昵称")
                .age(12)
                .regTime(LocalDateTime.now()).build();
        userRepository.saveAndFlush(user);
        //可以自定义SQL实现更新
        int n = userRepository.updateNickName("新的昵称", 3L);
        assertEquals(1, n);
    }

    @Test
    void insertUser() {
        //自定义插入
        int n = userRepository.insertUser("zyj", "zyj666", "1836686674@qq.com");
        assertEquals(1, n);
    }

    @Test
    void findAllByAgeBefore() {
        User user =userRepository.findAllByAgeBefore(20);
        System.out.println(user);
    }


    @Test
    void testSave() {
        User user = User.builder()
                .userName("zyj")
                .email("1836686674@qq.com")
                .password("123123")
                .nickName("Libra")
                .age(11)
                .regTime(LocalDateTime.now()).build();
        userRepository.save(user);

//        批量加入
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            User testUser = User.builder()
                    .userName("zyj" + i)
                    .email("zyj" + i + "@qq.com")
                    .password("123456")
                    .nickName("nickName" + i)
                    .age(new Random().nextInt(50))
                    .regTime(LocalDateTime.now()).build();
            users.add(testUser);
        }
        userRepository.saveAll(users);
        assertEquals(21, userRepository.findAll().size());
    }


    @Test
    void testDelete() {
        //自带删除方法
        userRepository.deleteById(3L);
    }

    @Test
    void testSelect() {
        // 查询所有
        userRepository.findAll().forEach(user -> log.info(user.toString()));
        // 分页查询全部，返回封装了的分页信息， jpa页码从0开始
        Page<User> pageInfo = userRepository.findAll(
                PageRequest.of(1, 3, Sort.Direction.ASC, "id"));
        log.info("总记录数： {}", pageInfo.getTotalElements());
        log.info("当前页记录数： {}", pageInfo.getNumberOfElements());
        log.info("每页记录数： {}", pageInfo.getSize());
        log.info("获取总页数： {}", pageInfo.getTotalPages());
        log.info("查询结果： {}", pageInfo.getContent());
        log.info("当前页（从0开始计）： {}", pageInfo.getNumber());
        log.info("是否为首页： {}", pageInfo.isFirst());
        log.info("是否为尾页： {}", pageInfo.isLast());
        // 条件查询
        User user = User.builder().userName("user").build();
        List<User> users = userRepository.findAll(Example.of(user));
        log.info("满足条件的记录有：");
        users.forEach(user1 -> log.info(user1.toString()));
        // 单个查询
        User user1 = User.builder().id(2L).build();
        Optional<User> optionalUser = userRepository.findOne(Example.of(user1));
        log.info("单个查询结果： {}", optionalUser.orElse(null));
    }

    @Test
    void findByNickName() {
//        Page<User> pageInfo = userRepository.findAll(
//                PageRequest.of(1, 3, Sort.Direction.ASC, "id"));
//        userRepository.findByNickName("nickName3",pageInfo);
    }

    @Test
    void modifyById() {
    }

    @Test
    public void testPageQuery()  {
        //逆序排序User，获取分页，一页五个数据，第0页
        int page=0,size=5;
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        Page<User> userList = userRepository.findALL(pageable);
        System.out.println(userList.getContent());
        System.out.println(userRepository.findByNickName("nickName19", pageable));
    }
}