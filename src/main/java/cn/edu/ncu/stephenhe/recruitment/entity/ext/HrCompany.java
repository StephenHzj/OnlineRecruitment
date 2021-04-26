package cn.edu.ncu.stephenhe.recruitment.entity.ext;

import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HrCompany extends Hr {
    private String companyName;
}
