package cn.edu.ncu.stephenhe.recruitment.dao.mapper;


import cn.edu.ncu.stephenhe.recruitment.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper  {
    List<User> selectUser();

}

