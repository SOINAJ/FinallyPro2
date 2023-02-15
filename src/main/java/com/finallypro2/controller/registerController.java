package com.finallypro2.controller;

import com.finallypro2.POJO.Login_id;
import com.finallypro2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class registerController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/register")
    public String register(String userName,String password,String name,String addre,String phone,String example1){
        Login_id register = new Login_id();
        register.setUsername(name);
        register.setPasswd(password);
        register.setAccount(userName);
        if (example1 == null) register.setRole("1");
        else register.setRole(example1);


        try {
          loginService.Register(register,addre,phone);
          return "login";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "file1";
        }

//        System.out.println(example1);
//        System.out.println(userName);
//        System.out.println(password);
//        System.out.println(name);
//        System.out.println(addre);
//        System.out.println(phone);

    }
}
