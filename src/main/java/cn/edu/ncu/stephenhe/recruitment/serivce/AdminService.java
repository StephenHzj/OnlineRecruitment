package cn.edu.ncu.stephenhe.recruitment.serivce;

import cn.edu.ncu.stephenhe.recruitment.entity.Admin;
import cn.edu.ncu.stephenhe.recruitment.entity.Company;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface AdminService {

    int deleteHrById(int id);

    int deleteUserById(int id);

    int deleteJobById(int id);

    int auditCompany(String companyCode);

    int auditJob(int id);



    Page<Company> getCompanyPage(Integer page) ;

    Admin getAdminByTel(String tel);

    boolean loginAdmin(String tel,String password);

}
