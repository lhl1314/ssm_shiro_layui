package com.zjitc.service.imp;

import com.zjitc.dao.UserDao;
import com.zjitc.pojo.AdminUser;
import com.zjitc.pojo.User;
import com.zjitc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/4 0004
 * Time:15:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public int login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);//shiro进行验证用户登陆合法性, 如果合法，则更新session表userid
            Session session = subject.getSession();//
            PrincipalCollection principals = subject.getPrincipals();
            Collection<User> collection = principals.fromRealm("clientRealm");
            User o = (User) subject.getPrincipal();
            if (session != null) {
                return 1;
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public User findOne(String username) {
        User user = userDao.getOne(username);
        return user;
    }
}
