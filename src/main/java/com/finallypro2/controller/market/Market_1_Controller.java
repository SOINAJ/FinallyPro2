package com.finallypro2.controller.market;

import com.finallypro2.service.GoodsService;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marketC1s")
public class Market_1_Controller {

    @Autowired
    @Qualifier("market")
    private GoodsService goodsService;

    @GetMapping("/{num}")
    public Result getMarket_Goods(@PathVariable String num){
        return goodsService.get_Goods_Market_1(num,1);
    }

    @GetMapping
    public Result getMarket_number(){
        return goodsService.get_num_Market_1(1);
    }

}
