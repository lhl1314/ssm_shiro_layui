package com.zjitc.pojo;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:9:34
 */
public class Role {
    private Integer id;
    private String roleName;

    //一个角色有很多的权限

    private List<RolePermission>rolePermissions;

    public List<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public Role() {
    }

    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", rolePermissions=" + rolePermissions +
                '}';
    }
}
