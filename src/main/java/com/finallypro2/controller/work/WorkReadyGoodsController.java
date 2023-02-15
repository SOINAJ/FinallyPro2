package com.finallypro2.controller.work;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Ready_work;
import com.finallypro2.service.ReadyService;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/readys")
public class WorkReadyGoodsController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    @Qualifier(value = "Rwork")
    private ReadyService readyService;


//    @GetMapping("/T")
//    public Bootstrap getWorkGoods_All(){
//        HttpSession httpSession = httpServletRequest.getSession();
//        String part =(String) httpSession.getAttribute("part");
//        return readyService.getAllgoodMessageWork(part);
//    }



    @PutMapping("/{state}")
    public Result updataReadyGood(@PathVariable String state,@RequestBody String idName){
//        System.out.println(idName+"???"+state);
        String this_id = idName.substring(12);
        return readyService.updateReady_Good(this_id,state);
    }



    @GetMapping
    public Result getAllGoodnum(){
        HttpSession httpSession = httpServletRequest.getSession();
        String part =(String) httpSession.getAttribute("part");
        return readyService.getWorkReady_num(part);
    }

    @GetMapping("/{number_find}")
    public Result getReadyGoods(@PathVariable String number_find){
        HttpSession httpSession = httpServletRequest.getSession();
        String part =(String) httpSession.getAttribute("part");
        return readyService.getWorkReady(part,(Integer.parseInt(number_find)-1)*6);
    }
}
