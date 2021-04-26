package cn.edu.ncu.stephenhe.recruitment.dao;

import cn.edu.ncu.stephenhe.recruitment.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    List<Company> getCompanyByCompanyStateEquals(int state);

    Company getCompanyByCompanyCode(String code);

    List<Company> getCompanyByCompanyIdIn(List<Integer> code);

    Company getCompanyByCompanyId(int id);
}
