package com.finallypro2.service.impt;

import com.finallypro2.POJO.Login_id;
import com.finallypro2.dao.LoginDao;
import com.finallypro2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoginServiceImpt implements LoginService {

    @Autowired
    private LoginDao loginDao;


    public Login_id check_account(String username){
        return loginDao.check_account(username);
    }

    @Override
    @Transactional
    public void Register(Login_id loginId, String addre, String phone) throws Exception {
        Integer id = loginDao.getIdBy_message(Integer.valueOf(loginId.getRole()));
        if (loginId.getRole().equals("1"))
            loginId.setPart("A" + (id + 1));
        else
            loginId.setPart("B" + (id + 1));

        Login_id id1 = this.check_account(loginId.getAccount());
//        System.out.println(id1.toString());
        if (id1 != null) {
            throw new Exception("账号已存在");
        }
        else {
            loginDao.register_login(loginId);
            loginDao.register_message(Integer.valueOf(loginId.getRole()), loginId.getUsername(), addre, phone, loginId.getPart());
        }

    }

    @Override
    public Login_id loginSystem(String username, String passwd) {
        return loginDao.loginSystem(username, passwd);
    }
}
