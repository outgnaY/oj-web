package com.sjtu.oj.web.mapper;

import com.sjtu.oj.web.model.Problem;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
@Mapper
public interface ProblemMapper {
    int getNumberOfProblems();
    Problem getProblemById(long id);
    List<Problem> getProblemList(int currentIndex, int pageSize);
    List<Problem> getProblemListByKeyword(String keyword);
    int deleteProblemById(long id);
    int createProblem(long problemId, String problemTitle, String problemDescription, String problemInputDescription,
                      String problemOutputDescription, String problemSamples, String problemTestcaseScore,
                      String problemHint, Date problemCreateTime, Date problemLastUpdate,
                      String problemCreateBy, int problemTimeLimit, int problemMemoryLimit,
                      long problemAC, long problemTotal, String problemTestcaseId);
    int updateProblem(long problemId, String problemTitle, String problemDescription, String problemInputDescription,
                      String problemOutputDescription, String problemSamples, String problemTestcaseScore,
                      String problemHint, Date problemLastUpdate, int problemTimeLimit, int problemMemoryLimit, String problemTestcaseId);
}
