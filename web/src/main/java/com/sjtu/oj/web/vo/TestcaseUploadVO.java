package com.sjtu.oj.web.vo;

import com.sjtu.oj.web.model.TestcaseInfo;

import java.util.List;

public class TestcaseUploadVO {
    public TestcaseUploadVO(boolean success, List<TestcaseInfo> info, String msg, String testcaseId) {
        this.success = success;
        this.info = info;
        this.msg = msg;
        this.testcaseId = testcaseId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<TestcaseInfo> getInfo() {
        return info;
    }

    public void setInfo(List<TestcaseInfo> info) {
        this.info = info;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTestcaseId() {
        return testcaseId;
    }

    public void setTestcaseId(String testcaseId) {
        this.testcaseId = testcaseId;
    }

    private boolean success;
    private List<TestcaseInfo> info;
    private String msg;
    private String testcaseId;
}

