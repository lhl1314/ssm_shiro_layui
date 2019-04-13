package com.zjitc.layui;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.zjitc.layui.dao.UserDao;
import com.zjitc.layui.pojo.User;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LayuiApplicationTests {

    @Autowired
    UserDao userDao;
    @Test
    public void testConnection(){
        List<User> all = userDao.getAll();
        System.out.println("------------------------");
        all.forEach(t-> System.out.println(t));
    }

    @Test
    public void addUser(){
        User user=new User();
        user.setUsername("小一");
        user.setBirthday(new Timestamp(System.currentTimeMillis()));
        user.setHobby("篮球，音乐，跑步");
        user.setHeaderImage("fsaf/sdfa/sdfasd/fas");
        user.setSex("男");
        userDao.add(user);
    }

    @Test
    public void delete(){
        userDao.delete(1);
    }

    @Test
    public void update(){
        User one = userDao.getOne(1);
        one.setPassword("2342342");
        userDao.update(one);
    }

    @Test
    public void getOne(){
        User one = userDao.getOne(1);
        System.out.println(one);
    }
    @Test
    public void  pageFind(){
        PageHelper.startPage(1,2);
        List<User> users = userDao.getAll();
        System.out.println("-------------");
        users.forEach(t-> System.out.println(t));
        PageInfo info=new PageInfo(users);
        System.out.println("info=="+info);
    }

//    @Test
//    public void te() throws JSONException, IOException, HTTPException {
//        int appid=	1400191979;
//        String  appkey="329d4839e452984b9c2d35587364c835";
//        int templateId = 300838;
//        String smsSign = "畅销图书商城个人公众号";
//        String[] phoneNumbers = {"15659500526"};
//        //创建验证码
//        String random=(int)((Math.random()*9+1)*100000)+"";
//        System.out.println(random);
//        try {
//            String[] params={random};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
//            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
//            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
//                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
//            System.out.println(result);
//        } catch (HTTPException e) {
//            System.out.println("// HTTP响应码错误");
//            e.printStackTrace();
//        } catch (JSONException e) {
//            System.out.println("// json解析错误");
//
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.out.println("      // 网络IO错误");
//            e.printStackTrace();
//        }
//
//    }


}
