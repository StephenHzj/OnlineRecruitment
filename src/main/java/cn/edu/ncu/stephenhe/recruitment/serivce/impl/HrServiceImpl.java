package cn.edu.ncu.stephenhe.recruitment.serivce.impl;

import cn.edu.ncu.stephenhe.recruitment.dao.HrRepository;
import cn.edu.ncu.stephenhe.recruitment.dao.mapper.HrMapper;
import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.serivce.HrService;
import cn.edu.ncu.stephenhe.recruitment.utils.JwtUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HrServiceImpl implements HrService {

    @Resource
    HrRepository hrRepository;

    @Resource
    HrMapper hrMapper;


    @Override
    public List<Hr> getAllHrs() {
        return hrRepository.findAll();
    }

    @Override
    public List<Hr> getHrsInfo() {
        return hrMapper.getHrsInfo();
    }

    @Override
    public Hr getHrByTel(String tel) {
        return hrRepository.getHrByHrTel(tel);
    }

    @Override
    public Hr registerHr(Hr hr) {
        return hrRepository.save(hr);
    }

    @Override
    public Hr registerHr(String tel, String name, String password, String email) {
        Hr hr = new Hr();
        hr.setHrTel(tel);
        hr.setHrName(name);
        hr.setHrPassword(password);
        hr.setHrEmail(email);
        hr.setCompanyId(0);
        return hrRepository.save(hr);
    }


    @Override
    public String loginHr(String tel, String password) {

        Hr hr = hrRepository.getHrByHrTel(tel);
        if(hr == null)
            return null;
        else if(hr.getHrPassword().equals(password)){
            String token =  JwtUtil.createToken(hr);
            return token;
        }else
            return null;
    }
}
