package com.teeth.dao;

import com.teeth.pojo.AdminUserRole;
import com.teeth.pojo.Permission;
import com.teeth.pojo.Role;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/9 0009
 * Time:14:31
 */
public interface RolePermissionDao {
    /**
     * 获取所有的角色
     * @return
     */
    List<Role>getAllRoles();

    /**
     * 获取某个角色的权限
     * @param roleId
     * @return
     */
    Role getAllPermissionByRoleId(int roleId);


    /**
     * 先删除该管理员的所有角色
     * @param adminUserId
     */
    void deleteAdminRole(Integer adminUserId);


    /**
     * 给某个管理员添加角色
     * @param adminUserRole
     */
    void addAdminUserRole(AdminUserRole adminUserRole);
}
