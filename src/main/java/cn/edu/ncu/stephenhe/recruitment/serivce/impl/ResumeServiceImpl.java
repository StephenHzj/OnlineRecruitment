package cn.edu.ncu.stephenhe.recruitment.serivce.impl;

import cn.edu.ncu.stephenhe.recruitment.dao.ResumeRepository;
import cn.edu.ncu.stephenhe.recruitment.dao.UserRepository;
import cn.edu.ncu.stephenhe.recruitment.entity.Resume;
import cn.edu.ncu.stephenhe.recruitment.serivce.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Resource
    ResumeRepository resumeRepository;

    @Resource
    UserRepository userRepository;

    @Override
    public Resume getResumeByUserId(int userId) {
        return resumeRepository.getResumeByUserId(userId);
    }

    @Override
    public Resume updateResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    @Override
    public Resume getResumeByResumeId(int resumeId) {
        return resumeRepository.getResumeByResumeId(resumeId);
    }

    @Override
    public Resume getResumeByUserTel(String userTel) {
        int userId = userRepository.getUserByUserTel(userTel).getUserId();

        return resumeRepository.getResumeByUserId(userId);
    }
}
