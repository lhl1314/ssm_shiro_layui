package com.teeth.pojo;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:13:33
 */
public class AdminUserRole {
    private Integer id;
    private Integer adminUserId;
    private Integer roleId;


    //一个角色
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AdminUserRole() {
    }

    public AdminUserRole(Integer id, Integer adminUserId, Integer roleId) {
        this.id = id;
        this.adminUserId = adminUserId;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AdminUserRole{" +
                "id=" + id +
                ", adminUserId=" + adminUserId +
                ", roleId=" + roleId +
                ", role=" + role +
                '}';
    }
}
