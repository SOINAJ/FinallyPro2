package com.finallypro2.controller.root;

import com.finallypro2.POJO.Complain;
import com.finallypro2.service.ComplainService;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@RestController
@RequestMapping("/RComplains")
public class ComplainController {

    @Autowired
    private HttpSession session;

    @Autowired
    private ComplainService complainService;

    @GetMapping("/{number}")
    public Result getComplain(@PathVariable String number){
        System.out.println(number);
        return complainService.get_root_complain(number);
    }

    @GetMapping("/mes/{number}")
    public Result getComplain_Mes(@PathVariable String number){
        System.out.println(number);
        return complainService.get_Complain_Mes(number);
    }

//    @PostMapping
//    public Result post_NewComplain(@RequestBody String data){
//        System.out.println(data);
////        System.out.println(complain.getDate());
////        return null;
//        return complainService.post_user_complain(data);
//    }

    @PostMapping("/mes")
    public Result post_returnComplain(@RequestBody String data) {
//        System.out.println(URLDecoder.decode(data,"UTF-8"));
        return complainService.post_rootReturn(data);
    }
}
