package com.sjtu.oj.web.mapper;

import com.alibaba.fastjson.JSONObject;
import com.sjtu.oj.web.model.Announcement;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.Date;
import java.util.List;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
public interface AnnouncementMapper {
    // List<Announcement>
    int getAnnouncementNum();
    List<Announcement> getAnnouncements();
    Announcement getAnnouncementById(long id);
    List<Announcement> getAnnouncementList(int currentIndex, int pageSize);
    int deleteAnnouncementById(long id);
    int createAnnouncement(String title, Date createTime, Date lastUpdateTime, String createBy, String content);
    int updateAnnouncement(long id, String title, Date lastUpdateTime, String content);
}
