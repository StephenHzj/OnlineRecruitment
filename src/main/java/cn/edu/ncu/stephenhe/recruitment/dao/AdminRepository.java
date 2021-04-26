package cn.edu.ncu.stephenhe.recruitment.dao;

import cn.edu.ncu.stephenhe.recruitment.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.management.jdp.JdpPacket;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin getAdminByAdminTel(String tel);
}
