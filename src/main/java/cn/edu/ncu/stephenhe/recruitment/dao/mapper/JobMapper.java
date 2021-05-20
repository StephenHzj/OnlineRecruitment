package cn.edu.ncu.stephenhe.recruitment.dao.mapper;

import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface JobMapper {
    List<Job> getJobsInfo();

    List<Job> showJob();

    Job getJobDetail(int jobId);
}
