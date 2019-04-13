package com.teeth.service;

import com.teeth.pojo.Role;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/9 0009
 * Time:14:42
 */
public interface AdminRoleService {
    /**
     * 获取所有的角色
     * @return
     */
    List<Role>getAll();

    /**
     * 获取权限
     * @param roleId
     * @return
     */
    Role getPermissionsByRoleId(int roleId);
}
