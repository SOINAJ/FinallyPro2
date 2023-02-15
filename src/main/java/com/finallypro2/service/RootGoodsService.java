package com.finallypro2.service;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.util.Result;


public interface RootGoodsService {

    public Result deldata(String[] data);
    public Bootstrap getAll_Goods_work(String offset,String limit);
}
