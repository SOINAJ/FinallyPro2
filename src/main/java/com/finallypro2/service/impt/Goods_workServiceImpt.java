package com.finallypro2.service.impt;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.Talk_people;
import com.finallypro2.controller.TestRedis;
import com.finallypro2.dao.GoodsDao;
import com.finallypro2.service.GoodsService;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "work")
public class Goods_workServiceImpt implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private TestRedis testRedis;

//    @Override
//    public Bootstrap getAllgoodMessageWork(String part) {
//
//    }
//
//
//
//
//    @Override
//    public Bootstrap getAllNotgoodMessageWork(String part) {
//
//
//    }

    @Override
    public Bootstrap getAllgoodMessage(String part) {
        return new Bootstrap(goodsDao.getAllGoodMesWork(part));
    }

    @Override
    public Bootstrap getAllNotgoodMessage(String part) {
        List<Goods_work> list = goodsDao.getAllNotGoodMesWork(part);

        String str = "";
        for (int i = 0; i < list.size(); ) {
            int res = new Date().compareTo(list.get(i).getTime_end());
            if (res == 0 || res == 1) {
                str += list.get(i).getId();
                str += ",";
                list.remove(list.get(i));
            }else i++;
        }
        String str1 = "";
        if (!str.equals("")) {
            str1 = str.substring(0, str.length() - 1);
            this.update_Goods_Work(str1);

            testRedis.delRedisdate("Workman");
        }
        return new Bootstrap(list);
    }

    @Override
    public Talk_people update_talk_people(String part, String id) {
        return null;
    }

    @Override
    public Result put_Goods_market(String part, Integer number) {
        return null;
    }

    @Override
    public Result get_num_Market_1(Integer market_num) {
        return null;
    }
    @Override
    public Result get_Goods_Market_1(String num,Integer market_num) {
        return null;
    }

    @Override
    public Result update_new_Goods_Work(String data) {
        return null;
    }

    @Override
    public Integer update_Goods_Work(String str) {
        return goodsDao.update_GoodsWork(str);
    }

    @Override
    public Result putGoods_scope(String id, String scope) {
        return null;
    }

//    @Override
//    public Result getWorkGoods_num(String part) {
//        Integer num = goodsDao.get_WorkGoodsnum_work(part);
//        Integer number = 0;
//        if (num%6 == 0){
//            number = num / 6;
//        } else {
//            number = (num / 6) + 1;
//        }
//        Integer oh = num != null ? Code.GET_OK : Code.GET_ERR ;
//        String msc = num != null ? "" : "error" ;
//        return new Result(number,oh,msc);
//    }
//
//    @Override
//    public Result getWorkGoods(String part,Integer number_find) {
////        List<Goods_work> list = goodsDao.get_WorkGoods_work(part,number_find);
//
//        List<Goods_work> list = null;
//        if (testRedis.getGood_work(number_find,part+"GoodW").size() != 0){
//            list = testRedis.getGood_work(number_find,part+"GoodW");
//        }else {
//            list = goodsDao.get_WorkGoods_work(part, number_find);
//            testRedis.putGood_work(list , part+"GoodW");
//        }
//
//        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
//        String msc = list != null ? "" : "error" ;
//        return new Result(list,oh,msc);
//    }
//
//    @Override
//    public Result getWorkGoods_numNot(String part) {
//        Integer num = goodsDao.get_WorkGoodsnum_workNot(part);
//        Integer number = 0;
//        if (num%6 == 0){
//            number = num / 6;
//        } else {
//            number = (num / 6) + 1;
//        }
//        Integer oh = num != null ? Code.GET_OK : Code.GET_ERR ;
//        String msc = num != null ? "" : "error" ;
//        return new Result(number,oh,msc);
//    }
//
//    @Override
//    public Result getWorkGoodsNot(String part, Integer number_find) {
////        List<Goods_work> list = goodsDao.get_WorkGoods_workNot(part, number_find);
//
//        List<Goods_work> list = null;
//        if (testRedis.getGood_work(number_find,part+"GoodWN").size() != 0){
//            list = testRedis.getGood_work(number_find,part+"GoodWN");
//        }else {
//            list = goodsDao.get_WorkGoods_workNot(part, number_find);
//            testRedis.putGood_work(list , part+"GoodWN");
//        }
//
//        String str = "";
//        for (int i = 0;i<list.size();) {
//            int res = new Date().compareTo(list.get(i).getTime_end());
//            if(res == 0 || res == 1){
//                str += list.get(i).getId();
//                str += ",";
//                list.remove(list.get(i));
//            }else i++;
//        }
//        String str1 = "";
//        if(!str.equals("")){
//            str1 = str.substring(0,str.length()-1);
//            this.update_Goods_Work(str1);
//            testRedis.delRedisdate(part+"GoodWN");
//            testRedis.delRedisdate(part+"GoodW");
//        }
//
//
//        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
//        String msc = list != null ? "" : "error" ;
//        return new Result(list,oh,msc);
//    }


//        String oh = part.substring(0,1);
//        System.out.println("oh =: "+oh);
//        if (oh.equals("A")){
//            return goodsDao.get_WorkGoods_user(part);
//        } else if (oh.equals("B")) {
//            return goodsDao.get_WorkGoods_work(part);
//        }
//        return goodsDao.get_WorkGoods_user(part);
//    }

}
