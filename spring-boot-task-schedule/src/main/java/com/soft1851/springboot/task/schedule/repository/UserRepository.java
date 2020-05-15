package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName UserRepository
 * @Description TODO
 * @Date 2020/5/15  19:33
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     *
     * @return
     */
    @Query(value = "select * from user where MONTH(birthday) = MONTH(NOW()) and DAY(birthday) = DAY(NOW())",nativeQuery = true)
    List<User> findUserByBirthday();


}
