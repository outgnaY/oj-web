package com.sjtu.oj.web.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
@Mapper
public interface ProblemMapper {
    long getNumberOfProblems();
}
