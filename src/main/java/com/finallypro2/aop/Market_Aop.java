package com.finallypro2.aop;


import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.User_message;
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
public class Market_Aop {

    @Autowired
    private U_W_MesDao UWMesDao;

    @Pointcut("execution(* com.finallypro2.controller.market.*Controller.getMarket_Goods(..))")
    private void pf1(){}

//    @Pointcut("execution(* com.finallypro2.controller.user.UserGoodsNotController.getWorkGoods(..))")
//    private void pf2(){}

    @Around("pf1()")
    public Object around1(ProceedingJoinPoint pjp)throws Throwable{

        System.out.println("around1 before...");
        Result result = (Result) pjp.proceed();


        List<Goods_work> list = (List<Goods_work>) result.getData();
        List<User_message> work_messages = null;
        Map<String,String> map = new HashMap<>();
//        Map<String,String> map2 = new HashMap<>();
        if (list.size()!=0){
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str += "'"+list.get(i).getAnum()+"'";
                str += ",";
            }
            String str1 = "";
            if (!str.equals("")) {
                str1 = str.substring(0, str.length() - 1);
                work_messages = UWMesDao.getUserMes(str1);
            }


            for (User_message work_message : work_messages) {
                map.put(work_message.getPart(),work_message.getName());
                map.put(work_message.getPart()+"phone", work_message.getPhone());
            }


            for(int i=0;i<list.size();i++){
                list.get(i).setPhone(map.get(list.get(i).getAnum()+"phone"));
                list.get(i).setAnum(map.get(list.get(i).getAnum()));
            }

        }
        System.out.println("around1 after...");
        return result;

    }

//    @Around("pf2()")
//    public Object around2(ProceedingJoinPoint pjp)throws Throwable{
//
//        System.out.println("around2 before...");
//        Result result = (Result) pjp.proceed();
//
//
//        List<Goods_work> list = (List<Goods_work>) result.getData();
//        List<Login_id> login = null;
//        Map<String,String> map = new HashMap<>();;
//
//
//        String str = "";
//        for (int i = 0; i < list.size(); i++) {
//                str += "'"+list.get(i).getBnum()+"'";
//                str += ",";
//        }
//        String str1 = "";
//        if (!str.equals("")) {
//            str1 = str.substring(0, str.length() - 1);
//            login = loginDao.getUsername(str1);
//        }
//
//
//        for (Login_id loginId : login) {
//            map.put(loginId.getPart(),loginId.getUsername());
//        }
//
//
//        for(int i=0;i<list.size();i++){
//            list.get(i).setBnum(map.get(list.get(i).getBnum()));
//        }
//
//
//        System.out.println("around2 after...");
//        return result;
//
//    }


}
