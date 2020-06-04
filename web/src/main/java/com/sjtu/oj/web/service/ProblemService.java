package com.sjtu.oj.web.service;

import com.sjtu.oj.web.mapper.ProblemMapper;
import com.sjtu.oj.web.model.Problem;
import com.sjtu.oj.web.util.ResultVOUtil;
import com.sjtu.oj.web.vo.ProblemListVO;
import com.sjtu.oj.web.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProblemService {
    @Resource
    private ProblemMapper problemMapper;
    public ResultVO getNumberOfProblems() {
        int num = problemMapper.getNumberOfProblems();
        return ResultVOUtil.success("success", num);
    }
    public ResultVO getProblemById(long id) {
        Problem problem = problemMapper.getProblemById(id);
        if(problem != null) {
            return ResultVOUtil.success("success", problem);
        }
        else {
            return ResultVOUtil.error("error", problem);
        }
    }
    public ResultVO getProblemList(int page, int pageSize) {
        int num = problemMapper.getNumberOfProblems();
        int maxPage = num / pageSize;
        if(num % pageSize != 0) {
            maxPage += 1;
        }

        if(page < 1 || page > maxPage) {
            page = 1;
        }
        List<Problem> list = problemMapper.getProblemList((page - 1) * pageSize, pageSize);
        ProblemListVO problemListVO = new ProblemListVO(list, num, page);
        return ResultVOUtil.success("success", problemListVO);
    }
    public ResultVO getProblemListByKeyWord(int page, int pageSize, String keyword) {
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
        ProblemListVO problemListVO = new ProblemListVO(retList, num, page);
        return ResultVOUtil.success("success", problemListVO);
    }
    public ResultVO deleteProblemById(long id) {
        int affect = problemMapper.deleteProblemById(id);
        if(affect == 1) {
            return ResultVOUtil.success("success");
        }
        else {
            return ResultVOUtil.error("error");
        }
    }
    public ResultVO createProblem(long problemId, String problemTitle, String problemDescription, String problemInputDescription,
                             String problemOutputDescription, String problemSamples, String problemTestcaseScore,
                             String problemHint, Date problemCreateTime, Date problemLastUpdate,
                             String problemCreateBy, int problemTimeLimit, int problemMemoryLimit,
                             long problemAC, long problemWA, String problemTestcaseId) {
        int affect = problemMapper.createProblem(problemId, problemTitle, problemDescription, problemInputDescription,
                problemOutputDescription, problemSamples, problemTestcaseScore,
                problemHint, problemCreateTime, problemLastUpdate,
                problemCreateBy, problemTimeLimit, problemMemoryLimit,
                problemAC, problemWA, problemTestcaseId);
        if(affect == 1) {
            return ResultVOUtil.success("success");
        }
        else {
            return ResultVOUtil.error("error");
        }
    }
    public ResultVO updateProblem(long problemId, String problemTitle, String problemDescription, String problemInputDescription,
                             String problemOutputDescription, String problemSamples, String problemTestcaseScore,
                             String problemHint, Date problemLastUpdate, int problemTimeLimit, int problemMemoryLimit, String problemTestcaseId) {
        int affect = problemMapper.updateProblem(problemId, problemTitle, problemDescription,
                problemInputDescription, problemOutputDescription, problemSamples,
                problemTestcaseScore, problemHint, problemLastUpdate, problemTimeLimit, problemMemoryLimit, problemTestcaseId);
        if(affect == 1) {
            return ResultVOUtil.success("success");
        }
        else {
            return ResultVOUtil.error("error");
        }
    }
}
