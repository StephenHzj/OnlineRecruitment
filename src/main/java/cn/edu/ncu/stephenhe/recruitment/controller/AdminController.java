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


    @PostMapping("/login")
    public Result adminLogin(@RequestBody Admin admin){
        String tel = admin.getAdminTel();
        String password = admin.getAdminPassword();
        String token =  adminService.loginAdmin(tel,password);
        if(token != null)
            return new Result(200,"Bearer:"+token);
        else
            return new Result(503,"");
    }

    @Operation(summary = "查看用户(全部)")
    @GetMapping(path = "/user")
    public Result geAllUsers(){
        return new Result(200,"查询成功",userService.getAllUsers());

    }


    @Operation(summary = "查看用户(分页)")
    @GetMapping(path = "/user/page/{page}")
    public Result geAllUsers(@PathVariable int page){

        Page<User> userPage = userService.getUserPage(page -1); //jpa从0开始
        return new Result(200,"查询成功",userPage);

    }


    @Operation(summary = "查看岗位(全部)")
    @GetMapping(path = "/job")
    public Result getAllJobs(){
        return new Result(200,"查询成功",jobService.getJobList());
    }


    @Operation(summary = "查看HR(全部)")
    @GetMapping(path = "/hr")
    public Result getAllHrs(){
        return new Result(200,"查询成功",hrService.getHrsInfo());
    }


    @Operation(summary = "查看公司(全部)")
    @GetMapping(path = "/company")
    public Result getAllCompanies(){
        return new Result(200,"查询成功",companyService.getAllCompanies());
    }


    @Operation(summary = "查看公司(分页)")
    @GetMapping(path = "/company/page/{page}")
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
        String path = "C:\\Users\\StephenHe\\IdeaProjects\\recruitment-front\\src\\assets\\logo\\company\\";
        return new Result(200,"上传成功",companyService.uploadCompanyLogo(files,path));
    }


    @Operation(summary = "查看未审核的公司")
    @GetMapping(path = "/company/audit")
    public Result getNotAuditCompany(){
        return new Result(200,"查询成功",companyService.getNotAuditCompany());
    }


    @Operation(summary = "审核公司")
    @GetMapping(path = "/company/audit/{companyCode}")
    public Result auditCompany(@PathVariable String companyCode){
        if(companyService.auditCompany(companyCode))
            return new Result(200,"审核成功");
        else
            return new Result(503,"审核失败");

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
    @GetMapping(path = "/job/disable/{id}")
    public Result disableJob(@PathVariable int id){

        if(jobService.disableJob(id))
           return new Result(200,"禁用成功");
        else
            return new Result(503,"禁用失败");
    }

    @Operation(summary = "获取admin名称")
    @GetMapping("/admin/{tel}")
    public Result getAdminName(@PathVariable String tel){
        Admin admin =  adminService.getAdminByTel(tel);
        return new Result(200,admin.getAdminName());
    }



//    /**
//     * 管理员登录
//     *
//     * @return 登录 成功->1 失败->0
//     */
//    @Operation(summary = "管理员登录")
//    @PostMapping(value = "/admin/login")
//    public String adminLogin(HttpServletRequest request, @RequestBody Admin admin) {
//
//        String tel = admin.getAdminTel();
//        String password = admin.getAdminPassword();
//
//
//        if (tel == null ) {
//            return "请输入用户名";
//        }else if(password == null){
//            return "请输入密码";
//        }
//
//        Admin loginAdmin = adminService.getAdminByTel(tel);
//
//        if(loginAdmin == null)
//            return "用户不存在请先注册";
//
//        if (adminService.loginAdmin(tel, password)) {
//            HttpSession httpSession = request.getSession();
//            httpSession.setAttribute("user", admin.getAdminId());
//            return "登录成功";
//        }
//        else {
//            return "密码错误！";
//        }
//
//
////        request.getSession().setAttribute("user", user);
////        Cookie cookie = new Cookie("user","123");
////        cookie.setMaxAge(10);
////        response.addCookie(cookie);
////        return "success";
//
//
//        //前端验证
//    }

}
