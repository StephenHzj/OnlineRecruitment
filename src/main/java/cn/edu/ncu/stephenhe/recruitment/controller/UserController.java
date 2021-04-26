package cn.edu.ncu.stephenhe.recruitment.controller;


import cn.edu.ncu.stephenhe.recruitment.entity.User;
import cn.edu.ncu.stephenhe.recruitment.serivce.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@EnableAutoConfiguration
public class UserController {


    @Resource
    private UserService userService;



    /**
     * 用户登录
     *
     * @return 登录 成功->1 失败->0
     */
    @Operation(summary = "用户登录")
    @PostMapping(value = "/user/login")
    public String userLogin(HttpServletRequest request, @RequestBody User user) {

        String tel = user.getUserTel();
        String password = user.getUserPassword();
        if (tel == null ) {
            return "请输入用户名";
        }else if(password == null){
            return "请输入密码";
        }

        User loginUser = userService.getUserByTel(tel);

        if(loginUser == null)
            return "用户不存在请先注册";


        if (userService.loginUser(tel, password)) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user.getUserTel());
            return "登录成功";
        }
        else {
            return "密码错误！";
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
    @Operation(summary = "用户注册")
    @PostMapping(value = "/user/register")
    public String userRegister(@RequestBody User user) {

        //验证tel,password,username是否为空
        if (user.getUserTel() == null || user.getUserPassword() == null || user.getUserName() == null) {
            return "0";
        }

        //验证tel是否重复
        if (userService.getUserByTel(user.getUserTel()) != null) {
            return "账号已存在，请勿重复注册";
        }

        if(userService.registerUser(user) != null)
            return "注册成功";
        else
            return "注册失败";
    }


    @Operation(summary = "查找用户(id)")
    @GetMapping(path = "/user/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserById(id);
    }

    @Operation(summary = "修改用户信息")
    @PostMapping(value = "/user/update")
    public int userUpdate(@RequestBody User user){

        if(userService.getUserByTel(user.getUserTel())==null)
            return 0;

        userService.updateUser(user);
        return 1;
    }




}
