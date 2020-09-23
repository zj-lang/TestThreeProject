package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.dao.OrderDao;
import com.qfedu.entity.*;
import com.qfedu.service.CityService;
import com.qfedu.service.OrderService;
import com.qfedu.utils.DistrictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * projectName: TestThreeProject
 *
 * @author: 张剑
 * time: 2020/9/19 0019 上午 9:43
 * description:
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CityService cityService;

    //获取所预定车辆的信息
    @RequestMapping("/findCar.do")
    @ResponseBody
    public JsonResult findCarById(int id) {
        System.out.println(id);
        Car car = orderService.findCarById(id);
        return new JsonResult(1, car);
    }

    //提交订单信息
    @RequestMapping("addCar.do")
    @ResponseBody
    public JsonResult addCar(Integer id, Integer oprice, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            return new JsonResult(0,"未登录!");
        }
        Integer quiz2 = DistrictUtils.getQuiz2();
        Integer quiz4 = DistrictUtils.getQuiz4();
        City city = cityService.selectMsg(quiz2);
        City city1 = cityService.selectMsg(quiz4);

        System.out.println (id);
        System.out.println (oprice);
        System.out.println (city);
        System.out.println (city1);

        Order order = new Order ();
        order.setCid (id);
        order.setOprice (oprice);
        order.setGetid (city.getId ());
        order.setBackid (city1.getId ());
        order.setUid (user.getId ());
        order.setStatus ("已预定");
        System.out.println (order);
        orderService.addCar (order);
        return new JsonResult (1,"预定成功");
    }

    //查询订单信息
    @RequestMapping("orderSelect.do")
    @ResponseBody
    public Map<String,Object> orderSelect(Integer page, Integer limit, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            return null;
        }
        System.out.println(user);
        Integer id = user.getId();
        List<OrderTwo> orders = orderService.orderSelect(id, page, limit);
        long total = ((Page) orders).getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", orders);
        return map;
    }

    //删除订单信息
    @RequestMapping("/deleteOrder.do")
    @ResponseBody
    public JsonResult deleteOrder(Integer id) {

        System.out.println(id + "传过来了吗");
        orderService.deleteOrder(id);
        return new JsonResult(1,"删除成功!");
    }
}
