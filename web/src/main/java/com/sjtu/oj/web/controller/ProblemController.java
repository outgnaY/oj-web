package com.sjtu.oj.web.controller;

import com.sjtu.oj.web.model.Problem;
import com.sjtu.oj.web.service.ProblemService;
import com.sjtu.oj.web.vo.ProblemListVO;
import com.sjtu.oj.web.vo.ResultVO;
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
    @GetMapping("/get_by_id")
    public ResultVO getProblemById(@RequestParam long id) {
        return problemService.getProblemById(id);
    }
    @GetMapping("/get_num")
    public ResultVO getProblemNum() {
        return problemService.getNumberOfProblems();
    }
    @GetMapping("/get_page")
    public ResultVO getProblemList(@RequestParam int page, @RequestParam int pageSize) {
        return problemService.getProblemList(page, pageSize);
    }
    @GetMapping("/get_page_by_keyword")
    public ResultVO getProblemListByKeyword(@RequestParam int page, @RequestParam int pageSize, @RequestParam String keyword) {
        return problemService.getProblemListByKeyWord(page, pageSize, keyword);
    }
}
