package com.sjtu.oj.web.controller;

import com.sjtu.oj.web.Util.MailSenderUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/test")
@RestController
public class TestController {
    @Resource
    MailSenderUtil mailSenderUtil;
    @GetMapping("/send")
    public void send() {
        mailSenderUtil.test();
    }
}
