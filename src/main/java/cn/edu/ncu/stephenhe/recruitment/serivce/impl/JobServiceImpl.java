package cn.edu.ncu.stephenhe.recruitment.serivce.impl;

import cn.edu.ncu.stephenhe.recruitment.dao.JobRepository;
import cn.edu.ncu.stephenhe.recruitment.dao.mapper.JobMapper;
import cn.edu.ncu.stephenhe.recruitment.entity.Company;
import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import cn.edu.ncu.stephenhe.recruitment.serivce.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class JobServiceImpl implements JobService {

    @Resource
    private JobRepository jobRepository;
    @Resource
    private JobMapper jobMapper;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(int id) {
        return jobRepository.getJobByJobId(id);
    }

    @Override
    public List<Job> getJobsInfo() {
        return null;
    }

}
