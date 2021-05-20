package cn.edu.ncu.stephenhe.recruitment.dao.mapper;

import cn.edu.ncu.stephenhe.recruitment.entity.Application;

import java.util.List;

public interface ApplicationMapper {

    List<Application> getAppByUserId(int userId);
    List<Application> getAppByUserTel(String userTel);
}
