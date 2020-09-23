package com.qfedu.dao;

import com.qfedu.entity.Car;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderTwo;

import java.util.List;

/**
 * projectName: TestThreeProject
 *
 * @author: 张剑
 * time: 2020/9/19 0019 上午 9:30
 * description:
 */
public interface OrderDao {
    //获取所预定车辆的信息
    public Car findCarById(int id);
    //提交订单
    public void addCar(Order order);
    //查询订单
    public List<OrderTwo> orderSelect(int id);
    //删除订单
    public void deleteOrder(int id);
}
