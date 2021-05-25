package cn.edu.ncu.stephenhe.recruitment.utils;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class UploadUtils {


//    String rootPathFront = "C:\\Users\\StephenHe\\Desktop\\front\\recruitment-front\\public\\img\\company\\";

    public String uploadFile(MultipartFile[] file,String rootPath){
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
                        String fileName = file[i].getOriginalFilename();
                        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
                        String uuidName = (UUID.randomUUID()+"."+fileType).replaceAll("-","");
                        String storagePath = rootPath+uuidName;
                        System.out.println(uuidName);
                        System.out.println("上传的文件：" + file[i].getName() + "," + file[i].getContentType() + "," + file[i].getOriginalFilename()
                                +"，保存的路径为：" + storagePath);
                        // 3种方法： 第1种
//                        Streams.copy(multipartFiles[i].getInputStream(), new FileOutputStream(storagePath), true);
                        // 第2种
//                        Path path = Paths.get(storagePath);
//                        Files.write(path,multipartFiles[i].getBytes());
                        // 第3种
                     //   file[i].transferTo(new File(storagePath));

                        //第4种
                        File Logo = new File(storagePath);
                        if (Logo.exists())
                        {
                            Logo.delete();
                        }
                        InputStream is = file[i].getInputStream();
                        FileOutputStream fos = new FileOutputStream(Logo);
                        int length;
                        byte[] bytes = new byte[1024*1024];
                        while ((length = is.read(bytes)) != -1)
                        {
                            fos.write(bytes, 0, length);
                        }
                        is.close();
                        fos.close();

                        return uuidName;
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

    public String uploadLogo(MultipartFile[] file,String rootPath,String tel){
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
                        String fileName = file[i].getOriginalFilename();
                        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);

                        String logoName = (tel+"."+fileType).replaceAll("-","");
                        String storagePath = rootPath+logoName;

                        System.out.println("上传的文件：" + file[i].getName() + "," + file[i].getContentType() + "," + file[i].getOriginalFilename()
                                +"，保存的路径为：" + storagePath);

                        File Logo = new File(storagePath);
                        if (Logo.exists())
                        {
                            Logo.delete();
                        }
                        InputStream is = file[i].getInputStream();
                        FileOutputStream fos = new FileOutputStream(Logo);
                        int length;
                        byte[] bytes = new byte[1024*1024];
                        while ((length = is.read(bytes)) != -1)
                        {
                            fos.write(bytes, 0, length);
                        }
                        is.close();
                        fos.close();

                        return logoName;
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
    public String uploadImg(MultipartFile[] files) {


        String rootPathFront = "C:\\Users\\StephenHe\\Desktop\\front\\recruitment-front\\public\\img\\company\\";
        for (MultipartFile file : files) {
            if (file.getSize() > 1024 * 1024)
                return "太大了";
            try {
                String name = "1.jpg";
                File file1 = new File(rootPathFront+name);
                if (file1.exists())
                {
                    file1.delete();
                }
                InputStream is = file.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                FileOutputStream fos = new FileOutputStream(file1);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                int length;
                byte[] bytes = new byte[1024];
                while ((length = bis.read(bytes)) != -1)
                {
                    bos.write(bytes, 0, length);
                }
                bos.flush();
                is.close();
                fos.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
}
