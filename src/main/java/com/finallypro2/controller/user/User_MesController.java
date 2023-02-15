package com.finallypro2.controller.user;

import com.finallypro2.service.U_W_MesService;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/UMes")
public class User_MesController {

    @Autowired
    private HttpSession httpSession;
    @Autowired
    @Qualifier("Umes")
    private U_W_MesService UWMesService;


    @GetMapping("/url")
    public Result get_img_url() {
        String part = (String) httpSession.getAttribute("part");
        return UWMesService.get_Img_sql(part);
    }


    @PostMapping("/3")
    public Result post_NewMes3(MultipartHttpServletRequest file) {
        try {
            FileInputStream inputStream = (FileInputStream) file.getFile("file1").getInputStream();
            Result result = UWMesService.insert_newMes((String) httpSession.getAttribute("part"),"SFZ",inputStream);
            inputStream.close();
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @PutMapping
    public Result post_NewGoods(@RequestBody String data) {
        return UWMesService.updata_new_UserMes(data);
    }

    @GetMapping("/getUmes")
    public Result get_U_Mes() {
        String part = (String)httpSession.getAttribute("part");
        return UWMesService.get_people_Mes(part);
    }



    @GetMapping
    public Result getWorkMesNum() {
//        String part = (String) httpSession.getAttribute("part");
        return UWMesService.getWorkMesNum();
    }

    @GetMapping("/{number}")
    public Result getWorkMes(@PathVariable String number){
        return UWMesService.getWorkMes(number);
    }



}
