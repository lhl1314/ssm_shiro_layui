package com.teeth.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;

import java.io.Serializable;
import java.security.Key;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/8 0008
 * Time:17:06
 */
public class UtilsShiro implements Serializable {
    static AesCipherService aesCipherService = null;
    static Key key = null;

    static {
        aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); //设置key长度
//生成key
        key = aesCipherService.generateNewKey();
    }

    /**
     * AES算法的加密解密
     */
    /**
     * 加密
     * @param msg
     * @return
     */
    public  static String jiaMi(Integer id,String msg){
        String s=id.toString()+","+msg;
        //加密
        String base64Encoded = Base64.encodeToString(s.getBytes());
       return base64Encoded;
    }

    /**
     * 解密
     * @param msg
     * @return
     */
    public static String jieMi(String msg){
        String str2 = Base64.decodeToString(msg);
        String[] strings = str2.split(",");
        return strings[1];
    }
}
