package com.sjtu.oj.web.service;

import com.sjtu.oj.web.mapper.ProblemMapper;
import com.sjtu.oj.web.model.Problem;
import com.sjtu.oj.web.vo.ProblemListVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProblemService {
    @Resource
    private ProblemMapper problemMapper;
    public int getNumberOfProblems() {
        return problemMapper.getNumberOfProblems();
    }
    public Problem getProblemById(long id) {
        return problemMapper.getProblemById(id);
    }
    public ProblemListVO getProblemList(int page, int pageSize) {
        int num = problemMapper.getNumberOfProblems();
        int maxPage = num / pageSize;
        if(num % pageSize != 0) {
            maxPage += 1;
        }

        if(page < 1 || page > maxPage) {
            page = 1;
        }
        List<Problem> list = problemMapper.getProblemList((page - 1) * pageSize, pageSize);
        return new ProblemListVO(list, num, page);
    }
    public ProblemListVO getProblemListByKeyWord(int page, int pageSize, String keyword) {
        List<Problem> list = problemMapper.getProblemListByKeyword(keyword);
        int num = list.size();
        int maxPage = num / pageSize;
        if(num % pageSize != 0) {
            maxPage += 1;
        }
        if(page < 1 || page > maxPage) {
            page = 1;
        }
        int toIndex = page * pageSize > list.size() ? list.size() : page * pageSize;
        List<Problem> retList = list.subList((page - 1) * pageSize, toIndex);
        return new ProblemListVO(retList, num, page);
    }
}
