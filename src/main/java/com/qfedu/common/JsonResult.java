package com.qfedu.common;

/**
 * projectName: TestTherrProject
 *
 * @author: 张剑
 * time: 2020/9/17 0017 下午 4:36
 * description:
 */
public class JsonResult {
    private int code;
    private Object info;

    public JsonResult() {
    }

    public JsonResult(int code, Object info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", info=" + info +
                '}';
    }
}
