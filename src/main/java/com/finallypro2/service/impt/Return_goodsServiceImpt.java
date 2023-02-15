package com.finallypro2.service.impt;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.Notice;
import com.finallypro2.POJO.Return_goods;
import com.finallypro2.dao.GoodsDao;
import com.finallypro2.dao.Return_goodsDao;
import com.finallypro2.dao.RootGoodsDao;
import com.finallypro2.service.Return_goodsService;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Return_goodsServiceImpt implements Return_goodsService {

    @Autowired
    private Return_goodsDao goodsDao;

    @Autowired
    private GoodsDao goodsDaos;

    @Autowired
    private RootGoodsDao rootGoodsDao;


    public Result deleteGoods(String goods_num) {
        Integer goods = rootGoodsDao.deldata(goods_num);
        Integer oh = goods != null ? Code.DELETE_OK : Code.DELETE_ERR;
        String msc = goods != null ? "" : "error";
        return new Result(goods, oh, msc);
    }

    public void update_from_state(String mydata, int state){
        switch (state) {
            case 1:
                goodsDaos.update_GoodsWork_for_return(mydata.substring(0, mydata.length() - 1));
                break;
            case 0:
                goodsDaos.update_GoodsWork(mydata.substring(0, mydata.length() - 1));
                break;
        }
    }

    public Integer update_all(String role, String mydata, int state) {
        Integer okn = 0;
        Integer oh = 0;
        try{
            switch (role) {
                case "W":
                    okn = goodsDao.update_return(state, mydata.substring(0, mydata.length() - 1));
                    oh = goodsDao.select_return_W(Integer.valueOf(mydata.substring(0, mydata.length() - 1)));
                    if (oh != null) {
                        goodsDao.update_return_W(state, mydata.substring(0, mydata.length() - 1));
                    }
                    update_from_state(mydata, state);
                    break;
                case "U":
                    okn = goodsDao.update_return_W(state, mydata.substring(0, mydata.length() - 1));
                    oh = goodsDao.select_return(Integer.valueOf(mydata.substring(0, mydata.length() - 1)));
                    if (oh != null) {
                        goodsDao.update_return(state, mydata.substring(0, mydata.length() - 1));
                    }
                    update_from_state(mydata, state);
                    break;
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }finally{
            return okn;
        }
    }

    public Result insert_new_all(String role, Return_goods return_goods) {
        Integer myint = null;
        switch (role) {
            case "W":
                myint = goodsDao.insert_Return_goods_W(return_goods);
                break;
            case "U":
                myint = goodsDao.insert_Return_goods(return_goods);
                break;
        }

        Integer oh = myint != null ? Code.SAVE_OK : Code.SAVE_ERR;
        String msc = myint != null ? "" : "error";
        return new Result(myint, oh, msc);
    }

    @Override
    public Integer update_return_W_U_mesage(String role,String part) {
        return goodsDao.update_return_W_U_mesage(role, part);
    }

    @Override
    public Result select_message_W_U_mesage(String role,String part) {
        List<Return_goods> list = goodsDao.select_message_W_U_mesage(role, part);
        this.update_return_W_U_mesage(role, part);
        List<Notice> goog_notice = new ArrayList<>();
        for (Return_goods goods : list) {
            goog_notice.add(new Notice("订单取消申请","订单号"+goods.getGood_id()+":的服务人员正在申请取消"));
        }
        Integer oh = goog_notice != null ? Code.GET_OK : Code.GET_ERR;
        String msc = goog_notice != null ? "" : "error";
        return new Result(goog_notice, oh, msc);
    }

    @Override
    public Result update_return_W(String[] data, int state) {
        String mydata = "";
        Integer okn = 0;
        for (String datum : data) {
            mydata += datum;
            mydata += ",";
        }
        okn = this.update_all("W", mydata, state);
        Integer oh = okn != null ? Code.UPDATA_OK : Code.UPDATA_ERR;
        String msc = okn != null ? "" : "error";
        return new Result(okn, oh, msc);
    }


    @Override
    public Result update_return(String[] data, int state) {
        String mydata = "";
        Integer okn = null;
        for (String datum : data) {
            mydata += datum;
            mydata += ",";
        }
        okn = this.update_all("U", mydata, state);
        Integer oh = okn != null ? Code.UPDATA_OK : Code.UPDATA_ERR;
        String msc = okn != null ? "" : "error";
        return new Result(okn, oh, msc);
//        if (!mydata.equals("")){
//            okn = goodsDao.update_return(state,mydata.substring(0, mydata.length() - 1));
//        }
//        if (state == 1){
//            goodsDaos.update_GoodsWork(mydata.substring(0, mydata.length() - 1));
//        }
    }

    @Override
    public Result insert_new_Return(Return_goods return_goods) {
        Goods_work haveMes = goodsDaos.get_hava_goods(return_goods.getGood_id());
        Integer goods = goodsDao.select_return(return_goods.getGood_id());
        Result result = null;
        if (haveMes != null && (goods == null || goods == 0)) {
            result = this.insert_new_all("U", return_goods);
        } else if (haveMes == null) {
            return this.deleteGoods(String.valueOf(return_goods.getGood_id()));
        }
        return result;
//        if (haveMes != null && (goods == null || goods == 0)){
//            goods = goodsDao.insert_Return_goods(return_goods);
//        }else if(haveMes == null){
//            return this.deleteGoods(String.valueOf(return_goods.getGood_id()));
//        }
//        Integer oh = goods != null ? Code.SAVE_OK : Code.SAVE_ERR ;
//        String msc = goods != null ? "" : "error" ;
//        return new Result(goods,oh,msc);
    }

    @Override
    public Result insert_new_Return_W(Return_goods return_goods) {
        Goods_work haveMes = goodsDaos.get_hava_goods(return_goods.getGood_id());
        Integer goods = goodsDao.select_return_W(return_goods.getGood_id());
        Result result = null;
        if (haveMes != null && (goods == null || goods == 0)) {
            result = this.insert_new_all("W", return_goods);
        } else if (haveMes == null) {
            return this.deleteGoods(String.valueOf(return_goods.getGood_id()));
        }
        return result;
//        if (haveMes != null && (goods == null || goods == 0)){
//            goods = goodsDao.insert_Return_goods(return_goods);
//        }else if(haveMes == null){
//            return this.deleteGoods(String.valueOf(return_goods.getGood_id()));
//        }
//        Integer oh = goods != null ? Code.SAVE_OK : Code.SAVE_ERR ;
//        String msc = goods != null ? "" : "error" ;
//        return new Result(goods,oh,msc);

    }


    @Override
    public Bootstrap select_have_Return(String part) {
        List<Return_goods> havaNot = goodsDao.select_have_Return(part.substring(0, 1), part.substring(1));
        return new Bootstrap(havaNot);
        //        Integer oh = havaNot != null ? Code.GET_OK : Code.GET_ERR ;
//        String msc = havaNot != null ? "" : "error" ;
    }
}
