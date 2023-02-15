package com.finallypro2.controller;

import com.finallypro2.POJO.Login_id;
import com.finallypro2.util.Code;
import com.finallypro2.util.IsEmpty;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/checkUsers")
public class CheckUserController {

    @PostMapping
    public Result getCheckUser(@Autowired HttpServletRequest httpServletRequest){
//        IsEmpty isEmpty = new IsEmpty();
        HttpSession session = httpServletRequest.getSession();
        String account =(String) session.getAttribute("account");
        String passwd =(String) session.getAttribute("passwd");
        String part =(String) session.getAttribute("part");
        String username =(String) session.getAttribute("username");
//        System.out.println(username+passwd);
        if (IsEmpty.isEmpty(account) || IsEmpty.isEmpty(passwd)){
            return new Result(null,Code.UPDATA_ERR,"error");
        }else {
            Login_id list = new Login_id();
            list.setAccount(account);
            list.setPasswd(passwd);
            list.setPart(part);
            list.setUsername(username);
            return new Result(list, Code.UPDATA_OK,"ok");
        }
    }
}
