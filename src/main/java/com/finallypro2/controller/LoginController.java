package com.finallypro2.controller;

import com.finallypro2.POJO.Login_id;
import com.finallypro2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/loginSystem")
    public String loginSystem(String username,String passwd ,@Autowired HttpServletRequest httpServletRequest){
//        System.out.println(username+passwd);
        Login_id loginId = loginService.loginSystem(username, passwd);
        if (loginId != null) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("account",loginId.getAccount());
            session.setAttribute("talk",loginId.getTalk());
            session.setAttribute("passwd",loginId.getPasswd());
            session.setAttribute("part",loginId.getPart());
            session.setAttribute("username",loginId.getUsername());
            session.setMaxInactiveInterval(30*60);
            if(loginId.getRole().equals("1")){
                return "myfile/index";
            }else if (loginId.getRole().equals("0")){
                return "myfile/index_work";
            }else {
                return "myfile/index_root";
            }

        }
        else{
            return "login";
        }
    }

    @RequestMapping("/")
    public String hello(){
        return "login";
    }
}
