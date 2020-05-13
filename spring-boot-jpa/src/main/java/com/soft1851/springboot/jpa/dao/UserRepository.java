package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.cascade.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yujie_Zhao
 * @ClassName UserRepository
 * @Description TODO
 * @Date 2020/5/13  8:43
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);


    User findByUserNameOrEmail(String username,String email);
}