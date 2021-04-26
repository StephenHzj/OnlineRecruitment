package cn.edu.ncu.stephenhe.recruitment.dao.mapper;

import cn.edu.ncu.stephenhe.recruitment.entity.ext.CompleteJobInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface JobMapper {
    List<CompleteJobInfo> getJobsInfo();
}
