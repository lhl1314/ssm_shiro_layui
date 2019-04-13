package com.teeth.service.imp;

import com.teeth.dao.RolePermissionDao;
import com.teeth.pojo.Role;
import com.teeth.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/9 0009
 * Time:14:42
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    RolePermissionDao rolePermissionDao;
    @Override
    public List<Role> getAll() {
        return rolePermissionDao.getAllRoles();
    }

    @Override
    public Role getPermissionsByRoleId(int roleId) {
        return rolePermissionDao.getAllPermissionByRoleId(roleId);
    }
}
