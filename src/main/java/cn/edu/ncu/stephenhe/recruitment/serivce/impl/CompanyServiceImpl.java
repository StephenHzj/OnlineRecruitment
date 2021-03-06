package cn.edu.ncu.stephenhe.recruitment.serivce.impl;

import cn.edu.ncu.stephenhe.recruitment.dao.CompanyRepository;
import cn.edu.ncu.stephenhe.recruitment.entity.Company;
import cn.edu.ncu.stephenhe.recruitment.serivce.CompanyService;
import cn.edu.ncu.stephenhe.recruitment.utils.UploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    CompanyRepository companyRepository;

    @Override
    public List<Company> getNotAuditCompany() {
        int state = 0; //未审核状态
        return companyRepository.getCompanyByCompanyStateEquals(state);
    }

    @Override
    public Company getCompanyByCompanyCode(String code) {
        return companyRepository.getCompanyByCompanyCode(code);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> getCompaniesByCompanyId(List<Integer> code) {
        return companyRepository.getCompanyByCompanyIdIn(code);
    }

    @Override
    public Company getCompanyByCompanyId(int id) {
        return companyRepository.getCompanyByCompanyId(id);
    }

    @Override
    public Company registerCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public String uploadCompanyLogo(MultipartFile[] files, String path) {
        UploadUtils uploadUtils = new UploadUtils();
        return uploadUtils.uploadFile(files,path) ;
    }

    @Override
    public boolean auditCompany(String companyCode) {
        Company company = companyRepository.getCompanyByCompanyCode(companyCode);

        //companyCode错误，公司不存在
        if (company == null)
            return false;

        //通过审核
        if (company.getCompanyState() == 0) {
            company.setCompanyState(1);
            companyRepository.save(company);
            return true;
        }
        //取消权限
        if (company.getCompanyState() == 1){
            company.setCompanyState(0);
            companyRepository.save(company);
            return true;
        }
        //未知错误
        return false;
    }



}
