package cn.edu.ncu.stephenhe.recruitment.serivce;

import cn.edu.ncu.stephenhe.recruitment.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> getAllJobs();

    Job getJobById(int id);

    List<Job> getJobList();

    boolean disableJob(int id);

    List<Job> showJob();

}
