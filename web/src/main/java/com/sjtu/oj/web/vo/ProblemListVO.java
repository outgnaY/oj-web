package com.sjtu.oj.web.vo;

import com.sjtu.oj.web.model.Problem;

import java.util.List;

public class ProblemListVO {

    public ProblemListVO(List<Problem> data, int total, int page) {
        this.data = data;
        this.total = total;
        this.page = page;
    }

    public List<Problem> getData() {
        return data;
    }

    public void setData(List<Problem> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private List<Problem> data;
    private int total;
    private int page;
}
