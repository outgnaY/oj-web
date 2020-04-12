package com.sjtu.oj.web.controller;

import com.sjtu.oj.web.mapper.ProblemMapper;
import com.sjtu.oj.web.model.Problem;
import com.sjtu.oj.web.service.ProblemService;
import com.sjtu.oj.web.util.MailSenderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/test")
@RestController
public class TestController {
    @Resource
    MailSenderUtil mailSenderUtil;
    @Resource
    ProblemService problemService;
    @GetMapping("/send")
    public void send() {
        mailSenderUtil.test();
    }
    @GetMapping("/problem")
    public long getNumberOfProblems() {
        return problemService.getNumberOfProblems();
    }
}
