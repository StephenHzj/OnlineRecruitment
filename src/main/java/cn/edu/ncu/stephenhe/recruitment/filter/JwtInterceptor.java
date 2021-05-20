package cn.edu.ncu.stephenhe.recruitment.filter;

import cn.edu.ncu.stephenhe.recruitment.utils.JwtUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer:")) {
            return false;
        }
        //获得token
        String token = authHeader.substring(7);
        //验证token
        return JwtUtil.verify(token);
    }
}
