package cn.edu.ncu.stephenhe.recruitment.serivce.impl;


import cn.edu.ncu.stephenhe.recruitment.dao.*;
import cn.edu.ncu.stephenhe.recruitment.entity.Admin;
import cn.edu.ncu.stephenhe.recruitment.entity.Company;
import cn.edu.ncu.stephenhe.recruitment.entity.Job;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.AdminService;
import cn.edu.ncu.stephenhe.recruitment.utils.JwtUtil;
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
    public String loginAdmin(String tel, String password) {
        Admin admin =adminRepository.getAdminByAdminTel(tel);
        if(admin == null)
            return null;
        else if(admin.getAdminPassword().equals(password)){
            String token =  JwtUtil.createToken(admin);
            return token;
        }else
            return null;
    }



}
