
package cn.edu.ncu.stephenhe.recruitment.serivce.impl;


import cn.edu.ncu.stephenhe.recruitment.dao.UserRepository;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.UserService;
import cn.edu.ncu.stephenhe.recruitment.utils.JwtUtil;
import cn.edu.ncu.stephenhe.recruitment.utils.UploadUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Resource
    private UserRepository userRepository;

    @Override
    public User getUserById(int userId) {
        return userRepository.getUserByUserId(userId);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }


    @Override
    public Page<User> getUserPage(Integer page) {
        if (null == page) {
            page = 0;
        }
        PageRequest pageable = PageRequest.of(page, 2); //设置pageSize
        Page<User> users = userRepository.findAll(pageable);
        return users;
    }

    @Override
    public User getUserByTel(String tel) {
        return userRepository.getUserByUserTel(tel);
    }

    @Override
    public User registerUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public User registerUser(String tel, String name, String password, String email) {
        User user = new User();
        user.setUserName(name);
        user.setUserTel(tel);
        user.setUserPassword(password);
        user.setUserEmail(email);

        return userRepository.save(user);

    }

    @Override
    public String loginUser(String tel, String password) {

        User user = userRepository.getUserByUserTel(tel);
        if(user == null)
            return null;
        else if(user.getUserPassword().equals(password)){
            String token =  JwtUtil.createToken(user);
            return token;
        }else
            return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public String uploadUserLogo(MultipartFile[] files, String path) {
        UploadUtils uploadUtils = new UploadUtils();
        return uploadUtils.uploadFile(files,path) ;
    }


}

