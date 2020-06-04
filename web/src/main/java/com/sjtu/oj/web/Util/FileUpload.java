package com.sjtu.oj.web.util;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.fastjson.JSONObject;
import com.sjtu.oj.web.model.TestcaseInfo;
import com.sjtu.oj.web.vo.TestcaseUploadVO;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FileUpload {
    private static Logger logger = Logger.getLogger(FileUpload.class);
    private static Properties properties = new Properties();
    static {
        InputStream in = FileUpload.class.getClassLoader().getResourceAsStream("storage.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void deleteFiles(File file) {
        if(file == null || !file.exists()) {
            return;
        }
        File[] files = file.listFiles();
        for(File f: files) {
            if(f.isDirectory()) {
                deleteFiles(f);
            }
            else {
                f.delete();
            }
        }
        file.delete();
    }

    // 上传可能对原有文件造成破坏
    public synchronized static TestcaseUploadVO testcaseUpload(MultipartFile file) {
        byte[] bytes = new byte[1024];
        InputStream is = null;
        FileOutputStream fos = null;
        String os = System.getProperty("os.name");
        String uploadDir = "";
        String fileName = file.getOriginalFilename();
        String suffix = (fileName.substring(fileName.lastIndexOf("."))).toLowerCase();
        ZipFile zip = null;
        String fullPath = "";
        File folder = null;
        boolean success = false;
        // 限制为zip格式
        if(!".zip".equals(suffix)) {
            return new TestcaseUploadVO(false, new ArrayList<>(), "必须为zip压缩文件", "");
        }

        try {
            is = file.getInputStream();
            // 先存到临时文件夹里，提交时转到正式文件夹
            if(os.toLowerCase().startsWith("win")) {
                uploadDir = properties.get("win.testcase_path").toString();
            }
            else {
                uploadDir = properties.get("unix.testcase_path").toString();
            }
            File dir = new File(uploadDir);
            if(!dir.exists()) {
                dir.mkdirs();
            }
            // zip文件
            fullPath = dir.getPath() + File.separator + file.getOriginalFilename();
            fos = new FileOutputStream(fullPath);
            int len;
            while((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            zip = new ZipFile(new File(fullPath), Charset.forName("GBK"));
            List<TestcaseInfo> list = new ArrayList<>();
            HashSet<String> set = new HashSet<>();
            boolean clean = false;
            // 随机生成ID
            String randomId = UUID.randomUUID().toString();
            folder = new File(dir.getPath() + File.separator + randomId);
            folder.mkdirs();

            for(Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zip.getInputStream(entry);
                String outPath = dir.getPath() + File.separator + randomId + File.separator + zipEntryName.substring(zipEntryName.indexOf('/') + 1);
                if(zipEntryName.substring(zipEntryName.indexOf('/') + 1).equals("")) {
                    continue;
                }
                set.add(zipEntryName.substring(zipEntryName.lastIndexOf('/') + 1, zipEntryName.length()));
                OutputStream out = new FileOutputStream(outPath);
                byte[] zipBuf = new byte[1024];
                while((len = in.read(zipBuf)) > 0) {
                    out.write(zipBuf, 0, len);
                }
                in.close();
                out.close();
            }
            // 检查格式是否正确，输入文件和输出文件必须一一对应，为，1.in,i.out...
            int size = set.size();
            if(size % 2 != 0) {
                return new TestcaseUploadVO(false, new ArrayList<>(), "上传文件格式错误", "");
            }
            for(int i = 1; i <= size / 2; i++) {
                if(!set.contains(i + ".in")) {
                    return new TestcaseUploadVO(false, new ArrayList<>(), "上传文件格式错误", "");
                }
                if(!set.contains(i + ".out")) {
                    return new TestcaseUploadVO(false, new ArrayList<>(), "上传文件格式错误", "");
                }
            }
            for(int i = 1; i <= size / 2; i++) {
                list.add(new TestcaseInfo(i + ".in", i + ".out", 100.0 / (size / 2)));
            }
            // System.out.println(randomId);
            success = true;
            return new TestcaseUploadVO(true, list, "上传成功", randomId);
        } catch(Exception e) {
            e.printStackTrace();
            return new TestcaseUploadVO(false, new ArrayList<>(), "上传文件出错", "");
        } finally {
            // System.out.println("finally");
            try {
                fos.close();
                is.close();
                if(zip != null) {
                    zip.close();
                }
                new File(fullPath).delete();
                if(!success) {
                    deleteFiles(folder);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized static JSONObject imageUpload(MultipartFile image) {
        JSONObject json = new JSONObject();
        String fileName = image.getOriginalFilename();
        String suffix = (fileName.substring(fileName.lastIndexOf("."))).toLowerCase();
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
                uploadDir = properties.get("unix.upload_path").toString();
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
