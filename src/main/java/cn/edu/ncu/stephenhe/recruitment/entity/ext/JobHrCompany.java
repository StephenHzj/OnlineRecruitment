package cn.edu.ncu.stephenhe.recruitment.entity.ext;

import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class JobHrCompany extends Job {

    private String hrName;
    private String companyName;
}
