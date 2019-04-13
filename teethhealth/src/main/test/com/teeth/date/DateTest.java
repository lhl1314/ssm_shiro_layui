package com.teeth.date;

import com.teeth.utils.Utils;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/8 0008
 * Time:15:42
 */
public class DateTest {
    /**
     * java日期转字符串
     */
    @Test
    public void t1() throws InterruptedException {
        Date date = new Date();
        System.out.println(date);
        //日期转字符
        String s1 = Utils.DateToString(date);
        System.out.println("日期转字符\t"+s1);
        //字符转日期
        Date date1 = Utils.StringToDate(s1);
        System.out.println("字符转日期\t"+date1);
        //date 转 TimeStamp
        Timestamp timestamp=new Timestamp(date.getTime());
        System.out.println("date 转 TimeStamp\t"+timestamp);
        //timeStamp 转 date
        //父与子的关系
        Date dates = new Timestamp(System.currentTimeMillis());
        System.out.println("timeStamp 转换 date\t"+dates);
    }
}
