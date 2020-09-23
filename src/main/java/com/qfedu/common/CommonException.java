package com.qfedu.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

/**
 * projectName: bankSystem
 *
 * @author: 张剑
 * time: 2020/9/11 0011 上午 12:37
 * description:处理全局异常的类
 */
@ControllerAdvice //控制器的增强，这个地方也必须要扫描，不然这个注解不生效
@ResponseBody
public class  CommonException {
    @ExceptionHandler(ConstraintViolationException.class) //修饰方法，表示的是一个异常书里的方法
    //返回一个json数据{code:0, info:"账号不能为空"}
    public JsonResult constraintViolationException(ConstraintViolationException ex){
        //验证不通过的信息
        Iterator<ConstraintViolation<?>> iterator = ex.getConstraintViolations().iterator();
        String message = null;
        //@NotEmpty @Size(min = 1,max = 10)不是只报一个错误，所以用迭代器
        if (iterator.hasNext()) {
            message = iterator.next().getMessage();
            System.out.println(message);
        }
        return new JsonResult(0,message);
    }

    //处理那些没意料到的异常,
    @ExceptionHandler
    public JsonResult commonException (Exception ex){
        return new JsonResult(0, ex.getMessage());
    }

}
