package com.finallypro2.aop;

import com.finallypro2.POJO.Complain;
import com.finallypro2.dao.ComplainDao;
import com.finallypro2.util.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Complain_Aop {

    @Autowired
    private ComplainDao complainDao;

    @Pointcut("execution(* com.finallypro2.controller.root.ComplainController.getComplain_Mes(..))")
    public void pf() {
    }


    @Around("pf()")
    public Object around1(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aop start!");
        Result result = (Result) pjp.proceed();
        Complain complain = (Complain) result.getData();
        if (complain == null){
            return result;
        }
        if (complain.getState() == 0) {
            ((Complain) result.getData()).setState(1);
            complainDao.updata_Complain_Mes(complain.getId());
        }
        System.out.println("aop end");
        return result;
    }
}
