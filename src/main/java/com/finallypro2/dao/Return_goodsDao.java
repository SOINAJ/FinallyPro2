package com.finallypro2.dao;

import com.finallypro2.POJO.Return_goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Return_goodsDao {

    public Integer update_return_W_U_mesage(String role,String date);

    public List<Return_goods> select_message_W_U_mesage(String role,String part);

    @Select("select * from return_goods_w where good_id = #{parma1}")
    public Integer select_return_W(Integer part);

    @Update("update return_goods_w set state = #{param1} where good_id in ( ${param2} )")
    public Integer update_return_W(int state,String date);

    @Select("select * from return_goods where good_id = #{parma1}")
    public Integer select_return(Integer part);

    @Update("update return_goods set state = #{param1} where good_id in ( ${param2} )")
    public Integer update_return(int state,String date);

    public List<Return_goods> select_have_Return(String role, String part);


    @Insert("insert return_goods_w (Bnum,Anum,good_id) values(#{Bnum},#{Anum},#{good_id})")
    public Integer insert_Return_goods_W(Return_goods return_goods);
    @Insert("insert return_goods (Anum,Bnum,good_id) values(#{Anum},#{Bnum},#{good_id})")
    public Integer insert_Return_goods(Return_goods return_goods);
}
