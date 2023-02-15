package com.finallypro2.service;


import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.Ready_work;
import com.finallypro2.util.Result;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReadyService {

//    public Bootstrap getAllgoodMessageWork(String part);
//
//    public Bootstrap getAllgoodMessage(String part);

    public Result update_new_Readywork(String data);
    public Result updateReady_Good(String part,String state);
    public Result getWorkReady_num(String part);
    public Result getWorkReady(String part, Integer number_find);
    public Integer update_Ready_Good(String str);
}
