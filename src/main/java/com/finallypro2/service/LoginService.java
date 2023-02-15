package com.finallypro2.service;

import com.finallypro2.POJO.Login_id;

public interface LoginService {

    //注册
    public void Register(Login_id loginId,String addre,String phone) throws Exception;

    Login_id loginSystem(String username, String passwd);
}
