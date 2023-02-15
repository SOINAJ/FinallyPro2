package com.finallypro2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginoutController {

    @RequestMapping("/logout")
    public String loginoutSystem(@Autowired HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("username");
        session.removeAttribute("talk");
        session.removeAttribute("passwd");
        session.removeAttribute("part");
        session.removeAttribute("username");
//        System.out.println("username"+session.getAttribute("username"));
        return "login";
    }
}
