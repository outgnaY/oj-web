package com.sjtu.oj.web.service;

import com.sjtu.oj.web.mapper.WebsiteConfigMapper;
import com.sjtu.oj.web.model.WebsiteConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class WebsiteConfigService {
    @Resource
    private WebsiteConfigMapper websiteConfigMapper;
    public WebsiteConfig getWebsiteConfig() {
        return websiteConfigMapper.getWebsiteConfig();
    }
}
