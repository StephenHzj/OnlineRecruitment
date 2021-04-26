package cn.edu.ncu.stephenhe.recruitment.serivce.impl;

import cn.edu.ncu.stephenhe.recruitment.dao.mapper.HrMapper;
import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.serivce.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    HrMapper hrMapper;


    @Override
    public List<Hr> HrInfo() {
        return hrMapper.getHrsInfo();
    }

    @Override
    public List<Hr> HrInfo2() {
        return hrMapper.getHrsInfo();
    }
}
