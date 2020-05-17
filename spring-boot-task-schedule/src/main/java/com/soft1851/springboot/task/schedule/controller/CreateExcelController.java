package com.soft1851.springboot.task.schedule.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.soft1851.springboot.task.schedule.model.Coder;
import com.soft1851.springboot.task.schedule.repository.CodeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName CreateExcelController
 * @Description TODO
 * @Date 2020/5/18  0:26
 * @Version 1.0
 **/
@RestController
public class CreateExcelController {
    @Resource
    private CodeRepository codeRepository;

    /**
     * 导出
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/Excel/export.do")
    public String export(HttpServletRequest request, HttpServletResponse response) {
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
        writer.merge(field.length - 1, "测试标题");
        //一次性写出内容，强制输出标题
        writer.write(coderList, true);
        //关闭writer，释放内存
        writer.close();
        return "导出成功";
    }


}
