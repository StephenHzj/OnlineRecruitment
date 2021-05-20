package cn.edu.ncu.stephenhe.recruitment.entity.ext;

import cn.edu.ncu.stephenhe.recruitment.entity.Company;
import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import lombok.Data;

@Data
public class JobDetail extends Job {
    private Company company;
    private Hr hr;
}
