package com.sjtu.oj.web.service;

import com.sjtu.oj.web.mapper.LanguageInformationMapper;
import com.sjtu.oj.web.model.LanguageInformation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LanguageInformationService {
    @Resource
    LanguageInformationMapper languageInformationMapper;
    public List<LanguageInformation> getLanguageInformations() {
        return languageInformationMapper.getLanguageInformations();
    }
}
