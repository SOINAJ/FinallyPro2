package com.finallypro2.service;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Return_goods;
import com.finallypro2.util.Result;

public interface Return_goodsService {

    public Integer update_return_W_U_mesage(String role,String part);

    public Result select_message_W_U_mesage(String role,String part);


    /**
     * 用于work提出订单取消,用于对某个订单进行取消申请或者直接
     * @param data
     * @param state
     * @return
     */
    public Result update_return_W(String[] data,int state);

//    /**
//     * 获取某一个订单的取消消息
//     * @param num
//     * @return
//     */
//    public Result getReturn_mes(String num);

    /**
     * 用于user提出订单取消，用于对某个订单进行取消申请或者直接
     * @param data
     * @param state
     * @return
     */
    public Result update_return(String[] data,int state);


    /**
     * 插入新数据去订单取消申请表,user
     * @return
     */
    public Result insert_new_Return(Return_goods return_goods);

    /**
     * 插入新数据去订单取消申请表,work
     * @return
     */
    public Result insert_new_Return_W(Return_goods return_goods);

    /**
     * 查看是否有待同意的申请消息
     * @param part
     * @return
     */
    public Bootstrap select_have_Return(String part);
}
