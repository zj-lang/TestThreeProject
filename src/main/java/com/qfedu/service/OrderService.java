package com.qfedu.service;

import com.qfedu.entity.Car;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderTwo;

import java.util.List;

/**
 * projectName: TestThreeProject
 *
 * @author: 张剑
 * time: 2020/9/19 0019 上午 9:37
 * description:
 */
public interface OrderService {
    //获取所预定车辆的信息
    public Car findCarById(int id);
    //提交订单信息
    public void addCar(Order order);
    //查询订单信息
    List<OrderTwo> orderSelect(int id, int page, int limit);
    //删除订单信息
    public void deleteOrder(int id);
}
