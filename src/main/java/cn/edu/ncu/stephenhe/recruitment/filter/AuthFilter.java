//package cn.edu.ncu.stephenhe.recruitment.filter;
//
//import cn.edu.ncu.stephenhe.recruitment.entity.User;
//import com.alibaba.fastjson.JSON;
//import lombok.extern.apachecommons.CommonsLog;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class AuthFilter extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        if (httpServletRequest.getRequestURI().startsWith("/admin"))
//        {
//            User user = (User)httpServletRequest.getSession().getAttribute("user");
//            String userName = user.getUserName();
//            if (userName.equals("admin"))
//            {
//                filterChain.doFilter(httpServletRequest, httpServletResponse);
//            }
//            else
//            {
//                Map<String ,String > map  =new HashMap<>();
//                map.put("msg","权限不足");
//                //{"msg":"权限不足"}
//                String s = JSON.toJSONString(map);
//                httpServletResponse.setStatus(200);
//                PrintWriter writer = httpServletResponse.getWriter();
//                writer.println(s);
//                httpServletResponse.setContentType("application/json;charset=utf-8");
//            }
//        }
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
//
//    }
//}
