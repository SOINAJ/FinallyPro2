package com.finallypro2.controller.user;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Goods_work;
import com.finallypro2.service.GoodsService;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserGoodsController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    @Qualifier("user")
    private GoodsService goodsService;


    @GetMapping("/T")
    public Bootstrap getWorkGoods_All(){
        String part =(String) httpSession.getAttribute("part");
        return goodsService.getAllgoodMessage(part);
    }


    //插入新数据进去数据库
    @PostMapping
    public Result post_NewGoods(@RequestBody String data) {
//        System.out.println(data);
        Result result = goodsService.update_new_Goods_Work(data);
        return result;
    }


    @PutMapping("/{scope}")
    public Result putGoodsScope(@PathVariable String scope,@RequestBody String id){

        String myid = id.substring(3);
        System.out.println(myid+">??"+scope);
        Result num = goodsService.putGoods_scope(scope,myid);
        return num;
    }



//    @GetMapping
//    public Result getAllGoodnum(){
//        String part =(String) httpSession.getAttribute("part");
//        return goodsService.getWorkGoods_num(part);
////        Integer num = goodsService.getWorkGoods_num(part);
////        Integer number = 0;
////        if (num%6 == 0){
////            number = num / 6;
////        } else {
////            number = (num / 6) + 1;
////        }
////        Integer oh = num != null ? Code.GET_OK : Code.GET_ERR ;
////        String msc = num != null ? "" : "error" ;
//
//    }
//
//
//    @GetMapping("/{number_find}")
//    public Result getWorkGoods(@PathVariable String number_find){
//        String part =(String) httpSession.getAttribute("part");
//        return goodsService.getWorkGoods(part,(Integer.parseInt(number_find)-1)*6);
////        List<Goods_work> list = goodsService.getWorkGoods(part,(Integer.parseInt(number_find)-1)*6);
////        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
////        String msc = list != null ? "" : "error" ;
////        for (Goods_work goods_work : list) {
////            System.out.println(goods_work.toString());
////        }
////        return new Result(list,oh,msc);
//    }
}
