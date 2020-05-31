package com.sjtu.oj.web.mapper;
import com.sjtu.oj.web.model.LanguageInformation;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
public interface LanguageInformationMapper {
    List<LanguageInformation> getLanguageInformations();
}
