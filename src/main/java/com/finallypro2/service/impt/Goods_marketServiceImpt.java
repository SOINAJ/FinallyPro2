package com.finallypro2.service.impt;

import com.finallypro2.POJO.Aop_Goods_work;
import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.Talk_people;
import com.finallypro2.controller.TestRedis;
import com.finallypro2.dao.GoodsDao;
import com.finallypro2.dao.TalkDao;
import com.finallypro2.service.GoodsService;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "market")
public class Goods_marketServiceImpt implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;


    @Autowired
    private TestRedis testRedis;


    @Override
    public Bootstrap getAllgoodMessage(String part) {
        return null;
    }

    @Override
    public Bootstrap getAllNotgoodMessage(String part) {
        return null;
    }

    @Override
    public Talk_people update_talk_people(String part, String id) {
        Talk_people one_talk_people = goodsDao.getOne_talk_people(part, id);

        if(one_talk_people == null){
            goodsDao.insertNewDate(id);
        }
        return one_talk_people;
    }

    @Override
    public Result put_Goods_market(String part, Integer number) {
        Integer num = goodsDao.put_Goods_Market(part, number);
        Talk_people people = this.update_talk_people(part, String.valueOf(number));
        testRedis.delRedisdate("Market"+goodsDao.getMarketNum(part,number));
        Integer oh = num != null ? Code.GET_OK : Code.GET_ERR ;
        String msc = num != null ? "" : "error" ;
        return new Result(num,oh,msc);
    }

    @Override
    public Result get_num_Market_1(Integer market_num) {
        Integer num = goodsDao.get_num_Market_1(market_num);
        Integer number = 0;
        if (num%6 == 0){
            number = num / 6;
        } else {
            number = (num / 6) + 1;
        }
        Integer oh = num != null ? Code.GET_OK : Code.GET_ERR ;
        String msc = num != null ? "" : "error" ;
        return new Result(number,oh,msc);
    }

    @Override
    public Result get_Goods_Market_1(String num,Integer market_num) {

//        List<Goods_work> list = goodsDao.get_Goods_Market_1((Integer.parseInt(num)-1)*6,market_num);

        List<Goods_work> list = null;
        if (testRedis.getGood_work((Integer.parseInt(num)-1)*6,"Market"+market_num).size() != 0){
            list = testRedis.getGood_work((Integer.parseInt(num)-1)*6,"Market"+market_num);
        }else {
            list = goodsDao.get_Goods_Market_1((Integer.parseInt(num)-1)*6,market_num);
            if (list.size() != 0) testRedis.putGood_work(list , "Market"+market_num);
        }

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
            testRedis.delRedisdate("Market"+market_num);
        }

        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
        String msc = list != null ? "" : "error" ;
        return new Result(list,oh,msc);
//        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
//        String msc = list != null ? "" : "error" ;


//        List<Aop_Goods_work> workList = new ArrayList<>();
//        for (Goods_work goods_work : list) {
//            workList.add(new Aop_Goods_work(goods_work));
//        }
//        for (Goods_work goods_work : list) {
//            System.out.println(goods_work.toString());
//        }

//        return new Result(list,oh,msc);
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
    public Result putGoods_scope(String scope, String id) {
        return null;
    }

//    @Override
//    public Result getWorkGoods_num(String part) {
//        return null;
//    }
//
//    @Override
//    public Result getWorkGoods(String part, Integer number_find) {
//        return null;
//    }
//
//    @Override
//    public Result getWorkGoods_numNot(String part) {
//        return null;
//    }
//
//    @Override
//    public Result getWorkGoodsNot(String part, Integer number_find) {
//        return null;
//    }


}
