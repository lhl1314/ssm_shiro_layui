package com.zjitc.layui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LayuiApplication {
    /**启动类main类默认扫描该类目录及以下spring对象，因此在扫描范围外需要加@ComponentScan("xxx")注解；springboot会默认将Map、List、POJO对象转化为json对象。
     *
     * //springBoot的启动类必须要和control类的文件夹在同一个文件夹内才可以访问
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(LayuiApplication.class, args);
    }


}
