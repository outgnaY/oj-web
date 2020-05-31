package com.sjtu.oj.web.mapper;

import com.sjtu.oj.web.model.WebsiteConfig;
import org.apache.ibatis.annotations.CacheNamespace;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
public interface WebsiteConfigMapper {
    WebsiteConfig getWebsiteConfig();
}
