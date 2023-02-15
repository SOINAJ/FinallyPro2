package com.finallypro2.controller.user;

import com.finallypro2.service.ComplainService;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/UComplains")
public class User_ComplainController {

    @Autowired
    private ComplainService complainService;

    @PostMapping
    public Result post_NewComplain(@RequestBody String data){
        System.out.println(data);
//        System.out.println(complain.getDate());
//        return null;
        return complainService.post_user_complain(data);
    }

    @GetMapping("/{number}")
    public Result getComplain(@RequestParam String part,@PathVariable String number){
        System.out.println(part+number);
        return complainService.get_Complain_user(part,number);
//        return null;
    }

}
