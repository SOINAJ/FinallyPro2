package com.finallypro2.controller.root;


import com.finallypro2.POJO.Notice;
import com.finallypro2.service.NoticeService;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public Result getAll_notice() {
        return noticeService.get_Notice();
    }

    @PostMapping
    public Result insert_new_notice(String notice_title, String notice_content, String notice_time) {
        try {
            String need_time = notice_time.substring(0,notice_time.indexOf("T")) +" "+ notice_time.substring(notice_time.indexOf("T")+1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return noticeService.insert_new_notice(new Notice(simpleDateFormat.parse(need_time), notice_title, notice_content));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
