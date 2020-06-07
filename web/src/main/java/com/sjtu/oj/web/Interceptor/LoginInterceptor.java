package com.sjtu.oj.web.Interceptor;

import com.alibaba.fastjson.JSON;
import com.sjtu.oj.web.util.Constants;
import com.sjtu.oj.web.util.ResultVOUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Optional;

public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUrl = request.getRequestURL().toString();
        logger.log(Level.INFO, requestUrl);
        HttpSession session = request.getSession(false);
        if(session == null) {
            // logger.log(Level.INFO, "session = " + session);
            // response.sendError(response.SC_OK);
            PrintWriter out = response.getWriter();
            out.print(JSON.toJSONString(ResultVOUtil.error("please login")));
            out.flush();
            // System.out.println(JSON.toJSONString(ResultVOUtil.error("error")));
            return false;
        }
        logger.log(Level.INFO, "sessionId = " + session.getId());

        Optional<Object> token = Optional.ofNullable(session.getAttribute(Constants.SESSION_USERNAME));
        if(token.isPresent()) {
            logger.log(Level.INFO, "token验证通过");
            // 权限验证
            if(requestUrl.contains("/admin")) {
                if(!session.getAttribute(Constants.SESSION_USER_AUTH).equals("ADMIN")) {
                    // 无权限
                    // response.sendError(response.SC_OK);
                    PrintWriter out = response.getWriter();
                    out.print(JSON.toJSONString(ResultVOUtil.error("please login")));
                    out.flush();
                    // System.out.println(JSON.toJSONString(ResultVOUtil.error("error")));
                    return false;
                }
            }
            session.setMaxInactiveInterval(60);
            return true;
        }
        else {
            logger.log(Level.INFO, "token验证失败，请登录");
            // response.sendError(response.SC_OK);
            PrintWriter out = response.getWriter();
            out.print(JSON.toJSONString(ResultVOUtil.error("please login")));
            out.flush();
            // System.out.println(JSON.toJSONString(ResultVOUtil.error("error")));
            return false;
        }

    }
}
