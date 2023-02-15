package com.finallypro2.controller.root;

import com.finallypro2.service.U_W_MesService;
import com.finallypro2.service.impt.Profile_down_line;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/RCheck")
public class CheckMesController {

//    @Autowired
//    private HttpSession session;

    @Autowired
    @Qualifier("Root")
    private U_W_MesService u_w_mesService;

    @Autowired
    private Profile_down_line profile_down_line;

    @DeleteMapping("/del/{part}")
    public Result delete_work(@PathVariable String part){
//        System.out.println(part);
        return profile_down_line.delete_work(part.substring(1));
//        profile_down_line.delete_work(part);
//        return null;
    }


    @PostMapping("/{part}")
    public Result post_pass_zg(@PathVariable String part){
//        System.out.println(part);
        return u_w_mesService.pass_U_W(part);
//        return null;
    }

//    @PostMapping("/{part}")
//    public Result post_pass_sfz(@PathVariable String part){
//        System.out.println(part);
////        return profile_down_line.get_downMes(part);
//        return null;
//    }


    @GetMapping("/line/{part}")
    public Result get_profile_line(@PathVariable String part,@RequestParam String num){
//        System.out.println(part + num);
        return profile_down_line.get_lineMes(part , num);
//        return null;
    }

    @GetMapping("/down/{part}")
    public Result get_profile_down(@PathVariable String part){
//        System.out.println(part);
        return profile_down_line.get_downMes(part);
//        return null;
    }


    @GetMapping("/mes/{number}")
    public Result getComplain_Mes(@PathVariable String number){
//        System.out.println(number);
        return u_w_mesService.root_U_W_Mes(number);
//        return null;
    }

    @GetMapping("/U")
    public Result get_U_mes_num(){
        return u_w_mesService.root_get_U_num("U");
//        return null;
    }

    @GetMapping("/W")
    public Result get_W_mes_num(){
        return u_w_mesService.root_get_W_num("W");
//        return null;
    }

    @GetMapping("/U/{number}")
    public Result get_U_mes(@PathVariable String number){
        return u_w_mesService.root_get_U_mes("U",number);
//        return null;
    }

    @GetMapping("/W/{number}")
    public Result get_W_mes(@PathVariable String number){
        return u_w_mesService.root_get_W_mes("W",number);
//        return null;
    }

}
