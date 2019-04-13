package com.zjitc.pojo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:9:37
 */
public class AdminUser {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String mobile;
    private String email;
    private Timestamp birthday;
    private Date createTime;
    private Date updateTime;

    //用户角色表
    private List<AdminUserRole> adminUserRole;

    public List<AdminUserRole> getAdminUserRole() {
        return adminUserRole;
    }

    public void setAdminUserRole(List<AdminUserRole> adminUserRole) {
        this.adminUserRole = adminUserRole;
    }

    public AdminUser() {
    }

    public AdminUser(Integer id, String username, String password, String sex, String mobile, String email, Timestamp birthday, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.mobile = mobile;
        this.email = email;
        this.birthday = birthday;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", adminUserRole=" + adminUserRole +
                '}';
    }
}
