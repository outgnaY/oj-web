package com.sjtu.oj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.sjtu.oj.web.service.AnnouncementService;
import com.sjtu.oj.web.vo.AnnouncementListVO;
import com.sjtu.oj.web.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/api/announcement")
@RestController
public class AnnouncementController {
    @Resource
    private AnnouncementService announcementService;
    @GetMapping("/get_page")
    public ResultVO getAnnouncementList(@RequestParam int page, @RequestParam int pageSize) {
        return announcementService.getAnnouncementList(page, pageSize);
    }

}
