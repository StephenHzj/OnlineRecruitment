package cn.edu.ncu.stephenhe.recruitment.serivce;

import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TestService {
    List<Hr> HrInfo();

    List<Hr> HrInfo2();
}
