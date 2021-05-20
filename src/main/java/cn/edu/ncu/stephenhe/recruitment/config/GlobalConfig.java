package cn.edu.ncu.stephenhe.recruitment.config;

import cn.edu.ncu.stephenhe.recruitment.filter.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalConfig implements WebMvcConfigurer {

        @Override
         public void addInterceptors(InterceptorRegistry registry) {
            //添加拦截器
          //  registry.addInterceptor(new JwtInterceptor()).excludePathPatterns("/admin/*","/doc.html");//放掉某些特定不需要校验token的路由
        }

}
