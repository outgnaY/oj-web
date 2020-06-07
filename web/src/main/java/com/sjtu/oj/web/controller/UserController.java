package com.sjtu.oj.web.controller;

import com.sjtu.oj.web.service.UserService;
import com.sjtu.oj.web.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/api/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("/login")
    public ResultVO login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        return userService.login(username, password, request);
    }
    @GetMapping("/get_user")
    public ResultVO getUser(HttpServletRequest request) {
        return userService.getUser(request);
    }
    @GetMapping("/logout")
    public ResultVO logout(HttpServletRequest request) {
        return userService.logout(request);
    }
    @GetMapping("/register")
    public ResultVO register(@RequestParam String username, @RequestParam String password, @RequestParam String email, HttpServletRequest request) {
        return userService.register(username, password, email, request);
    }
    @GetMapping("/check_user")
    public ResultVO checkUser(@RequestParam String username) {
        return userService.checkUser(username);
    }
    @GetMapping("/check_email")
    public ResultVO checkEmail(@RequestParam String email) {
        return userService.checkEmail(email);
    }
}
