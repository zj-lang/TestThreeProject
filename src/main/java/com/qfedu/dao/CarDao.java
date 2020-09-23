package com.qfedu.dao;

import com.qfedu.entity.Car;
import com.qfedu.entity.City;

import java.util.List;

/**
 * projectName: TestTherrProject
 *
 * @author: 张剑
 * time: 2020/9/17 0017 下午 10:03
 * description:
 */
public interface CarDao {
    //短租自驾 租车 还车地点
    public List<City> select(int pid);

    //展示汽车列表信息
    public List<Car> selectByCityId(int cid);

    //取车地址 还车地址信息
    public City selectMsg(int id);
}
