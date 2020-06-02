package com.sjtu.oj.web.service;

import com.sjtu.oj.web.mapper.AnnouncementMapper;
import com.sjtu.oj.web.model.Announcement;
import com.sjtu.oj.web.vo.AnnouncementListVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AnnouncementService {
    @Resource
    private AnnouncementMapper announcementMapper;
    public List<Announcement> getAnnouncements() {
        return announcementMapper.getAnnouncements();
    }
    public Announcement getAnnouncementById(long id) {
        return announcementMapper.getAnnouncementById(id);
    }
    public int deleteAnnouncementById(long id) {
        return announcementMapper.deleteAnnouncementById(id);
    }
    public int createAnnouncement(String title, Date createTime, Date lastUpdateTime, String createBy, String content) {
        return announcementMapper.createAnnouncement(title, createTime, lastUpdateTime, createBy, content);
    }
    public int updateAnnouncement(long id, String title, Date lastUpdateTime, String content) {
        return announcementMapper.updateAnnouncement(id, title, lastUpdateTime, content);
    }
    public AnnouncementListVO getAnnouncementList(int page, int pageSize) {
        int num = announcementMapper.getAnnouncementNum();
        int maxPage = num / pageSize;
        if(num % pageSize != 0) {
            maxPage += 1;
        }

        if(page < 1 || page > maxPage) {
            page = 1;
        }
        List<Announcement> list = announcementMapper.getAnnouncementList((page - 1) * pageSize, pageSize);
        return new AnnouncementListVO(list, num, page);
    }
}
