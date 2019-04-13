package com.teeth.realm;
import com.teeth.pojo.AdminUser;
import com.teeth.service.AdminUserService;
import com.teeth.utils.UtilsShiro;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/3 0003
 * Time:14:37
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    AdminUserService adminUserService;

    /**
     * 授权--------------只有用到这个角色的时候才会进入到这个方法（授权验证的时候）
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("这里是授权----------");
        AdminUser adminUser = (AdminUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = adminUserService.findRoles(adminUser.getUsername());
        if (roles!=null&&!roles.isEmpty()){
            System.out.println("----------------------角色"+roles);
            authorizationInfo.setRoles(roles);
        }
        Set<String> permissions = adminUserService.findPermissions(adminUser.getUsername());
        if (permissions!=null&&!permissions.isEmpty()){
            authorizationInfo.setStringPermissions(permissions);
            System.out.println("------------------权限"+permissions);
        }
        return authorizationInfo;
    }

    /**
     * 登陆
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();//获取身份信息
        AdminUser one = adminUserService.findOne(username);
        if (one!=null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(one, UtilsShiro.jieMi(one.getPassword()), null, getName());
            return info;
        }
        return null;
    }
}
