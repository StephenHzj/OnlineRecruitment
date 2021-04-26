package cn.edu.ncu.stephenhe.recruitment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    //配置Swagger 的docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("StephenHe")
               // .enable(false) //配置是否启用Swagger，如果是false，在浏览器将无法访问
                .select()
                /*
                //RequestHandlerSelectors 配置要扫描的方式
                //basePackage 指定要扫描的包
                //any()  任何请求都扫描
                //none() 任何请求都不扫描
                //withClassAnnotation 扫描类上的注解
                //withMethodAnnotation 扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.basePackage("cn.edu.ncu.stephenhe.recruitment"))
                //paths() 需要过滤的对象
                // any()  任何请求都扫描
                //  none() 任何请求都不扫描
                //  regex(final String pathRegex) 通过正则表达式控制
                //  ant(final String antPattern)  通过ant()控制
                //.paths(PathSelectors.ant())
                .build();

    }

    //配置Swagger信息 = apiInfo
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact =  new Contact("StephenHe", "***", "***");

        return new ApiInfo(
                "网上招聘系统_api文档",
                "毕业设计_网上招聘系统",
                "1.0",
                "urn:tos",
                 contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());


    }

}
