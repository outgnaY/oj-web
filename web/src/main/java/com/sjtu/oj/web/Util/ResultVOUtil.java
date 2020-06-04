package com.sjtu.oj.web.util;

import com.sjtu.oj.web.vo.ResultVOData;
import com.sjtu.oj.web.vo.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(String msg) {
        return new ResultVO(Constants.SUCCESS_CODE, msg);
    }
    public static ResultVO error(String msg) {
        return new ResultVO(Constants.DEFAULT_ERROR_CODE, msg);
    }
    public static ResultVO error(int code, String msg) {
        return new ResultVO(code, msg);
    }
    public static ResultVO success(String msg, Object object) {
        return new ResultVOData(Constants.SUCCESS_CODE, "success", object);
    }
    public static ResultVO error(int code, String msg, Object object) {
        return new ResultVOData(code, msg, object);
    }
    public static ResultVO error(String msg, Object object) {
        return new ResultVOData(Constants.DEFAULT_ERROR_CODE, msg, object);
    }
}
