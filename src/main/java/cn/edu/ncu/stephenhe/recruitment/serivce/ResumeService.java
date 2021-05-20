package cn.edu.ncu.stephenhe.recruitment.serivce;

import cn.edu.ncu.stephenhe.recruitment.entity.Resume;

public interface ResumeService {

    Resume getResumeByUserId(int userId);

    Resume updateResume(Resume resume);

    Resume getResumeByResumeId(int resumeId);

    Resume getResumeByUserTel(String userTel);
}
