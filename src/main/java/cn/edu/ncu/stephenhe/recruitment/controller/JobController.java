package cn.edu.ncu.stephenhe.recruitment.controller;


import cn.edu.ncu.stephenhe.recruitment.dao.mapper.JobMapper;
import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.JobService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class JobController {

    @Resource
    private JobService jobService;

    @Resource
    private JobMapper jobMapper;

    @GetMapping(path = "/job/showAll")
    @ResponseBody
    public List<Job> getAllJob(){
        return jobService.getAllJobs();
    }

    @GetMapping(path = "/job/{id}")
    @ResponseBody
    public Result getJobById(@PathVariable int id){
//        Job job = jobService.getJobById(id);
        Job job = jobMapper.getJobDetail(id);
        if(job == null)
            return new Result(503,"查询出错");
        else
            return new Result(200,"查询成功",job);
    }

    @GetMapping("/jobs")
    public Result showJob(){

        return new Result(200,"查询成功",jobService.showJob());
    }



}
