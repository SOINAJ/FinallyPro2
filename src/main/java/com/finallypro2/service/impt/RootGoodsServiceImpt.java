package com.finallypro2.service.impt;

import com.finallypro2.POJO.Goods_work;

import com.finallypro2.dao.RootGoodsDao;
import com.finallypro2.service.RootGoodsService;
import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RootGoodsServiceImpt implements RootGoodsService {


    @Autowired
    private RootGoodsDao rootGoodsDao;


    @Override
    public Result deldata(String[] data) {
        String mydata = "";
        Integer okn = 0;
        for (String datum : data) {
            mydata += datum;
            mydata += ",";
        }
        if (!mydata.equals("")){
            okn = rootGoodsDao.deldata(mydata.substring(0, mydata.length() - 1));
        }
        Integer oh = okn != null ? Code.DELETE_OK : Code.DELETE_ERR ;
        String msc = okn != null ? "" : "error" ;
        return new Result(okn,oh,msc);
    }

    @Override
    public Bootstrap getAll_Goods_work(String offset,String limit) {
        List<Goods_work> list = null;
        if (offset != null && limit != null){
            list = rootGoodsDao.getAll_Goods_Work(Integer.parseInt(offset),Integer.parseInt(limit));
        }

        Integer number = rootGoodsDao.getAll_Goods_num();
        return new Bootstrap(list,number);
    }
}
