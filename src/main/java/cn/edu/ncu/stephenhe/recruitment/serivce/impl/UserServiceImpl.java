
package cn.edu.ncu.stephenhe.recruitment.serivce.impl;


import cn.edu.ncu.stephenhe.recruitment.dao.UserRepository;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public boolean loginUser(String tel, String password) {
        User user = userRepository.getUserByUserTel(tel);
        if(user == null)
            return false;
        if(user.getUserPassword().equals(password))
            return true;
        else
            return false;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }


}

