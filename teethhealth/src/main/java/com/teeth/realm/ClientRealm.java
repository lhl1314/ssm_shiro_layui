package com.teeth.realm;

import com.teeth.pojo.User;
import com.teeth.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:15:03
 */
public class ClientRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();//获取身份信息
        User one = userService.findOne(username);
        if (one!=null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(one, one.getPassword(), null, getName());
            return info;
        }
        return null;
    }
}
