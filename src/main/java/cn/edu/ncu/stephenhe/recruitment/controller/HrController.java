package cn.edu.ncu.stephenhe.recruitment.controller;

import cn.edu.ncu.stephenhe.recruitment.entity.Company;
import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.serivce.CompanyService;
import cn.edu.ncu.stephenhe.recruitment.serivce.HrService;
import cn.edu.ncu.stephenhe.recruitment.utils.UploadUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController
public class HrController {

    @Resource
    HrService hrService;
    @Resource
    CompanyService companyService;


    /**
     * @param hr
     * @return 注册 成功->1 失败->0
     */
    @Operation(summary = "HR注册")
    @PostMapping(value = "/hr/register")
    public String hrRegister(@RequestBody Hr hr) {


        //验证tel,password,username是否为空
        if (hr.getHrTel() == null || hr.getHrPassword() == null || hr.getHrName() == null) {
            return "0";
        }

        //验证tel是否重复
        if (hrService.getHrByTel(hr.getHrTel()) != null) {
            return "账号已存在，请勿重复注册";
        }

        if (hrService.registerHr(hr) != null)
            return "注册成功";
        else
            return "注册失败";
    }


    @PostMapping(value = "/hr/upload")
    @ResponseBody
    public String uploadHrLogo(@RequestParam("file") MultipartFile[] file) {

        String rootPath = "C:\\Users\\StephenHe\\IdeaProjects\\recruitment\\src\\main\\resources\\img\\hr\\";
        UploadUtils uploadUtils = new UploadUtils();

        String message = uploadUtils.uploadFile(file, rootPath);
        return message;

    }

    @GetMapping("/hr/{tel}")
    public Hr getHrByTel(@PathVariable String tel){

        return hrService.getHrByTel(tel);
    }
}
