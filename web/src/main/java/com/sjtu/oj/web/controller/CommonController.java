package com.sjtu.oj.web.controller;

import com.sjtu.oj.web.mapper.ProblemMapper;
import com.sjtu.oj.web.model.LanguageInformation;
import com.sjtu.oj.web.model.Problem;
import com.sjtu.oj.web.model.WebsiteConfig;
import com.sjtu.oj.web.service.LanguageInformationService;
import com.sjtu.oj.web.service.ProblemService;
import com.sjtu.oj.web.service.WebsiteConfigService;
import com.sjtu.oj.web.util.MailSenderUtil;
import com.sjtu.oj.web.util.ResultVOUtil;
import com.sjtu.oj.web.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api")
@RestController
public class CommonController {
    @Resource
    MailSenderUtil mailSenderUtil;
    @Resource
    LanguageInformationService languageInformationService;
    @Resource
    WebsiteConfigService websiteConfigService;
    @GetMapping("/send")
    public void send() {
        mailSenderUtil.test();
    }
    @GetMapping("/language")
    public ResultVO getLanguageInformations() {
        return ResultVOUtil.success("success", languageInformationService.getLanguageInformations());
    }
    @GetMapping("/websiteconfig")
    public ResultVO getWebsiteConfig() {
        return ResultVOUtil.success("success", websiteConfigService.getWebsiteConfig());
    }
}
