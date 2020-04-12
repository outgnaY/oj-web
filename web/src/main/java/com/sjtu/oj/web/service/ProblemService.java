package com.sjtu.oj.web.service;

import com.sjtu.oj.web.mapper.ProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ProblemService {
    @Resource
    private ProblemMapper problemMapper;
    public long getNumberOfProblems() {
        return problemMapper.getNumberOfProblems();
    }
}
