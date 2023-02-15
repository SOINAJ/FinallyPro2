package com.finallypro2.service.impt;


import com.finallypro2.POJO.Notice;
import com.finallypro2.dao.NoticeDao;
import com.finallypro2.service.NoticeService;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import com.finallypro2.util.Works_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpt implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public Result get_Notice() {
        List<Notice> list = noticeDao.get_Notice();
        String str = "";
        for (int i = 0; i < list.size(); ) {
            Date date = list.get(i).getCreated();
            long mylong = date.getTime() + 1000*60*60*24;
            Date date1 = new Date(mylong);
            int res = new Date().compareTo(date);
            int res1 = new Date().compareTo(date1);
            if (res >= 0 && res1 == -1){
                i++;
            }else if (res1 >= 0){
                str += list.get(i).getId()+",";
                i++;
            }
            else {
                list.remove(list.get(i));
            }
        }
        if (!str.equals("")){
            noticeDao.update_notice(str.substring(0,str.length()-1));
        }
        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
        String msc = list != null ? "" : "error" ;
        return new Result(list,oh,msc);
    }

    @Override
    public Result insert_new_notice(Notice notice) {
        Integer list = noticeDao.insert_new_Notice(notice);
        Integer oh = list != null ? Code.SAVE_OK : Code.SAVE_ERR ;
        String msc = list != null ? "" : "error" ;
        return new Result(list,oh,msc);
    }

    @Override
    public Result update_notice(String data) {
        return null;
    }



}
