package cn.edu.ncu.stephenhe.recruitment.controller;


import cn.edu.ncu.stephenhe.recruitment.entity.*;
import cn.edu.ncu.stephenhe.recruitment.entity.response.Result;
import cn.edu.ncu.stephenhe.recruitment.serivce.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@EnableAutoConfiguration
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private UserService userService;

    @Resource
    private JobService jobService;

    @Resource
    private HrService hrService;

    @Resource
    private CompanyService companyService;

    @Resource
    private AdminService adminService;


    @Operation(summary = "查看用户(全部)")
    @GetMapping(path = "/user")
    public Result geAllUsers(){
        return new Result(200,"查询成功",userService.getAllUsers());

    }


    @Operation(summary = "查看用户(分页)")
    @GetMapping(path = "/user/{page}")
    public Result geAllUsers(@PathVariable int page){

        Page<User> pageUsers = userService.getUserPage(page -1); //jpa从0开始
        return new Result(200,"查询成功",pageUsers);

    }


    @Operation(summary = "查看岗位(全部)")
    @GetMapping(path = "/job")
    public Result getAllJobs(){
        return new Result(200,"查询成功",jobService.getAllJobs());
    }

    @Operation(summary = "查看HR(全部)")
    @GetMapping(path = "/hr")
    public Result getAllHrs(){
        return new Result(200,"查询成功",hrService.getAllHrs());

    }


    @Operation(summary = "查看公司(全部)")
    @GetMapping(path = "/company")
    public Result getAllCompanies(){
        return new Result(200,"查询成功",companyService.getAllCompanies());

    }

    @Operation(summary = "查看公司(分页)")
    @GetMapping(path = "/company/{page}")
    public Result geAllCompanies(@PathVariable int page){
        return new Result(200,"查询成功",adminService.getCompanyPage(page -1));      //jpa从0开始

    }


    @Operation(summary = "注册公司")
    @PostMapping(path ="/company/register")
    public Result registerCompany(@RequestBody Company company){

        if(companyService.getCompanyByCompanyCode(company.getCompanyCode()) != null)
            return new Result(503,"公司代码以存在请更换");
        if(companyService.registerCompany(company) != null)
            return new Result(200,"注册成功");
        else
            return new Result(503,"未知错误");
    }

    @Operation(summary = "上传公司Logo")
    @PostMapping(value = "/company/upload")
    public Result uploadHrLogo(@RequestParam("file") MultipartFile[] files) {
        String path = "C:\\Users\\StephenHe\\IdeaProjects\\recruitment-front\\public\\img\\company\\";
        return new Result(200,"上传成功",companyService.uploadCompanyLogo(files,path));
    }


    @Operation(summary = "查看未审核的公司")
    @GetMapping(path = "/company/audit")
    public Result getNotAuditCompany(){
        return new Result(200,"查询成功",companyService.getNotAuditCompany());
    }


    @Operation(summary = "审核公司")
    @GetMapping(path = "/company/audit/{companyCode}")
    public String auditCompany(@PathVariable String companyCode){
        int state = adminService.auditCompany(companyCode);
        if(state == -1)
            return "公司不存在";
        if(state == 1)
           return "审核成功";
        if(state == 0)
           return "取消权限成功";
        else
           return "审核错误(未知error)";
    }

    @Operation(summary = "删除岗位")
    @GetMapping(path = "/job/delete/{id}")
    public Result deleteJob(@PathVariable int id){

        if(adminService.deleteJobById(id) == 1)
            return new Result(200,"删除成功");
        else
            return new Result(500,"删除失败");
    }

    @Operation(summary = "删除用户")
    @GetMapping(path = "/user/delete/{id}")
    public Result deleteUser(@PathVariable int id){

        if(adminService.deleteUserById(id) == 1)
            return new Result(200,"删除成功");
        else
            return new Result(500,"删除失败");
    }

    @Operation(summary = "删除HR")
    @GetMapping(path = "/hr/delete/{id}")
    public Result deleteHr(@PathVariable int id){

        if(adminService.deleteHrById(id) == 1)
            return new Result(200,"删除成功");
        else
            return new Result(500,"删除失败");
    }

    @Operation(summary = "审核岗位")
    @GetMapping(path = "/job/audit/{id}")
    public String auditJob(@PathVariable int id){
        int state = adminService.auditJob(id);
        if(state == 1)
            return "审核成功";
        if(state == 0)
            return "取消权限成功";
        else
            return "审核错误(未知error)";
    }


    /**
     * 管理员登录
     *
     * @return 登录 成功->1 失败->0
     */
    @Operation(summary = "管理员登录")
    @PostMapping(value = "/admin/login")
    public String adminLogin(HttpServletRequest request, @RequestBody Admin admin) {

        String tel = admin.getAdminTel();
        String password = admin.getAdminPassword();


        if (tel == null ) {
            return "请输入用户名";
        }else if(password == null){
            return "请输入密码";
        }

        Admin loginAdmin = adminService.getAdminByTel(tel);

        if(loginAdmin == null)
            return "用户不存在请先注册";

        if (adminService.loginAdmin(tel, password)) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", admin.getAdminId());
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

}
