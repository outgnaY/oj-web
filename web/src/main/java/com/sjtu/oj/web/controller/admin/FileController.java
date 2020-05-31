package com.sjtu.oj.web.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.sjtu.oj.web.model.Announcement;
import com.sjtu.oj.web.service.AnnouncementService;
import com.sjtu.oj.web.util.ImageUpload;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RequestMapping("/api/admin/")
@RestController
public class FileController {
    private static Logger logger = Logger.getLogger(FileController.class);
    @PostMapping(value = "/upload_image")
    public JSONObject imageUpload(@RequestParam(value="image", required=false) MultipartFile image) throws IOException {
        return ImageUpload.imageUpload(image);
    }

    @RequestMapping("/api/announcement")
    @RestController
    public static class AnnouncementController {
        @Resource
        AnnouncementService announcementService;
        @GetMapping("/get_all")
        public List<Announcement> getAnnouncements() {
            return announcementService.getAnnouncements();
        }
        @GetMapping("get_by_id")
        public Announcement getAnnouncementById(@RequestParam long id) {
            return announcementService.getAnnouncementById(id);
        }
        @GetMapping("get_list")
        public JSONObject getAnnouncementList(@RequestParam int page, @RequestParam int pageSize) {
            return announcementService.getAnnouncementList(page, pageSize);
        }
        @GetMapping("del_by_id")
        public int deleteAnnouncementById(@RequestParam long id) {
            return announcementService.deleteAnnouncementById(id);
        }
        @GetMapping("create")
        public int createAnnouncement(@RequestParam String title, @RequestParam Date createTime, @RequestParam Date lastUpdateTime, @RequestParam String createBy, @RequestParam String content) {
            return announcementService.createAnnouncement(title, createTime, lastUpdateTime, createBy, content);
        }
        @GetMapping("update")
        public int updateAnnouncement(@RequestParam long id, @RequestParam String title, @RequestParam Date lastUpdateTime, @RequestParam String content) {
            return announcementService.updateAnnouncement(id, title, lastUpdateTime, content);
        }
    }
}
