package com.sjtu.oj.web.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.sjtu.oj.web.util.ImageUpload;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/api/admin/")
@RestController
public class FileController {
    private static Logger logger = Logger.getLogger(FileController.class);
    @PostMapping(value = "/upload_image")
    public JSONObject imageUpload(@RequestParam(value="image", required=false) MultipartFile image) throws IOException {
        return ImageUpload.imageUpload(image);
    }
}
