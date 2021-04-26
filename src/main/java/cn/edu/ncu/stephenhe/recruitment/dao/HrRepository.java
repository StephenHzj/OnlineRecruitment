package cn.edu.ncu.stephenhe.recruitment.dao;

import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface HrRepository extends JpaRepository<Hr,Integer> {

    @Transactional
    void deleteHrByHrId(int id);

    Hr getHrByHrTel(String tel);



}
