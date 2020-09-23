package com.qfedu.service;

import com.qfedu.entity.Car;
import com.qfedu.entity.City;

import java.util.List;

/**
 * projectName: TestTherrProject
 *
 * @author: 张剑
 * time: 2020/9/17 0017 下午 10:05
 * description:
 */
public interface CityService {
    //租车 还车地点
    public List<City> select(int pid);

    //汽车列表信息
    public List<Car> selectByCityId(int cid, Integer page, Integer limit);

    //汽车列表信息页面 取车地址 还车地址的信息
    public City selectMsg(int id);
}
