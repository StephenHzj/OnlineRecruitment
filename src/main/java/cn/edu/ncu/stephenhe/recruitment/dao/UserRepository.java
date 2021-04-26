package cn.edu.ncu.stephenhe.recruitment.dao;

import cn.edu.ncu.stephenhe.recruitment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User,Integer> {
    User getUserByUserId(int id);

    User getUserByUserTel(String tel);

    @Transactional
    void deleteUserByUserId(int id);




}
