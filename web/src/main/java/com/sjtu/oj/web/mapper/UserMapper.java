package com.sjtu.oj.web.mapper;

import com.sjtu.oj.web.model.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
@Mapper
public interface UserMapper {
    User getUser(String username, String passwordMd5);
    User getUserByUsername(String username);
    int registerUser(String username, String passwordMd5, String email);
    int getExistByUsername(String username);
    int getExistByEmail(String email);
}
