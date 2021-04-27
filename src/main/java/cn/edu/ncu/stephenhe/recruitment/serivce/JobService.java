package cn.edu.ncu.stephenhe.recruitment.serivce;

import cn.edu.ncu.stephenhe.recruitment.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> getAllJobs();

    Job getJobById(int id);

    List<Job> getJobsInfo();

    boolean disableJob(int id);

}
