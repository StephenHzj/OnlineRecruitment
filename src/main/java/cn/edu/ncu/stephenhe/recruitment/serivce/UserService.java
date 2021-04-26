package cn.edu.ncu.stephenhe.recruitment.serivce;


import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;


public interface UserService {

    User getUserById(int userId);

    List<User> getAllUsers();

    Page<User> getUserPage(Integer page) ;

    User getUserByTel(String tel);

    User registerUser(User user);

    boolean loginUser(String tel,String password);

    User updateUser(User user);



}
