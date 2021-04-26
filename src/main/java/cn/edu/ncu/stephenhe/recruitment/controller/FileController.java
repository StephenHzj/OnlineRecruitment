package cn.edu.ncu.stephenhe.recruitment.controller;

import com.sun.imageio.plugins.common.ImageUtil;
import io.swagger.annotations.ApiOperation;
import nonapi.io.github.classgraph.utils.FileUtils;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class FileController {

    // 上传图片更路径
    private  final static String rootPath = "C:\\Users\\StephenHe\\IdeaProjects\\recruitment\\src\\main\\resources\\img\\";

    @PostMapping(value = "/user/upload")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile[] file){
        File fileDir = new File(rootPath);
        //文件夹不存在 则创建文件夹
        if (!fileDir.exists() && !fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        try {
            if (file != null && file.length > 0) {
                for(int i = 0;i<file.length;i++){
                    try {
                        //以原来的名称命名,覆盖掉旧的，这里也可以使用UUID之类的方式命名，这里就没有处理了
                        String storagePath = rootPath+file[i].getOriginalFilename();
                        String fileName = file[i].getOriginalFilename();
                        String exts = fileName.substring(fileName.lastIndexOf(".") + 1);
                        String uuid = (UUID.randomUUID()+"."+exts).replaceAll("-","");
                        System.out.println(uuid);
                        System.out.println("上传的文件：" + file[i].getName() + "," + file[i].getContentType() + "," + file[i].getOriginalFilename()
                                +"，保存的路径为：" + storagePath);
                        // 3种方法： 第1种
//                        Streams.copy(file[i].getInputStream(), new FileOutputStream(storagePath), true);
                        // 第2种
//                        Path path = Paths.get(storagePath);
//                        Files.write(path,file[i].getBytes());
                        // 第3种
                        file[i].transferTo(new File(storagePath));

                        return uuid;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //前端可以通过状态码，判断文件是否上传成功
        return "error";
    }

}
