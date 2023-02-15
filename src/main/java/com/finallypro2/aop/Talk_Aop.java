package com.finallypro2.aop;


import com.finallypro2.POJO.Talk_people;
import com.finallypro2.POJO.User_message;
import com.finallypro2.POJO.Work_message;
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
public class Talk_Aop {

    @Autowired
    private U_W_MesDao UWMesDao;

    @Pointcut("execution(* com.finallypro2.controller.user.User_TalkController.getAll_people(..))")
    private void pf1(){}

    @Pointcut("execution(* com.finallypro2.controller.work.Work_TalkController.getAll_people(..))")
    private void pf2(){}

//    @Around("pf1()")
    public Object around1(ProceedingJoinPoint pjp)throws Throwable{

        System.out.println("around1 before...");
        Result result = (Result) pjp.proceed();


        List<Talk_people> list = (List<Talk_people>) result.getData();
        List<Work_message> work_messages = null;
        Map<String,String> map = new HashMap<>();
        if (list.size()!=0){
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str += "'"+list.get(i).getBpart()+"'";
                str += ",";
            }
            String str1 = "";
            if (!str.equals("")) {
                str1 = str.substring(0, str.length() - 1);
                work_messages = UWMesDao.getWorkMes(str1);
            }

            for (Work_message work_message : work_messages) {
                map.put(work_message.getPart(),work_message.getName());
            }

            for(int i=0;i<list.size();i++){
                list.get(i).setName(map.get(list.get(i).getBpart()));
            }
        }
        System.out.println("around1 after...");
        return result;

    }

//    @Around("pf2()")
    public Object around2(ProceedingJoinPoint pjp)throws Throwable{

        System.out.println("around1 before...");
        Result result = (Result) pjp.proceed();


        List<Talk_people> list = (List<Talk_people>) result.getData();
        List<User_message> user_messages = null;
        Map<String,String> map = new HashMap<>();
        if (list.size()!=0){
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str += "'"+list.get(i).getApart()+"'";
                str += ",";
            }
            String str1 = "";
            if (!str.equals("")) {
                str1 = str.substring(0, str.length() - 1);
                user_messages = UWMesDao.getUserMes(str1);
            }

            for (User_message user_message : user_messages) {
                map.put(user_message.getPart(),user_message.getName());
            }

            for(int i=0;i<list.size();i++){
                list.get(i).setName(map.get(list.get(i).getApart()));
            }
        }
        System.out.println("around1 after...");
        return result;

    }


}
