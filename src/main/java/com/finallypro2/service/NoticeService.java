package com.finallypro2.service;

import com.finallypro2.POJO.Notice;
import com.finallypro2.util.Result;

public interface NoticeService {

    public Result get_Notice();

    public Result insert_new_notice(Notice notice);

    public Result update_notice(String data);
}
