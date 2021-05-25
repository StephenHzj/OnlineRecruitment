package cn.edu.ncu.stephenhe.recruitment.controller;


import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.HrService;
import cn.edu.ncu.stephenhe.recruitment.serivce.JobService;
import cn.edu.ncu.stephenhe.recruitment.serivce.ResumeService;
import cn.edu.ncu.stephenhe.recruitment.serivce.UserService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@EnableAutoConfiguration
public class CommonController {


    @Resource
    private UserService userService;

    @Resource
    private JobService jobService;

    @Resource
    private ResumeService resumeService;

    @Resource
    private HrService hrService;


    /**
     *
     * @return 注册 成功->1 失败->0
     */
    @Operation(summary = "用户注册")
    @PostMapping(value = "/register")
    public Result userRegister(@RequestBody JSONObject object) {

        String role = object.getString("role");
        String tel =  object.getString("tel");
        String name = object.getString("name");
        String password = object.getString("password");
        String email = object.getString("email");

        //验证tel,password,username是否为空
        if (tel == null || password == null || name == null) {
            return new Result( 503,"请输入账号密码");
        }

        //验证tel是否重复
        if (userService.getUserByTel(tel) != null && hrService.getHrByTel(tel) != null) {
            return new Result(503,"账号已存在，请勿重复注册");
        }

        if(role.equals("求职者"))
        {
            if(userService.registerUser(tel,name,password,email) != null)
                return new Result(200 ,"注册成功（求职者）");
            else
                return new Result(503, "注册失败...请重试");
        }
        else if(hrService.registerHr(tel,name,password,email) != null){
            return new Result(200 ,"注册成功（招聘者）");
        }else {
            return new Result(503, "注册失败...请重试");
        }
    }

    /**
     * 用户登录
     *
     * @return 登录 成功->1 失败->0
     */
    @Operation(summary = "用户登录")
    @PostMapping(value = "/login")
    public Result userLogin(HttpServletRequest request,String tel , String password) {

        User loginUser = userService.getUserByTel(tel);
        Hr loginHr = hrService.getHrByTel(tel);

        if(loginUser == null&&loginHr == null)
            return new Result(503,"用户不存在");

        if (userService.loginUser(tel, password) != null) {
            return new Result(200,"用户登录成功",loginUser);
        }
        else {
            if(hrService.loginHr(tel,password) != null)
                return new Result(200,"HR登录成功",loginHr);
            else
                return new Result(503,"登录错误");
        }

//        request.getSession().setAttribute("user", user);
//        Cookie cookie = new Cookie("user","123");
//        cookie.setMaxAge(10);
//        response.addCookie(cookie);
//        return "success";

        //前端验证
    }

}
