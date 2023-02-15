package com.finallypro2.service.impt;

import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.Talk_people;
import com.finallypro2.POJO.User_message;
import com.finallypro2.POJO.Work_message;
import com.finallypro2.dao.TalkDao;
import com.finallypro2.dao.U_W_MesDao;
import com.finallypro2.service.TalkService;
import com.finallypro2.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "Utalk")
public class TalkUserServiceImpt implements TalkService {

    @Autowired
    private TalkDao talkDao;

    @Autowired
    private U_W_MesDao uWMesDao;


    @Override
    public MyResult getAll_talk(String part) {
        List<Talk_people> list = talkDao.getAll_talk_people(new Talk_people(part,null));
        User_message user_message = uWMesDao.get_U_mes(part);
        List<Work_message> strs = null;
        String str = "";


        Map<String,Object> map = new HashMap<>();
        List<Mymine> mymineList = new ArrayList<>();
        List<Myfriend> myfriends = new ArrayList<>();
        map.put("mine",new Mymine(user_message.getName(), user_message.getPart(), "online"));
        for (Talk_people people : list) {
            str += "'"+people.getBpart()+"',";
        }

        if (!str.equals(""))
            strs = uWMesDao.getNamefrompart_W(str.substring(0,str.length()-1));

        for (Talk_people people : list) {
            for (Work_message work_message : strs) {
                if (work_message.getPart().equals(people.getBpart())){
                    mymineList.add(new Mymine(work_message.getName(),people.getBpart(),"online"));
//                    strs.remove(work_message);
                }

            }
        }
        myfriends.add(new Myfriend("朋友","1",mymineList));
        map.put("friend",myfriends);




        return new MyResult("0","",map);
    }
}
