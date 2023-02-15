package com.finallypro2.controller.market;

import com.finallypro2.service.GoodsService;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/markets")
public class MarketController {

    @Autowired
    @Qualifier("market")
    private GoodsService goodsService;

    @Autowired
    private HttpSession httpSession;

    @PutMapping("/{idName}")
    public Result putGoodsScope(@PathVariable String idName){
        String part = (String) httpSession.getAttribute("part");
//        System.out.println(idName+"!"+part);
        return goodsService.put_Goods_market(part,Integer.parseInt(idName));
//        return null;
    }

}
