package com.sjtu.oj.web.model;

import java.util.Date;

public class Announcement {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 公告id
     */
    private long id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告创建时间
     */
    private Date createTime;
    /**
     * 公告最后更新时间
     */
    private Date lastUpdateTime;
    /**
     * 公告作者
     */
    private String createBy;
    /**
     * 公告内容
     */
    private String content;

}
