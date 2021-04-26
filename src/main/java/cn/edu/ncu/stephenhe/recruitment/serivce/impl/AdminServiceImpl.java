package cn.edu.ncu.stephenhe.recruitment.serivce.impl;


import cn.edu.ncu.stephenhe.recruitment.dao.*;
import cn.edu.ncu.stephenhe.recruitment.entity.Admin;
import cn.edu.ncu.stephenhe.recruitment.entity.Company;
import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.AdminService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;

@Service
public class AdminServiceImpl implements AdminService {


    @Resource
    HrRepository hrRepository;

    @Resource
    UserRepository userRepository;

    @Resource
    AdminRepository adminRepository;

    @Resource
    JobRepository jobRepository;
    @Resource
    CompanyRepository companyRepository;

    @Override
    public int deleteHrById(int id) {
         hrRepository.deleteHrByHrId(id);
         return 1;
    }

    @Override
    public int deleteUserById(int id) {
        userRepository.deleteUserByUserId(id);
        return 1;
    }

    @Override
    public int deleteJobById(int id) {
        try {
            jobRepository.deleteJobByJobId(id);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }


    @Override
    public int auditCompany(String companyCode) {
        Company company = companyRepository.getCompanyByCompanyCode(companyCode);

        //companyCode错误，公司不存在
        if (company == null)
            return -1;

        //通过审核
        if (company.getCompanyState() == 0) {
            company.setCompanyState(1);
            companyRepository.save(company);
            return 1;
        }
        //取消权限
        if (company.getCompanyState() == 1){
            company.setCompanyState(0);
            companyRepository.save(company);
            return 0;
        }
        //未知错误
        return -2;
    }

    //未处理空指针异常
    @Override
    public int auditJob(int id) {
        Job job = jobRepository.getJobByJobId(id);

        //通过审核
        if (job.getJobState() == 0) {
            job.setJobState(1);
            jobRepository.save(job);
            return 1;
        }
        //取消权限
        if (job.getJobState() == 1){
            job.setJobState(0);
            jobRepository.save(job);
            return 0;
        }
        //未知错误
        return -2;
    }



    @Override
    public Page<Company> getCompanyPage(Integer page) {
        if(page == null){
            page = 0;
        }
        PageRequest pageable = PageRequest.of(page, 2);
        Page<Company> companies = companyRepository.findAll(pageable);
        return companies;
    }

    @Override
    public Admin getAdminByTel(String tel) {
        return adminRepository.getAdminByAdminTel(tel);
    }

    @Override
    public boolean loginAdmin(String tel, String password) {
        Admin admin = adminRepository.getAdminByAdminTel(tel);
        if(admin == null)
            return false;
        if(admin.getAdminPassword().equals(password))
            return true;
        else
            return false;
    }



}