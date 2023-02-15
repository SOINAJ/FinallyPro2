package com.finallypro2.aop;


import com.finallypro2.POJO.*;
import com.finallypro2.dao.U_W_MesDao;
import com.finallypro2.util.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
public class Ready_work_Aop {

    @Autowired
    private U_W_MesDao UWMesDao;

    @Pointcut("execution(* com.finallypro2.controller.user.UserReadyGoodsController.getReadyGoods(..))")
    private void pf1(){}

    @Pointcut("execution(* com.finallypro2.controller.work.WorkReadyGoodsController.getReadyGoods(..))")
    private void pf2(){}


    @Around("pf1()")
    public Object around1(ProceedingJoinPoint pjp)throws Throwable{

        System.out.println("around before...");
        Result result = (Result) pjp.proceed();


        List<Ready_work> list = (List<Ready_work>) result.getData();
        List<Work_message> user_messages = null;
        Map<String,String> map = new HashMap<>();

        if (list.size()!=0) {
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str += "'" + list.get(i).getBnum() + "'";
                str += ",";
            }
            String str1 = "";
            if (!str.equals("")) {
                str1 = str.substring(0, str.length() - 1);
                user_messages = UWMesDao.getWorkMes(str1);
            }


            for (Work_message user_message : user_messages) {
                map.put(user_message.getPart(), user_message.getName());
                map.put(user_message.getPart() + "phone", user_message.getPhone());
            }


            for (int i = 0; i < list.size(); i++) {
                list.get(i).setPhone(map.get(list.get(i).getBnum() + "phone"));
                list.get(i).setBnum(map.get(list.get(i).getBnum()));
            }

        }

        System.out.println("around after...");
        return result;

    }


    @Around("pf2()")
    public Object around2(ProceedingJoinPoint pjp)throws Throwable{

        System.out.println("around before...");
        Result result = (Result) pjp.proceed();


        List<Ready_work> list = (List<Ready_work>) result.getData();
        List<User_message> work_messages = null;
        Map<String,String> map = new HashMap<>();

        if (list.size()!=0) {
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str += "'" + list.get(i).getAnum() + "'";
                str += ",";
            }
            String str1 = "";
            if (!str.equals("")) {
                str1 = str.substring(0, str.length() - 1);
                work_messages = UWMesDao.getUserMes(str1);
            }


            for (User_message work_message : work_messages) {
                map.put(work_message.getPart(), work_message.getName());
                map.put(work_message.getPart() + "phone", work_message.getPhone());
            }


            for (int i = 0; i < list.size(); i++) {
                list.get(i).setPhone(map.get(list.get(i).getAnum() + "phone"));
                list.get(i).setAnum(map.get(list.get(i).getAnum()));
            }
        }

        System.out.println("around after...");
        return result;

    }


}
