package com.sjtu.oj.web.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.sjtu.oj.web.model.Announcement;
import com.sjtu.oj.web.service.AnnouncementService;
import com.sjtu.oj.web.vo.AnnouncementListVO;
import com.sjtu.oj.web.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RequestMapping("/api/admin/announcement")
@RestController
public class AdminAnnouncementController {
    @Resource
    private AnnouncementService announcementService;
    @GetMapping("/get_page")
    public ResultVO getAnnouncementList(@RequestParam int page, @RequestParam int pageSize) {
        return announcementService.getAnnouncementList(page, pageSize);
    }
    @GetMapping("/del_by_id")
    public ResultVO deleteAnnouncementById(@RequestParam long id) {
        return announcementService.deleteAnnouncementById(id);
    }
    @GetMapping("create")
    public ResultVO createAnnouncement(@RequestParam String title, @RequestParam Date createTime, @RequestParam Date lastUpdateTime, @RequestParam String createBy, @RequestParam String content) {
        return announcementService.createAnnouncement(title, createTime, lastUpdateTime, createBy, content);
    }
    @GetMapping("update")
    public ResultVO updateAnnouncement(@RequestParam long id, @RequestParam String title, @RequestParam Date lastUpdateTime, @RequestParam String content) {
        return announcementService.updateAnnouncement(id, title, lastUpdateTime, content);
    }
    @GetMapping("get_by_id")
    public ResultVO getAnnouncementById(@RequestParam long id) {
        return announcementService.getAnnouncementById(id);
    }
    @GetMapping("get_all")
    public ResultVO getAnnouncements() {
        return announcementService.getAnnouncements();
    }
}
