package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.Cron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yujie_Zhao
 * @ClassName CronRepository
 * @Description TODO
 * @Date 2020/5/15  20:52
 * @Version 1.0
 **/
public interface CronRepository extends JpaRepository<Cron ,Integer> {
    /**
     * 根据CronId查询
     * @return Cron
     */
    Cron findCronByCronIdEquals(Integer cronId);

    /**
     * 更具Id修改cron
     * @param cron
     * @param id
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update cron set cron = ?1 where cron_id = ?2",nativeQuery = true)
    void updateCron(String cron,int id);
}
