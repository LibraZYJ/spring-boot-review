package com.soft1851.springboot.task.schedule.repository;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.soft1851.springboot.task.schedule.model.Coder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;

@SpringBootTest
class CodeRepositoryTest {
    @Resource
    private CodeRepository codeRepository;

    @Test
    void findCoderById() {
    }

    @Test
    void getSQLAll() {
        Coder coder = codeRepository.findCoderById(1);
        // Java的反射
        Field[] field = coder.getClass().getDeclaredFields();
        System.out.println("实体的长度 :" + field.length);
        List<Coder> coderList = codeRepository.findAll();
        coderList.forEach(System.out::println);


        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("D:/code/writeTest.xlsx");
        //通过构造方法创建writer
        //ExcelWriter writer = new ExcelWriter("d:/writeTest.xls");

        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();

        //合并单元格后的标题行，使用默认标题样式
        writer.merge(field.length-1, "测试标题");
        //一次性写出内容，强制输出标题
        writer.write(coderList, true);
        //关闭writer，释放内存
        writer.close();
    }
    @Test
    void testNum() {
        Coder coder = codeRepository.findCoderById(1);
        // Java的反射
        Field[] field = coder.getClass().getDeclaredFields();
        System.out.println("实体的长度 :" + field.length);

    }

}