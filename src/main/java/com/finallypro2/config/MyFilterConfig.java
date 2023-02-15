package com.finallypro2.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/myfile/*"})
public class MyFilterConfig implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession();
//        System.out.println("myfilter");
        if (httpSession.getAttribute("username") == null){
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("/login.html");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
