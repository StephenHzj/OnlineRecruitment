package cn.edu.ncu.stephenhe.recruitment;

import cn.edu.ncu.stephenhe.recruitment.dao.mapper.JobMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class RecruitmentApplicationTests {

    @Autowired
    JobMapper jobMapper;

    @Test
    void contextLoads() {
//        List<CompleteJobInfo> jobsInfo = jobMapper.getJobsInfo();
//
//        System.out.println(jobsInfo);
    }

}
