package com.sjtu.oj.web.vo;

public class ResultVOData extends ResultVO {
    public ResultVOData(int code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;

}
