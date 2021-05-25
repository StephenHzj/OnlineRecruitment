package cn.edu.ncu.stephenhe.recruitment.entity.ext;

import cn.edu.ncu.stephenhe.recruitment.entity.Application;
import lombok.Data;


@Data
public class AppJobHrCom extends Application {

    private String jobName;
    private String hrName;
    private String companyName;

}
