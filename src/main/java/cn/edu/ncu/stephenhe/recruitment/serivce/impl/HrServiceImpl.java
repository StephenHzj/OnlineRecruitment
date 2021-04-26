package cn.edu.ncu.stephenhe.recruitment.serivce.impl;

import cn.edu.ncu.stephenhe.recruitment.dao.HrRepository;
import cn.edu.ncu.stephenhe.recruitment.dao.mapper.HrMapper;
import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.serivce.HrService;
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
}
