package cn.edu.ncu.stephenhe.recruitment.controller;


import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import cn.edu.ncu.stephenhe.recruitment.serivce.JobService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class JobController {

    @Resource
    private JobService jobService;

    @GetMapping(path = "/job/showAll")
    @ResponseBody
    public List<Job> getAllJob(){
        return jobService.getAllJobs();
    }

    @GetMapping(path = "/job/{id}")
    @ResponseBody
    public Job getJobById(@PathVariable int id){
        if(jobService.getJobById(id)==null)
            return new Job();
        else
            return jobService.getJobById(id);

    }


}
