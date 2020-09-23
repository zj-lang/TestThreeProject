package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * projectName: TestTherrProject
 *
 * @author: 张剑
 * time: 2020/9/17 0017 下午 4:29
 * description:
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userservice;

    //注册
    @RequestMapping("/register.do")
    @ResponseBody
    public JsonResult register(String tel, String password, String email, String invitation) {
        System.out.println (tel);
        System.out.println (password);
        System.out.println (email);
        System.out.println (invitation);
        userservice.register(tel, password, email, invitation);
        return new JsonResult(1, null);
    }

    //登录
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(String tel, String password, HttpSession session) {
        User user = userservice.login(tel, password);
        session.setAttribute("loginUser",user);
        return new JsonResult(1,user);
    }

    //主页获取登录状态
    @RequestMapping("/query.do")
    @ResponseBody
    public JsonResult query (HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            return new JsonResult(0,"未登录!");
        }else{
            return new JsonResult(1,user);
        }
    }

    //订单页面获取登录手机号
    @RequestMapping("/loginStatus.do")
    @ResponseBody
    public JsonResult loginStatus(HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        return new JsonResult(1, user.getTel());
    }

    //退出登录(清除session,然后重定向到主页，地址栏变化)
    @RequestMapping("/outlogin.do")
   // @ResponseBody
    public String outLogin(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }
}
