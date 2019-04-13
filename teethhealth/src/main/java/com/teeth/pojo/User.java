package com.teeth.pojo;

import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:10:20
 */
public class User {
    private Integer id;
    private String username;
    private String hobby;
    private Date birthday;

    private String password;


    public User() {
    }

    public User(Integer id, String username, String hobby, Date birthday, String password) {
        this.id = id;
        this.username = username;
        this.hobby = hobby;
        this.birthday = birthday;
        this.password = password;
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", hobby='" + hobby + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                '}';
    }
}
