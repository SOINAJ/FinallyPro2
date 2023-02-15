package com.finallypro2.controller.work;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Goods_work;
import com.finallypro2.service.GoodsService;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/works")
public class WorkGoodsController {

    @Autowired
    @Qualifier("work")
    private GoodsService goodsService;


    @Autowired
    HttpSession httpSession;

    @GetMapping("/T")
    public Bootstrap getWorkGoods_All(){
        String part =(String) httpSession.getAttribute("part");
        return goodsService.getAllgoodMessage(part);
    }




//    @GetMapping
//    public Result getAllGoodnum(@Autowired HttpServletRequest httpServletRequest){
//        HttpSession httpSession = httpServletRequest.getSession();
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
//    public Result getWorkGoods(@PathVariable String number_find, @Autowired HttpServletRequest httpServletRequest){
//        HttpSession httpSession = httpServletRequest.getSession();
//        String part =(String) httpSession.getAttribute("part");
//        return goodsService.getWorkGoods(part,(Integer.parseInt(number_find)-1)*6);
////        List<Goods_work> list = goodsService.getWorkGoods(part,(Integer.parseInt(number_find)-1)*6);
////        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
////        String msc = list != null ? "" : "error" ;
//
//    }
}
