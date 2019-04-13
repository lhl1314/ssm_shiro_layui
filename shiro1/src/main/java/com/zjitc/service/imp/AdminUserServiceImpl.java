package com.zjitc.service.imp;

import com.zjitc.dao.AdminUserDao;
import com.zjitc.pojo.*;
import com.zjitc.service.AdminUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:9:42
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserDao adminUserDao;

    @Override
    public List<AdminUser> getAll() {
        List<AdminUser> all = adminUserDao.getAll();
        return all;
    }

    @Override
    public int login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {

            subject.login(token);//shiro进行验证用户登陆合法性, 如果合法，则更新session表userid
            Session session = subject.getSession();//
            AdminUser o = (AdminUser) subject.getPrincipal();
            if (session != null) {
                return 1;
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public AdminUser findOne(String username) {
        AdminUser one = adminUserDao.findOneByUserName(username);
        return one;
    }

    @Override
    public Set<String> findRoles(String username) {
        List<AdminUserRole> adminUserRoleList = getAdminUserRole(username);
        Set<String> roleSet = new HashSet<>();
        for (AdminUserRole adminUserRole : adminUserRoleList) {
            Role role = adminUserRole.getRole();
            if (role != null) {
                roleSet.add(role.getRoleName());
            }
        }
        return roleSet;
    }

    @Override
    public Set<String> findPermissions(String username) {
        Set<String> permissionSet = new HashSet<>();
        List<RolePermission> rolePermissionList = getRolePermissionList(username);
        for (RolePermission rolePermission : rolePermissionList) {
            Permission permission = rolePermission.getPermission();
            if (permission != null) {
                permissionSet.add(permission.getPermissionName());
            }
        }
        return permissionSet;
    }


    public List<AdminUserRole> getAdminUserRole(String username) {
        AdminUser user = adminUserDao.findOneByUserName(username);
        if (user != null) {
            List<AdminUserRole> adminUserRoleList = user.getAdminUserRole();
            if (adminUserRoleList != null && !adminUserRoleList.isEmpty()) {
                return adminUserRoleList;
            }
        }
        return null;
    }

    public List<RolePermission> getRolePermissionList(String username) {
        List<AdminUserRole> roleList = getAdminUserRole(username);
        for (AdminUserRole adminUserRole : roleList) {
            Role role = adminUserRole.getRole();
            if (role != null) {
                List<RolePermission> rolePermissionList = role.getRolePermissions();
                if (rolePermissionList != null && !rolePermissionList.isEmpty()) {
                    return rolePermissionList;
                }
            }
        }
        return null;
    }
}
