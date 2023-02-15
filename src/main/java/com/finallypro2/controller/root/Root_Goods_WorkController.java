package com.finallypro2.controller.root;

import com.finallypro2.service.RootGoodsService;
import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rootGoods")
public class Root_Goods_WorkController {

    @Autowired
    private RootGoodsService rootGoodsService;


    @PutMapping
    public Result deldata(@RequestBody String[] data){
        return rootGoodsService.deldata(data);
    }


    @GetMapping
    public Bootstrap getAll_Goods_work(String offset,String limit){
        return rootGoodsService.getAll_Goods_work(offset,limit);
    }
}
