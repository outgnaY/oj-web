package com.sjtu.oj.web.service;

import com.sjtu.oj.web.mapper.UserMapper;
import com.sjtu.oj.web.model.User;
import com.sjtu.oj.web.util.Constants;
import com.sjtu.oj.web.util.ResultVOUtil;
import com.sjtu.oj.web.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@Transactional
public class UserService {
    @Resource
    private UserMapper userMapper;
    public ResultVO checkUser(String username) {
        int exist = userMapper.getExistByUsername(username);
        if(exist == 0) {
            return ResultVOUtil.success("success", false);
        }
        else {
            return ResultVOUtil.success("success", true);
        }
    }
    public ResultVO checkEmail(String email) {
        int exist = userMapper.getExistByEmail(email);
        if(exist == 0) {
            return ResultVOUtil.success("success", false);
        }
        else {
            return ResultVOUtil.success("success", true);
        }
    }
    public ResultVO getUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        // 判断session是否过期
        if(session == null) {
            return ResultVOUtil.error(Constants.ERROR_CODE_AUTH, "error");
        }
        String username = session.getAttribute(Constants.SESSION_USERNAME).toString();
        User user = userMapper.getUserByUsername(username);
        if(user == null) {
            request.getSession().setMaxInactiveInterval(Constants.SESSION_MAX_INACTIVE_INTERVAL);
            return ResultVOUtil.error(Constants.ERROR_CODE_AUTH, "user not found");
        }
        else {
            request.getSession().setMaxInactiveInterval(Constants.SESSION_MAX_INACTIVE_INTERVAL);
            return ResultVOUtil.success("success", user);
        }
    }
    public ResultVO logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        // 判断session是否过期
        if(session == null) {
            return ResultVOUtil.error(Constants.ERROR_CODE_AUTH, "error");
        }
        session.invalidate();
        return ResultVOUtil.success("success");
    }
    public ResultVO register(String username, String password, String email, HttpServletRequest request) {

        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        int affect = userMapper.registerUser(username, passwordMd5, email);
        if(affect == 1) {
            // 暂时不建立新session，让用户登录
            return ResultVOUtil.success("register success");
        }
        else {
            return ResultVOUtil.error("register error");
        }
    }
    public ResultVO login(String username, String password, HttpServletRequest request) {
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = userMapper.getUser(username, passwordMd5);
        if(user == null) {
            return ResultVOUtil.error(Constants.ERROR_CODE_AUTH, "login error");
        }
        else {
            HttpSession session = request.getSession(false);
            if(session == null) {
                session = request.getSession();
                session.setAttribute(Constants.SESSION_USERNAME, user.getUsername());
                session.setAttribute(Constants.SESSION_USER_AUTH, user.getUserType());
                session.setMaxInactiveInterval(Constants.SESSION_MAX_INACTIVE_INTERVAL);
            }
            else {
                System.out.println(session.getId());
                session.invalidate();
                HttpSession newSession = request.getSession(true);
                newSession.setAttribute(Constants.SESSION_USERNAME, user.getUsername());
                newSession.setAttribute(Constants.SESSION_USER_AUTH, user.getUserType());
                newSession.setMaxInactiveInterval(Constants.SESSION_MAX_INACTIVE_INTERVAL);
            }
            return ResultVOUtil.success("login success");
        }
    }

}
