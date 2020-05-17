package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.Coder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yujie_Zhao
 * @ClassName CodeRepository
 * @Description TODO
 * @Date 2020/5/17  20:55
 * @Version 1.0
 **/
public interface CodeRepository extends JpaRepository<Coder,Integer> {
    /**
     *
     * @param id
     * @return
     */
    Coder findCoderById(int id);
}
