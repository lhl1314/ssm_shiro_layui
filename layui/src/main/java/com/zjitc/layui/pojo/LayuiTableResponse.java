package com.zjitc.layui.pojo;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/29 0029
 * Time:10:50
 */
public class LayuiTableResponse<T> {
    private Integer code;//0
    private String msg;//""
    private Integer count;//10000
    private List<T>data;


    public LayuiTableResponse() {
    }

    public LayuiTableResponse(Integer code, String msg, Integer count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "LayuiTableResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
