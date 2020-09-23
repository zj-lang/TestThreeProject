package com.qfedu.service;

import com.qfedu.entity.User;

/**
 * projectName: TestTherrProject
 *
 * @author: 张剑
 * time: 2020/9/17 0017 下午 3:58
 * description:
 */
public interface UserService {
    //注册
    public void register(String tel, String password, String email, String invitation);
    //登录
    public User login(String tel, String password);
}
