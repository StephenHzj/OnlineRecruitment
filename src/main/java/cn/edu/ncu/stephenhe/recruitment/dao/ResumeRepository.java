package cn.edu.ncu.stephenhe.recruitment.dao;

import cn.edu.ncu.stephenhe.recruitment.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Integer>
{
}
