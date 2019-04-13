package com.zjitc.layui.pojo;

import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/28 0028
 * Time:17:06
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String headerImage;
    private String hobby;
    private Timestamp birthday;

    public User() {
    }

    public User(Integer id, String username, String password, String sex, String headerImage, String hobby, Timestamp birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.headerImage = headerImage;
        this.hobby = hobby;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", headerImage='" + headerImage + '\'' +
                ", hobby='" + hobby + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
