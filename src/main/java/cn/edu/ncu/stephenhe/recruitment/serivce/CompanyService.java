package cn.edu.ncu.stephenhe.recruitment.serivce;

import cn.edu.ncu.stephenhe.recruitment.entity.Company;
import org.springframework.web.multipart.MultipartFile;

import java.util.ConcurrentModificationException;
import java.util.List;

public interface CompanyService {
    List<Company> getNotAuditCompany();

    Company getCompanyByCompanyCode(String code);

    List<Company> getAllCompanies();

    List<Company> getCompaniesByCompanyId(List<Integer> code);

    Company getCompanyByCompanyId(int id);

    Company registerCompany(Company company);

    String uploadCompanyLogo(MultipartFile[] files,String path);
}
