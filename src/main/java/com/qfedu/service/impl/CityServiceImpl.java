package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CarDao;
import com.qfedu.entity.Car;
import com.qfedu.entity.City;
import com.qfedu.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: TestTherrProject
 *
 * @author: 张剑
 * time: 2020/9/18 0018 上午 9:40
 * description:
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CarDao carDao;


    //租车 还车地点
    @Override
    public List<City> select(int pid) {
        List<City> list = carDao.select(pid);
        return list;
    }
    //汽车列表信息展示
    @Override
    public List<Car> selectByCityId(int cid, Integer page, Integer limit) {
        //分页方法固定放在此查询方法上
        PageHelper.startPage(page, limit);
        List<Car> cars = carDao.selectByCityId(cid);
        if (cars.size() == 0) {
            throw new RuntimeException("所选地区暂无车辆");
        }
        return cars;
    }

    ////汽车列表信息页面 取车地址 还车地址的信息
    @Override
    public City selectMsg(int id) {
        City city = carDao.selectMsg(id);
        return city;
    }
}
