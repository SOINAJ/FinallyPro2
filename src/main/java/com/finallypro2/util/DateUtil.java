package com.finallypro2.util;

import com.finallypro2.POJO.Goods_work;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {
    public String  compareToTime(List<Goods_work> list){
        String str = "";
        for (int i = 0;i<list.size();i++) {
            int res = new Date().compareTo(list.get(i).getTime_end());
            if(res == 0 || res == 1){
                str += list.get(i).getId();
                str += ",";
                list.remove(list.get(i));
            }
        }
        return str.substring(0,str.length()-1);
    }
}
