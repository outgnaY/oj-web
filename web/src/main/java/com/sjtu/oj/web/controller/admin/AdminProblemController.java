package com.sjtu.oj.web.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.sjtu.oj.web.model.Problem;
import com.sjtu.oj.web.model.TestcaseInfo;
import com.sjtu.oj.web.service.ProblemService;
import com.sjtu.oj.web.util.FileUpload;
import com.sjtu.oj.web.util.ResultVOUtil;
import com.sjtu.oj.web.vo.ProblemListVO;
import com.sjtu.oj.web.vo.ResultVO;
import com.sjtu.oj.web.vo.TestcaseUploadVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/api/admin/problem")
@RestController
public class AdminProblemController {
    @Resource
    private ProblemService problemService;
    @GetMapping("/get_by_id")
    public ResultVO getProblemById(@RequestParam long id) {
        return problemService.getProblemById(id);
    }
    @GetMapping("/get_page")
    public ResultVO getProblemList(@RequestParam int page, @RequestParam int pageSize) {
        return problemService.getProblemList(page, pageSize);
    }
    @GetMapping("/get_page_by_keyword")
    public ResultVO getProblemListByKeyword(@RequestParam int page, @RequestParam int pageSize, @RequestParam String keyword) {
        return problemService.getProblemListByKeyWord(page, pageSize, keyword);
    }
    @GetMapping("/del_by_id")
    public ResultVO deleteProblemById(@RequestParam long id) {
        // TODO 关联删除
        return problemService.deleteProblemById(id);
    }
    @PostMapping("/testcase")
    public ResultVO uploadTestcase(@RequestParam(required=true) MultipartFile file) {
        // System.out.println(id);
        TestcaseUploadVO testcaseUploadVO = FileUpload.testcaseUpload(file);
        if(testcaseUploadVO.isSuccess()) {
            return ResultVOUtil.success("success", testcaseUploadVO);
        }
        else {
            return ResultVOUtil.error("error", testcaseUploadVO);
        }
    }
    @PostMapping("/create")
    public ResultVO createProblem(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        long problemId = jsonObject.getLongValue("problemId");
        String problemTitle = jsonObject.getString("problemTitle");
        String problemDescription = jsonObject.getString("problemDescription");
        String problemInputDescription = jsonObject.getString("problemInputDescription");
        String problemOutputDescription = jsonObject.getString("problemOutputDescription");
        String problemSamples = jsonObject.getString("problemSamples");
        String problemTestcaseScore = jsonObject.getString("problemTestcaseScore");
        String problemHint = jsonObject.getString("problemHint");
        Date problemLastUpdate = jsonObject.getDate("problemLastUpdate");
        Date problemCreateTime = jsonObject.getDate("problemCreateTime");
        String problemCreateBy = jsonObject.getString("problemCreateBy");
        int problemTimeLimit = jsonObject.getIntValue("problemTimeLimit");
        int problemMemoryLimit = jsonObject.getIntValue("problemMemoryLimit");
        String problemTestcaseId = jsonObject.getString("problemTestcaseId");
        System.out.println(problemTestcaseId);
        return problemService.createProblem(problemId, problemTitle, problemDescription, problemInputDescription,
                problemOutputDescription, problemSamples, problemTestcaseScore,
                problemHint, problemCreateTime, problemLastUpdate,
                problemCreateBy, problemTimeLimit, problemMemoryLimit,
                0, 0, problemTestcaseId);
    }
    @PostMapping("/update")
    public ResultVO updateProblem(@RequestBody String json) {
        // System.out.println(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        long problemId = jsonObject.getLongValue("problemId");
        String problemTitle = jsonObject.getString("problemTitle");
        String problemDescription = jsonObject.getString("problemDescription");
        String problemInputDescription = jsonObject.getString("problemInputDescription");
        String problemOutputDescription = jsonObject.getString("problemOutputDescription");
        String problemSamples = jsonObject.getString("problemSamples");
        String problemTestcaseScore = jsonObject.getString("problemTestcaseScore");
        String problemHint = jsonObject.getString("problemHint");
        Date problemLastUpdate = jsonObject.getDate("problemLastUpdate");
        int problemTimeLimit = jsonObject.getIntValue("problemTimeLimit");
        int problemMemoryLimit = jsonObject.getIntValue("problemMemoryLimit");
        String problemTestcaseId = jsonObject.getString("problemTestcaseId");
        System.out.println(problemTestcaseId);
        return problemService.updateProblem(problemId, problemTitle, problemDescription,
                problemInputDescription, problemOutputDescription, problemSamples,
                problemTestcaseScore, problemHint, problemLastUpdate, problemTimeLimit, problemMemoryLimit, problemTestcaseId);
    }
}
