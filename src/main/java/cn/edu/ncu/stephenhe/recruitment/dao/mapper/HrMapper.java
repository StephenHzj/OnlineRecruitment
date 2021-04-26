package cn.edu.ncu.stephenhe.recruitment.dao.mapper;

import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HrMapper {
     List<Hr> getHrs();
     List<Hr> getHrsInfo();
}
