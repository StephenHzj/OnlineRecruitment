package cn.edu.ncu.stephenhe.recruitment.controller;


import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.HrService;
import cn.edu.ncu.stephenhe.recruitment.serivce.JobService;
import cn.edu.ncu.stephenhe.recruitment.serivce.ResumeService;
import cn.edu.ncu.stephenhe.recruitment.serivce.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@EnableAutoConfiguration
public class UserController {


    @Resource
    private UserService userService;

    @Resource
    private JobService jobService;

    @Resource
    private ResumeService resumeService;

    @Resource
    private HrService hrService;



    /**
     * 用户登录
     *
     * @return 登录 成功->1 失败->0
     */
    @Operation(summary = "用户登录")
    @PostMapping(value = "/user/login")
    public Result userLogin(HttpServletRequest request, @RequestBody User user) {

        String tel = user.getUserTel();
        String password = user.getUserPassword();

        User loginUser = userService.getUserByTel(tel);
        Hr loginHr = hrService.getHrByTel(tel);

        if(loginUser == null&&loginHr == null)
            return new Result(503,"用户不存在");

        if (userService.loginUser(tel, password) != null) {
            return new Result(200,"用户登陆成功",loginUser);
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

    @GetMapping("/user/search")
    public String search(HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
            return "未登录";
        if (user.getUserName().equals("admin"))
        {
            return "查找成功";
        }
        return "权限不足";
    }

//    @PostMapping("/user/login1/{id}")
//    public String login1(@RequestParam String userName, String userPassword, String abc,@PathVariable("id") int id)
//    {
//        return "1";
//    }

//    @GetMapping("/user/login1")
//    public String login1(SearchParam searchParam)
//    {
//        return "1";
//    }

    /**
     *
     * @param user
     * @return 注册 成功->1 失败->0
     */
//    @Operation(summary = "用户注册")
//    @PostMapping(value = "/user/register")
//    public Result userRegister(@RequestBody User user) {
//
//        //验证tel,password,username是否为空
//        if (user.getUserTel() == null || user.getUserPassword() == null || user.getUserName() == null) {
//            return new Result( 503,"请输入账号密码");
//        }
//
//        //验证tel是否重复
//        if (userService.getUserByTel(user.getUserTel()) != null && hrService.getHrByTel(user.getUserTel()) != null) {
//            return new Result(503,"账号已存在，请勿重复注册");
//        }
//
//        if(userService.registerUser(user) != null)
//            return new Result(200 ,"注册成功");
//        else
//            return new Result(503, "注册失败...请重试");
//    }


    @Operation(summary = "查找用户(id)")
    @GetMapping(path = "/user/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserById(id);
    }


    @Operation(summary = "修改用户信息")
    @PostMapping(value = "/user/info/update")
    public Result userUpdate(@RequestBody User user){
        if(userService.getUserByTel(user.getUserTel())==null)
            return new Result(503,"更新失败");
        userService.updateUser(user);
        return new Result(200,"更新成功");
    }

    @Operation(summary = "获取简历")
    @GetMapping("/user/resume/{userId}")
    public Result getResumeInfo(@PathVariable int userId){
        return new Result(200,"查询成功",resumeService.getResumeByUserId(userId));
    }

    @Operation(summary = "获取用户信息(Tel)")
    @GetMapping("/user/info/{tel}")
    public Result getUserInfoByTel(@PathVariable String tel){
        return new  Result(200,"查询成功",userService.getUserByTel(tel));
    }

    @Operation(summary = "上传用户Logo")
    @PostMapping(value = "/user/logo/upload")
    public Result uploadHrLogo(@RequestParam("file") MultipartFile[] files,@RequestParam("userTel") String tel) {
        return new Result(200,"上传成功",userService.uploadUserLogo(files,tel));
    }
}
