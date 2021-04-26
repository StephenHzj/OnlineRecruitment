package cn.edu.ncu.stephenhe.recruitment.serivce;

import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HrService {
    List<Hr> getAllHrs();

    List<Hr> getHrsInfo();

    Hr getHrByTel(String tel);

    Hr registerHr(Hr hr);
}
