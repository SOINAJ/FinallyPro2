package com.finallypro2.controller.work;


import com.finallypro2.service.TalkService;
import com.finallypro2.util.MyResult;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/workTalks")
public class Work_TalkController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    @Qualifier("Wtalk")
    private TalkService talkService;

    @GetMapping
    public MyResult getAll_people(){
        String part = (String) httpSession.getAttribute("part");
        return talkService.getAll_talk(part);
    }
}
