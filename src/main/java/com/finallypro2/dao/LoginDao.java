package com.finallypro2.dao;

import com.finallypro2.POJO.Login_id;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mortbay.log.Log;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginDao {


    public Integer getIdBy_message(Integer role);

    public Integer register_message(Integer role,String name,String place,String phone,String part);

    public Integer register_login(Login_id loginId);

    //登录
    public Login_id loginSystem(String username,String passwd);

    //查看是否存在同名账号
    public Login_id check_account(String username);
}
