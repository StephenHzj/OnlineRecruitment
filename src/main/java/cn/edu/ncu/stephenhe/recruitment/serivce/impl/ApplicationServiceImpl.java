package cn.edu.ncu.stephenhe.recruitment.serivce.impl;

import cn.edu.ncu.stephenhe.recruitment.dao.ApplicationRepository;
import cn.edu.ncu.stephenhe.recruitment.dao.JobRepository;
import cn.edu.ncu.stephenhe.recruitment.dao.ResumeRepository;
import cn.edu.ncu.stephenhe.recruitment.dao.UserRepository;
import cn.edu.ncu.stephenhe.recruitment.dao.mapper.ApplicationMapper;
import cn.edu.ncu.stephenhe.recruitment.entity.Application;
import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import cn.edu.ncu.stephenhe.recruitment.serivce.ApplicationService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Resource
    ApplicationRepository applicationRepository;
    @Resource
    UserRepository userRepository;
    @Resource
    ResumeRepository resumeRepository;
    @Resource
    ApplicationMapper applicationMapper;
    @Resource
    JobRepository jobRepository;
    @Override
    public int appJob(String userTel, int jobId) {
        int userId = userRepository.getUserByUserTel(userTel).getUserId();
        if(resumeRepository.getResumeByUserId(userId) == null)
            return 0;
        Job job = jobRepository.getJobByJobId(jobId);
        int resumeId = resumeRepository.getResumeByUserId(userId).getResumeId();
        int dealHrId = job.getHrId();
        int companyId = job.getCompanyId();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String applicationDate = sdf.format(date);
        Application application = new Application();
        application.setJobId(jobId);
        application.setResumeId(resumeId);
        application.setUserId(userId);
        application.setDealHrId(dealHrId);
        application.setCompanyId(companyId);
        application.setApplicationDate(applicationDate);
        application.setApplicationState(0);
        applicationRepository.save(application);
        return 1;
    }

    @Override
    public List<Application> getApplicationByUserId(int userId) {
        return applicationMapper.getAppByUserId(userId);

    }

    @Override
    public List<Application> getApplicationByUserTel(String userTel) {
        int userId = userRepository.getUserByUserTel(userTel).getUserId();
        return applicationMapper.getAppByUserId(userId);
    }
}
