package com.teeth.controller.upload;

import com.teeth.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/11 0011
 * Time:15:35
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadImageController {
    /**
     * 上传单个文件
     * @param request
     * @param file{
     *   "code": 0
     *   ,"msg": ""
     *   ,"data": {
     *     "src": "http://cdn.layui.com/123.jpg"
     *   }
     * }
     */
    @RequestMapping(value = "/uploadOne")
    @ResponseBody
    public Map<String,Object> uploadOne(
            HttpServletRequest request,
            @RequestParam("file") MultipartFile file) throws IOException {
        boolean b = Utils.uploadOneFile(request, file);
        Map<String,Object>map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        Map<String,Object>map1=new HashMap<>();
        if (b){
            String o = (String) request.getSession().getAttribute("imageUploadUrl");
            map1.put("src",o);
            map.put("data",map1);
        }
        return map;
    }

    /**
     * 上传多个文件
     * @param files
     * @param request
     */
    @RequestMapping(value = "/uploadMany")
    @ResponseBody
    public String uploadMany(
            @RequestParam("files") MultipartFile[] files,
            HttpServletRequest request){
        boolean b = Utils.uploadManyFiles(request, files);
        if (b) {
            String o = (String) request.getSession().getAttribute("imageUploadUrl");
            return "上传多个图片成功"+o;
        }
        return "图片上传失败";
    }
}
