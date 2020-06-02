package com.sjtu.oj.web.controller;

import com.sjtu.oj.web.model.Problem;
import com.sjtu.oj.web.service.ProblemService;
import com.sjtu.oj.web.vo.ProblemListVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/api/problem")
@RestController
public class ProblemController {
    @Resource
    private ProblemService problemService;
    @GetMapping("/get_num")
    public int getProblemNum() {
        return problemService.getNumberOfProblems();
    }
    @GetMapping("/get_page")
    public ProblemListVO getProblemList(@RequestParam int page, @RequestParam int pageSize) {
        return problemService.getProblemList(page, pageSize);
    }
    @GetMapping("/get_page_by_keyword")
    public ProblemListVO getProblemListByKeyword(@RequestParam int page, @RequestParam int pageSize, @RequestParam String keyword) {
        return problemService.getProblemListByKeyWord(page, pageSize, keyword);
    }
}
