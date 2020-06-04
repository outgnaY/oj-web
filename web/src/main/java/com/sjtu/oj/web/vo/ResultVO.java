package com.sjtu.oj.web.vo;

public class ResultVO {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private int code;
    private String msg;
    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
