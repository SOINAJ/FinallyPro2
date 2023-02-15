package com.finallypro2.controller.work;

import com.finallypro2.service.U_W_MesService;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/WMes")
public class Work_MesController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    @Qualifier("Wmes")
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

    @PostMapping("/2")
    public Result post_NewMes(MultipartHttpServletRequest file) {
        try {
            FileInputStream inputStream = (FileInputStream) file.getFile("file2").getInputStream();
            Result result = UWMesService.insert_newMes((String) httpSession.getAttribute("part"),"ZG",inputStream);
            inputStream.close();
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public Result post_NewGoods(@RequestBody String data) {
//        System.out.println(data);
        return UWMesService.updata_new_WorkMes(data);
    }

    @GetMapping("/getWmes")
    public Result get_W_Mes() {
        String part = (String)httpSession.getAttribute("part");
        return UWMesService.get_people_Mes(part);
    }
//

//    @GetMapping
//    public Result getWorkMesNum() {
////        String part = (String) httpSession.getAttribute("part");
//        return UWMesService.getWorkMesNum();
//    }
//
//    @GetMapping("/{number}")
//    public Result getWorkMes(@PathVariable String number){
//        return UWMesService.getWorkMes(number);
//    }
}
