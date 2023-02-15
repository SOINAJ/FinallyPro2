package com.finallypro2.service.impt;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.Ready_work;
import com.finallypro2.controller.TestRedis;
import com.finallypro2.dao.ReadyDao;
import com.finallypro2.service.ReadyService;
import com.finallypro2.util.Code;
import com.finallypro2.util.IsEmpty;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service(value = "Rwork")
public class Ready_workServiceImpt implements ReadyService {

    @Autowired
    private ReadyDao readyDao;

    @Autowired
    private TestRedis testRedis;

//    @Override
//    public Bootstrap getAllgoodMessageWork(String part) {
//        List<Ready_work> list = readyDao.getAllGoodMesWork(part);
//
//        String str = "";
//        for (int i = 0; i < list.size(); i++) {
//            int res = new Date().compareTo(list.get(i).getTime_end());
//            if ((res == 0 || res == 1) && (IsEmpty.isEmpty(list.get(i).getState()))) {
//                str += list.get(i).getId();
//                str += ",";
//                list.get(i).setState("-1");
//            }
//        }
//        String str1 = "";
//        if (!str.equals("")) {
//            str1 = str.substring(0, str.length() - 1);
//            this.update_Ready_Good(str1);
//        }
//
//        return new Bootstrap(list);
//
//    }
//
//    @Override
//    public Bootstrap getAllgoodMessage(String part) {
//        return null;
//    }

    @Override
    public Result update_new_Readywork(String data) {
        return null;
    }

    @Override
    @Transactional
    public Result updateReady_Good(String part,String state){
        readyDao.updataReady_work(part, state);
//        int i = readyDao.updataGoods_work(part);

        Integer num = readyDao.updataGoods_work(part);
        Integer oh = num != null ? Code.UPDATA_OK : Code.UPDATA_ERR ;
        String msc = num != null ? "" : "error" ;
        if (state.equals("1")){
            return new Result(num,oh,msc);
        }else {
            return new Result(num+1,oh,msc);
        }

    }


    @Override
    public Result getWorkReady_num(String part) {
        Integer num = readyDao.get_WorkReadynum_work(part);
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
    public Result getWorkReady(String part, Integer number_find) {

//        List<Ready_work> list = readyDao.get_WorkReady_work(part, number_find);

        List<Ready_work> list = null;
        if (testRedis.getGood_work(number_find,part+"GoodUN").size() != 0){
            list = testRedis.getReady_work(number_find,part+"GoodUN");
        }else {
            list = readyDao.get_WorkReady_work(part, number_find);
            testRedis.putReady_work(list , part+"GoodUN");
        }

        String str = "";
        for (int i = 0; i < list.size(); i++) {
            int res = new Date().compareTo(list.get(i).getTime_end());
            if ((res == 0 || res == 1) && (IsEmpty.isEmpty(list.get(i).getState()))) {
                str += list.get(i).getId();
                str += ",";
                list.get(i).setState("-1");
            }
        }
        String str1 = "";
        if (!str.equals("")) {
            str1 = str.substring(0, str.length() - 1);
            this.update_Ready_Good(str1);
        }


        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
        String msc = list != null ? "" : "error" ;
        return new Result(list,oh,msc);

    }

    @Override
    public Integer update_Ready_Good(String str) {
        return readyDao.update_Ready_Good(str);
    }
}
