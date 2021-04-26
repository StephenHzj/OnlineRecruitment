package cn.edu.ncu.stephenhe.recruitment.dao;

import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface JobRepository extends JpaRepository<Job,Integer> {
    Job getJobByJobId(int id);

    @Transactional
    void deleteJobByJobId(int id);
}
