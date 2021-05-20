package cn.edu.ncu.stephenhe.recruitment.controller;

import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.AdminService;
import cn.edu.ncu.stephenhe.recruitment.serivce.TestService;
import cn.edu.ncu.stephenhe.recruitment.serivce.UserService;
import cn.edu.ncu.stephenhe.recruitment.utils.JwtUtil;

import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @Resource
    private UserService userService;

    @Operation(summary = "测试Hr返回值")
    @GetMapping("/test/hrInfo")
    public List<Hr> TestHrMapper(){
        return testService.HrInfo();
    }

    @Operation(summary = "测试Hr_Company返回值")
    @GetMapping("/test/hrInfo2")
    public List<Hr> TestHrMapper2(){
        return testService.HrInfo2();
    }


    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    /**
     * 模拟用户登录
     */

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        String tel = user.getUserTel();
        String password = user.getUserPassword();

        String token =  userService.loginUser(tel,password);

        if(token != null)
            return new Result(200,"Bearer:"+token);
        else
            return new Result(503,"");
    }

}
