package cn.edu.ncu.stephenhe.recruitment.controller;

import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.serivce.TestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class TestController {

    @Resource
    private TestService testService;

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
}
