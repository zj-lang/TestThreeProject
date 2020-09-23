package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.OrderDao;
import com.qfedu.entity.Car;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderTwo;
import com.qfedu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: TestThreeProject
 *
 * @author: 张剑
 * time: 2020/9/19 0019 上午 9:38
 * description:
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDao orderDao;

    //获取所预定车辆的信息
    @Override
    public Car findCarById(int id) {
        Car car = orderDao.findCarById(id);
        return car;
    }

    //提交订单信息
    @Override
    public void addCar(Order order) {
        if (order == null) {
            throw new RuntimeException("订单信息错误!");
        }
        orderDao.addCar(order);
    }
    //查询订单信息
    @Override
    public List<OrderTwo> orderSelect(int id, int page, int limit) {
        PageHelper.startPage(page, limit);
        List<OrderTwo> orders = orderDao.orderSelect(id);
        return orders;
    }

    //删除订单信息
    @Override
    public void deleteOrder(int id) {
        orderDao.deleteOrder(id);
    }

}
