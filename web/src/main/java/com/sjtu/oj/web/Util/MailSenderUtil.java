package com.sjtu.oj.web.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenderUtil {
    @Autowired
    JavaMailSender javaMailSender;
    public void test() {
        String code = "1234";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("标题");
        simpleMailMessage.setFrom("2296176046@qq.com");
        simpleMailMessage.setTo("wcy19961013@sjtu.edu.cn");
        simpleMailMessage.setText("这是你的验证码");
        javaMailSender.send(simpleMailMessage);
    }
}
