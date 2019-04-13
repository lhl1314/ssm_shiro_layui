package com.teeth.shiro;

import com.teeth.utils.UtilsShiro;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.security.Key;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/8 0008
 * Time:16:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class ShiroTest {
    /**
     * 加密测试
     */
    @Test
    public void test1() {
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); //设置key长度
//生成key
        Key key = aesCipherService.generateNewKey();
        String text = "hello";
        System.out.println("原文" + text);
//加密
        String encrptText =
                aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();

        System.out.println("加密" + encrptText);
        //解密
        String text2 =
                new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());
        System.out.println("解密" + text2);
        Assert.assertEquals(text, text2);
    }

    @Test
    public void jiami() {
//        String hello = UtilsShiro.jiaMi("1234");
//        System.out.println("加密"+hello+"长度"+hello.length());
//        String s = UtilsShiro.jieMi("718c3d39e0d1ccad92201fb81c2dbfd80155df08b99c1d4585052037d99e0c36");
//        System.out.println("解密"+s);

    }
    @Test
    public void dsfa(){

    }
    @Test
    public void dsa(){
        String str = "1,"+"1234";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        String str2 = Base64.decodeToString(base64Encoded);
        System.out.println("加密"+base64Encoded);
        System.out.println("解密"+str2);
    }
    @Test
    public void dsaf(){
        String str2 = Base64.decodeToString(Base64.decodeToString("77+9be+/vQ=="));
        System.out.println("解密"+str2);
    }

    @Test
    public void sdaf(){
        String str1 = "1,"+"1234";
        String base64Encoded1 = Base64.encodeToString(str1.getBytes());
        System.out.println(base64Encoded1);

        String str2 = "2,"+"1234";
        String base64Encoded2 = Base64.encodeToString(str2.getBytes());
        System.out.println(base64Encoded2);


        String str3 = "3,"+"1234";
        String base64Encoded3 = Base64.encodeToString(str3.getBytes());
        System.out.println(base64Encoded3);

        String str4 = "4,"+"1234";
        String base64Encoded4 = Base64.encodeToString(str4.getBytes());
        System.out.println(base64Encoded4);
    }


}
