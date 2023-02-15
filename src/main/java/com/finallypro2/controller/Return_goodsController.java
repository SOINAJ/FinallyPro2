package com.finallypro2.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Return_goods;
import com.finallypro2.service.Return_goodsService;
import com.finallypro2.util.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;

@RestController
@RequestMapping("/returns")
public class Return_goodsController {

    @Autowired
    private Return_goodsService return_goodsService;

    @PostMapping("/W/1")
    public Result agree_return_W(@RequestBody String[] data){
//        System.out.println(data);
        return return_goodsService.update_return_W(data,1);
    }

    @PostMapping("/W/2")
    public Result refuse_return_W(@RequestBody String[] data){
//        System.out.println(data);
        return return_goodsService.update_return_W(data,0);
    }


    @PostMapping("/1")
    public Result agree_return(@RequestBody String[] data){
//        System.out.println(data);
        return return_goodsService.update_return(data,1);
    }

    @PostMapping("/2")
    public Result refuse_return(@RequestBody String[] data){
//        System.out.println(data);
        return return_goodsService.update_return(data,0);
    }



    @GetMapping("/{part}")
    public Bootstrap select_have_Return(@PathVariable String part){
        return return_goodsService.select_have_Return(part);
    }

    @GetMapping("/m/{part}")
    public Result select_have_message(@PathVariable String part){
        return return_goodsService.select_message_W_U_mesage(part.substring(0,1),part.substring(1));
    }


    @PutMapping("/2")
    public Result insert_new_message_W(@RequestBody String data){
        JSONArray array = JSONArray.parseArray(data);
        JSONObject object = (JSONObject) array.get(0);
        return return_goodsService.insert_new_Return_W(new Return_goods((String) object.get("Anum"), (String) object.get("Bnum"), (Integer) object.get("good_id")));
    }

    @PutMapping("/1")
    public Result insert_new_message(@RequestBody String data){
        JSONArray array = JSONArray.parseArray(data);
        JSONObject object = (JSONObject) array.get(0);
        return return_goodsService.insert_new_Return(new Return_goods((String) object.get("Anum"), (String) object.get("Bnum"), (Integer) object.get("good_id")));
    }
}
