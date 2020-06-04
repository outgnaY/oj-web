package com.sjtu.oj.web.service;

import com.sjtu.oj.web.mapper.AnnouncementMapper;
import com.sjtu.oj.web.model.Announcement;
import com.sjtu.oj.web.util.ResultVOUtil;
import com.sjtu.oj.web.vo.AnnouncementListVO;
import com.sjtu.oj.web.vo.ResultVO;
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
    public ResultVO getAnnouncements() {
        List<Announcement> list = announcementMapper.getAnnouncements();
        return ResultVOUtil.success("success", list);
    }
    public ResultVO getAnnouncementById(long id) {
        Announcement announcement = announcementMapper.getAnnouncementById(id);
        if(announcement != null) {
            return ResultVOUtil.success("success", announcement);
        }
        else {
            return ResultVOUtil.error("error");
        }
    }
    public ResultVO deleteAnnouncementById(long id) {
        int affect = announcementMapper.deleteAnnouncementById(id);
        if(affect == 1) {
            return ResultVOUtil.success("success");
        }
        else {
            return ResultVOUtil.error("error");
        }
    }
    public ResultVO createAnnouncement(String title, Date createTime, Date lastUpdateTime, String createBy, String content) {
        int affect = announcementMapper.createAnnouncement(title, createTime, lastUpdateTime, createBy, content);
        if(affect == 1) {
            return ResultVOUtil.success("success");
        }
        else {
            return ResultVOUtil.error("error");
        }
    }
    public ResultVO updateAnnouncement(long id, String title, Date lastUpdateTime, String content) {
        int affect = announcementMapper.updateAnnouncement(id, title, lastUpdateTime, content);
        if(affect == 1) {
            return ResultVOUtil.success("success");
        }
        else {
            return ResultVOUtil.error("error");
        }
    }
    public ResultVO getAnnouncementList(int page, int pageSize) {
        int num = announcementMapper.getAnnouncementNum();
        int maxPage = num / pageSize;
        if(num % pageSize != 0) {
            maxPage += 1;
        }

        if(page < 1 || page > maxPage) {
            page = 1;
        }
        List<Announcement> list = announcementMapper.getAnnouncementList((page - 1) * pageSize, pageSize);
        AnnouncementListVO announcementListVO = new AnnouncementListVO(list, num, page);
        return ResultVOUtil.success("success", announcementListVO);
    }
}
