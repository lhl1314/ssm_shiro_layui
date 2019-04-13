package com.teeth.task;

import com.teeth.dao.AdminUserDao;
import com.teeth.dao.UserDao;
import com.teeth.pojo.AdminUser;
import com.teeth.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/8 0008
 * Time:10:36
 */

public class MyTask {
    @Autowired
    UserDao userDao;
    private static int i;
    static {
        i=0;
    }
//    @Scheduled(cron = "0/5 * * * * ?")//每五秒执行一次
//    public void test(){
//        i+=5;
//        System.out.println("第"+i+"秒"+"i="+i);
//    }
}
