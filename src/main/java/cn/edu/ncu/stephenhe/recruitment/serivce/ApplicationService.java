package cn.edu.ncu.stephenhe.recruitment.serivce;

import cn.edu.ncu.stephenhe.recruitment.entity.Application;
import cn.edu.ncu.stephenhe.recruitment.entity.Job;

import java.util.List;

public interface ApplicationService {
    int appJob(String userTel, int jobId);

    List<Application> getApplicationByUserId(int userId);
    List<Application> getApplicationByUserTel(String userTel);
}
