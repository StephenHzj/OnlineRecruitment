package cn.edu.ncu.stephenhe.recruitment.controller;

import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.ApplicationService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@EnableAutoConfiguration
public class ApplicationController {

    @Resource
    ApplicationService applicationService;

    @PostMapping(value = "/app/job")
    public Result applicationJob(@RequestBody JSONObject jsonObject){
        String userTel = jsonObject.get("userTel").toString();
        int jobId = (int)jsonObject.get("jobId");

        int state = applicationService.appJob(userTel,jobId);
        if(state == 1)
            return new Result(200,"申请成功");
        else
            return new Result(503,"请先填写简历");

    }

    @GetMapping(value = "/{userTel}/show/app")
    public Result getAppList(@PathVariable String userTel){
        return new Result(200,"查询成功",applicationService.getApplicationByUserTel(userTel));
    }

}
