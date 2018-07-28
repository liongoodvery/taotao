package com.taotao.common.pojo;

import java.io.Serializable;

/**
 *
 */
public class TaotaoResult<T> implements Serializable {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private T data;

    //构建其他状态的taotaoresult对象
    public static <T> TaotaoResult build(Integer status, String msg, T data) {
        return new TaotaoResult(status, msg, data);
    }

    public static <T> TaotaoResult ok(T data) {
        return new TaotaoResult(data);
    }

    public static TaotaoResult ok() {
        return new TaotaoResult(null);
    }

    public TaotaoResult() {

    }

    public static TaotaoResult build(Integer status, String msg) {
        return new TaotaoResult(status, msg, null);
    }

    public TaotaoResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public TaotaoResult(T data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
