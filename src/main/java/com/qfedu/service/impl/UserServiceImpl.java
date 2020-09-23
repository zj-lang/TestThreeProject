package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName: TestTherrProject
 *
 * @author: 张剑
 * time: 2020/9/17 0017 下午 4:03
 * description:
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
     private UserDao userDao;
    //注册
    @Override
    public void register(String tel, String password, String email, String invitation) {
        //通过手机号查询用户
        User user1 = userDao.findByTel(tel);
        //用户存在，不注册
        if (user1 != null) {
            throw new RuntimeException("用户已存在");
        }
        //注册用户
        User user = new User();
        user.setTel(tel);
        user.setPassword(password);
        user.setEmail(email);
        user.setInvitation(invitation);
        userDao.register(user);
    }

    @Override
    public User login(String tel, String password) {
        User user = userDao.findByTel(tel);
        if (user == null) {
            throw new RuntimeException("手机号错误!");
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误!");
        }

        return user;
    }
}
