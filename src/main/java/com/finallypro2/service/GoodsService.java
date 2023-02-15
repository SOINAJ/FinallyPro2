package com.finallypro2.service;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.Talk_people;
import com.finallypro2.util.Result;

import java.util.List;

public interface GoodsService {

//    public Bootstrap getAllgoodMessageWork(String part);
//
//    public Bootstrap getAllNotgoodMessageWork(String part);

    public Bootstrap getAllgoodMessage(String part);

    public Bootstrap getAllNotgoodMessage(String part);




    public Talk_people update_talk_people(String part, String id);

    //插入新数据进数据库
    public Result put_Goods_market(String part,Integer number);
    //获取某号市场数量
    public Result get_num_Market_1(Integer market_num);
    //获取某号市场的订单数据
    public Result get_Goods_Market_1(String num,Integer market_num);


    //用户发布新订单数据，并且插入数据库
    public Result update_new_Goods_Work(String data);
    public Integer update_Goods_Work(String str);
    public Result putGoods_scope(String scope, String id);


//    public Result getWorkGoods_num(String part);
//    public Result getWorkGoods(String part,Integer number_find);

//    public Result getWorkGoods_numNot(String part);
//    public Result getWorkGoodsNot(String part,Integer number_find);


}
