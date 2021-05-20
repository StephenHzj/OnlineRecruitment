package cn.edu.ncu.stephenhe.recruitment.controller;

import cn.edu.ncu.stephenhe.recruitment.entity.Resume;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.ResumeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @Operation(summary = "创建简历")
    @PostMapping("/resume/create")
    public Result createResume(@RequestBody Resume resume){
        return new Result(200,"创建成功",resumeService.updateResume(resume));
    }

    @Operation(summary = "更新简历")
    @PostMapping("/resume/update")
    public Result updateResume(@RequestBody Resume resume){
        return new Result(200,"更新成功",resumeService.updateResume(resume));
    }

    @Operation(summary = "获取简历(id)")
    @GetMapping("/resume/{resumeId}")
    public Result getResume(@PathVariable int resumeId){
        return new Result(200,"查询成功",resumeService.getResumeByResumeId(resumeId));
    }

    @Operation(summary = "获取简历(Tel)")
    @GetMapping("/user/{userTel}/resume")
    public Result getResume(@PathVariable String userTel){
        return new Result(200,"查询成功",resumeService.getResumeByUserTel(userTel));
    }
}
