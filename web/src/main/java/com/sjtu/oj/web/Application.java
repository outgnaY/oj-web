package com.sjtu.oj.web;

import com.sjtu.oj.web.mapper.ProblemMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.Resource;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.sjtu.oj.web.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }





}