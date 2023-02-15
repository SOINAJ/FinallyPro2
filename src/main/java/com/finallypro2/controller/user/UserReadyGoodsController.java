package com.finallypro2.controller.user;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Ready_work;
import com.finallypro2.service.ReadyService;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/readyUs")
public class UserReadyGoodsController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    @Qualifier(value = "Ruser")
    private ReadyService readyService;


//    @GetMapping("/T")
//    public Bootstrap getWorkGoods_All(){
//        String part =(String) httpSession.getAttribute("part");
//        return readyService.getAllgoodMessage(part);
//    }
    //    @PutMapping("/{state}")
//    public Result updataReadyGood(@PathVariable String state,@RequestBody String idName){
//        String this_id = idName.substring(12);
//        Integer num = readyService.updateReady_Good(this_id,state);
//        Integer oh = num != null ? Code.UPDATA_OK : Code.UPDATA_ERR ;
//        String msc = num != null ? "" : "error" ;
//        if (state.equals("1")){
//            return new Result(num,oh,msc);
//        }else {
//            return new Result(num+1,oh,msc);
//        }
//
//    }
    @PostMapping
    public Result post_NewGoods(@RequestBody String data) {
        Result result = readyService.update_new_Readywork(data);
        return result;
    }


    @GetMapping
    public Result getAllGoodnum() {
        String part = (String) httpSession.getAttribute("part");
        return readyService.getWorkReady_num(part);
    }

    @GetMapping("/{number_find}")
    public Result getReadyGoods(@PathVariable String number_find) {
        String part = (String) httpSession.getAttribute("part");
        return readyService.getWorkReady(part, (Integer.parseInt(number_find) - 1) * 6);
    }
}
