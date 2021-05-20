package cn.edu.ncu.stephenhe.recruitment.serivce;


import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


public interface UserService {

    User getUserById(int userId);

    List<User> getAllUsers();

    Page<User> getUserPage(Integer page) ;

    User getUserByTel(String tel);

    User registerUser(User user);

    String loginUser(String tel,String password);

    User updateUser(User user);

    String uploadUserLogo(MultipartFile[] files, String path);


}
