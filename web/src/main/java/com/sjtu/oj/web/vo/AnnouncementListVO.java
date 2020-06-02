package com.sjtu.oj.web.vo;

import com.sjtu.oj.web.model.Announcement;

import java.util.List;

public class AnnouncementListVO {

    public AnnouncementListVO(List<Announcement> data, int total, int page) {
        this.data = data;
        this.total = total;
        this.page = page;
    }
    public List<Announcement> getData() {
        return data;
    }

    public void setData(List<Announcement> data) {
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

    private List<Announcement> data;
    private int total;
    private int page;
}
