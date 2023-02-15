package com.finallypro2.dao;

import com.finallypro2.POJO.Complain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComplainDao {

    public Integer get_Complain_num(String role, String part);

    public List<Complain> get_Conplain_byPart(String role, String part, int num);

    public List<Complain> get_Complain_user(String part, int number);

    public Integer updata_Return_Complain(String mes, int id);

    public Integer updata_Complain_Mes(int number);

    public Complain get_Complain_Mes(int number);

    public String get_root_number();

    public List<Complain> get_root_Complain(int number);

    public Integer post_user_Complain(Complain complain);
}
