package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Car;
import com.qfedu.entity.City;
import com.qfedu.service.CityService;
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
 * projectName: TestTherrProject
 *
 * @author: 张剑
 * time: 2020/9/18 0018 上午 9:37
 * description:
 */
@Controller
@RequestMapping("/city")
public class CarSelectController {
    @Autowired
    private CityService cityService;
    @RequestMapping("/select.do")
    @ResponseBody
    //租车 还车地点（城市，县区）
    public JsonResult selectCity(Integer pid, HttpSession session) {

        System.out.println("pid=====" + pid);
        if (pid == null) {
            pid = 0;
        }
        List<City> list = cityService.select(pid);

        return new JsonResult(1,list);
    }


    @RequestMapping("button.do")
    @ResponseBody
    public JsonResult button(Integer quiz1, Integer quiz2, Integer quiz3, Integer quiz4){
        if(quiz1==null||quiz2==null||quiz3==null||quiz4==null){
            return new JsonResult (0,"请选择正确区域");
        }
        DistrictUtils.setQuiz1 (quiz1);
        DistrictUtils.setQuiz2 (quiz2);
        DistrictUtils.setQuiz3 (quiz3);
        DistrictUtils.setQuiz4 (quiz4);
        return new JsonResult (1,"YES");
    }

    @RequestMapping("showCar.do")
    @ResponseBody
    public Map<String, Object> showCar(Integer page, Integer limit) {
        System.out.println(page);
        System.out.println(limit);

        //DistrictUtils.getQuiz2() 为 sys_city表中的id值，此id对应sys_car表中的cid
        List<Car> cars = cityService.selectByCityId(DistrictUtils.getQuiz2(), page, limit);
        long total = ((Page) cars).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",cars);
        return map;
    }

    //汽车列表信息页面 取车地址 还车地址的信息
    @RequestMapping("selectName.do")
    @ResponseBody
    public JsonResult selectName() {
        City city = cityService.selectMsg(DistrictUtils.getQuiz2());
        City city1 = cityService.selectMsg(DistrictUtils.getQuiz4());
        //把查询出来的地址信息放入数组中，返回给前端
        String[] strings = {city.getName(),city1.getName()};

        return new JsonResult(1, strings);
    }
}
