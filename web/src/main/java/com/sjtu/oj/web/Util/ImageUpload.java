package com.sjtu.oj.web.util;

import com.alibaba.fastjson.JSONObject;
import com.sjtu.oj.web.config.MvcConfig;
import com.sjtu.oj.web.controller.admin.FileController;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.Properties;
import java.util.UUID;

public class ImageUpload {
    private static Logger logger = Logger.getLogger(ImageUpload.class);
    private static Properties properties = new Properties();
    static {
        InputStream in = ImageUpload.class.getClassLoader().getResourceAsStream("storage.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject imageUpload(MultipartFile image) {
        JSONObject json = new JSONObject();
        // System.out.println(image.getOriginalFilename());
        String fileName = image.getOriginalFilename();
        // assert fileName != null;
        String suffix = (fileName.substring(fileName.lastIndexOf("."))).toLowerCase();
        // System.out.println(suffix);
        // 判断后缀名是否合法
        if(!".jpg".equals(suffix) && !".png".equals(suffix) && !".jpeg".equals(suffix) && !".gif".equals(suffix) && !".bmp".equals(suffix)) {
            json.put("success", false);
            json.put("msg", "文件格式不支持");
            return json;
        }
        if(image.getSize() > 2 * 1024 * 1024) {
            json.put("success", false);
            json.put("msg", "文件太大，请选择小于2MB的图片");
        }
        String fileLocalName = UUID.randomUUID() + suffix;
        logger.log(Level.INFO, "fileLocalName = " + fileLocalName);
        String os = System.getProperty("os.name");
        String uploadDir = "";
        InputStream is = null;
        FileOutputStream fos = null;
        byte[] bytes = new byte[1024];
        try {
            is = image.getInputStream();
            if(os.toLowerCase().startsWith("win")) {
                logger.log(Level.INFO, properties.get("win.upload_path"));
                uploadDir = properties.get("win.upload_path").toString();
            }
            else {
                uploadDir = properties.get("unix.upload_location").toString();
            }
            File dir = new File(uploadDir);
            if(!dir.exists()) {
                dir.mkdirs();
            }
            String fullPath = dir.getPath() + File.separator + fileLocalName;
            logger.log(Level.INFO, "fullPath = " + fullPath);
            fos = new FileOutputStream(fullPath);
            int len;
            while((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            json.put("success", true);
            json.put("file_path", "/static/upload/" + fileLocalName);
            return json;
        } catch(IOException e) {
            e.printStackTrace();
            json.put("success", false);
            json.put("msg", "文件上传失败");
            return json;
        } finally {
            try {
                fos.close();
                is.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
