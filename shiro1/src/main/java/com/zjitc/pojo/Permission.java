package com.zjitc.pojo;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:9:39
 */
public class Permission {
    private Integer id;
    private String permissionName;

    public Permission() {
    }

    public Permission(Integer id, String permissionName) {
        this.id = id;
        this.permissionName = permissionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }
}
