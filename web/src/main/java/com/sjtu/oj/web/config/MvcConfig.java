package com.sjtu.oj.web.config;

import com.sjtu.oj.web.controller.admin.FileController;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// 静态资源映射
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    private static Logger logger = Logger.getLogger(MvcConfig.class);
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Properties properties = new Properties();
        InputStream in = MvcConfig.class.getClassLoader().getResourceAsStream("storage.properties");
        try {
            properties.load(in);
            String os = System.getProperty("os.name");
            logger.log(Level.INFO, "os = " + os);
            // logger.log(Level.INFO, properties.get("win.handler"));
            if(os.toLowerCase().startsWith("win")) {
                // String winUploadHandler = properties.get("win.handler").toString();
                String winUploadLocation =properties.get("win.upload_location").toString();
                registry.addResourceHandler("static/upload/**").addResourceLocations(winUploadLocation);
                registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
                super.addResourceHandlers(registry);
            }
            else {
                // String unixUploadHandler = properties.get("unix.handler").toString();
                String unixUploadLocation =properties.get("unix.upload_location").toString();
                registry.addResourceHandler("static/upload/**").addResourceLocations(unixUploadLocation);
                registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
                super.addResourceHandlers(registry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
