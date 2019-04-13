package com.teeth.service.imp;

import com.github.pagehelper.PageHelper;
import com.teeth.dao.AddressChooseDao;
import com.teeth.dao.AdminUserDao;
import com.teeth.dao.RolePermissionDao;
import com.teeth.pojo.*;
import com.teeth.service.AdminUserService;
import com.teeth.utils.Utils;
import com.teeth.utils.UtilsShiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    @Autowired
    RolePermissionDao rolePermissionDao;
    @Autowired
    AddressChooseDao addressChooseDao;
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

    @Override
    public List<AdminUser> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdminUser> all = adminUserDao.getAll();
        return all;
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

    @Override
    public AdminUser findOneById(int id) {
        AdminUser one = adminUserDao.getOne(id);
        if (one.getProvinceId()!=null){
            one.setProvince(addressChooseDao.getOneProvince(one.getProvinceId()));
        }
        if (one.getCityId()!=null){
            one.setCity(addressChooseDao.getOneCity(one.getCityId()));
        }

        if (one.getAreaId()!=null){
            one.setArea(addressChooseDao.getOneArea(one.getAreaId()));
        }
        one.setPassword(UtilsShiro.jieMi(one.getPassword()));
        return one;
    }

    @Override
    public void updateMySelf(AdminUser adminUser) {
        adminUser.setPassword(UtilsShiro.jiaMi(adminUser.getId(),adminUser.getPassword()));
        adminUserDao.updateAdminUser(adminUser);
    }

    @Override
    public Integer ciTuiAdminUser(int id) {
        AdminUser one = adminUserDao.getOne(id);
        if (one!=null){
            if (one.getStatus()==1){
                List<AdminUserRole> adminUserRoleList = one.getAdminUserRole();
                if (adminUserRoleList!=null&&!adminUserRoleList.isEmpty()){
                    for (AdminUserRole userRole:adminUserRoleList){
                        if (userRole!=null){
                            if (userRole.getRoleId()==1){
                                return -1;//辞退失败，此用户是老板的角色
                            }
                        }
                    }
                }
                one.setStatus(0);
                adminUserDao.updateAdminUser(one);
                return 1; //辞退成功
            }else {
                return 0;//辞退失败
            }
        }
        return 0;//辞退失败
    }

    public boolean judgeHasRoleMax(AdminUser adminUser){
        if (adminUser!=null){
            List<AdminUserRole> adminUserRoleList = adminUser.getAdminUserRole();
            if (adminUserRoleList!=null&&!adminUserRoleList.isEmpty()){
                for (AdminUserRole userRole:adminUserRoleList){
                    if (userRole!=null){
                        if (userRole.getRoleId()==1){
                            return true;//这儿是老板的角色
                        }
                    }
                }
            }
        }
        return false;
    }
    @Override
    public Integer deleteAdminUser(int id) {
        AdminUser one = adminUserDao.getOne(id);
        if (one!=null){
            //在这里删除一个管理者
            boolean b = judgeHasRoleMax(one);
            if (one.getStatus()==1){
                //如果未被辞退，不能删除
                return 0;
            }else {
                if (b){
                    return -1;//是老板
                }
                rolePermissionDao.deleteAdminRole(id);//删除该管理员角色
                adminUserDao.deleteAdminUser(id);//删除管理员
            return 1;//删除成功
            }
        }
        return null;
    }

    @Override
    public void addAdminUser(String username, String password, String addAdminRoleList) {

        AdminUser adminUser=new AdminUser();
        adminUser.setUsername(username);
        adminUserDao.addAdminUser(adminUser);
        addAdminUserRole(adminUser.getId(),addAdminRoleList);
        adminUser.setPassword(UtilsShiro.jiaMi(adminUser.getId(),password));
        adminUserDao.updateAdminUser(adminUser);
    }

    /**
     * 添加管理员和角色的中间表
     * @param id
     * @param msg
     */
    public void addAdminUserRole(Integer id,String msg){
        if (msg!=null&&!msg.equals("")){
            String[] strings = msg.split(",");
            if (strings!=null&&strings.length!=0){
                List<String> asList = Arrays.asList(strings);
                Integer adminUserId = id;
                for (String s:asList){
                    Integer roleId= Integer.valueOf(s);
                    AdminUserRole userRole = new AdminUserRole();
                    userRole.setAdminUserId(adminUserId);
                    userRole.setRoleId(roleId);
                    rolePermissionDao.addAdminUserRole(userRole);
                }
            }
        }else {
            rolePermissionDao.deleteAdminRole(id);
        }

    }

    @Override
    public void updateAdminUserRoles(Integer id, String updateAdminRoleList) {
        rolePermissionDao.deleteAdminRole(id);
        addAdminUserRole(id,updateAdminRoleList);
    }
}
