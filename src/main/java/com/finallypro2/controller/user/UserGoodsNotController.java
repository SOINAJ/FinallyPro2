package com.finallypro2.controller.user;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Goods_work;
import com.finallypro2.service.GoodsService;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/usersNot")
public class UserGoodsNotController {


    @Autowired
    HttpSession httpSession;

    @Autowired
    @Qualifier("user")
    private GoodsService goodsService;


    @PutMapping
    public Result deleteGoods(@RequestBody String[] data){
        System.out.println(data);
        return null;
    }

    @GetMapping("/T/{part}")
    public Bootstrap getWorkGoods_All(@PathVariable String part){
//        String part =(String) httpSession.getAttribute("part");
        return goodsService.getAllNotgoodMessage(part);
//        List<Goods_work> list = goodsService.getWorkGoodsNot(part,(Integer.parseInt(number_find)-1)*6);
//        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
//        String msc = list != null ? "" : "error" ;
//        return new Result(list,oh,msc);
    }


//    @GetMapping
//    public Result getAllGoodnum(){
//        String part =(String) httpSession.getAttribute("part");
//        return goodsService.getWorkGoods_numNot(part);
////        Integer num = goodsService.getWorkGoods_numNot(part);
////        Integer number = 0;
////        if (num%6 == 0){
////            number = num / 6;
////        } else {
////            number = (num / 6) + 1;
////        }
////        Integer oh = num != null ? Code.GET_OK : Code.GET_ERR ;
////        String msc = num != null ? "" : "error" ;
////        return new Result(number,oh,msc);
//    }
//
//
//    @GetMapping("/{number_find}")
//    public Result getWorkGoods(@PathVariable String number_find){
//        String part =(String) httpSession.getAttribute("part");
//        return goodsService.getWorkGoodsNot(part,(Integer.parseInt(number_find)-1)*6);
////        List<Goods_work> list = goodsService.getWorkGoodsNot(part,(Integer.parseInt(number_find)-1)*6);
////        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
////        String msc = list != null ? "" : "error" ;
////        return new Result(list,oh,msc);
//    }
}
