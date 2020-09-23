package com.qfedu.dao;

import com.qfedu.entity.User;

/**
 * projectName: TestTherrProject
 *
 * @author: 张剑
 * time: 2020/9/17 0017 下午 3:54
 * description:
 */
public interface UserDao {
    //注册
    public void register(User user);

    //登录
    public User findByTel(String tel);
}
