package com.sjtu.oj.web.mapper;

import com.sjtu.oj.web.model.Problem;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
@Mapper
public interface ProblemMapper {
    int getNumberOfProblems();
    Problem getProblemById(long id);
    List<Problem> getProblemList(int currentIndex, int pageSize);
    List<Problem> getProblemListByKeyword(String keyword);
}
