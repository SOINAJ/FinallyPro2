package com.finallypro2.dao;

import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.Talk_people;
import com.finallypro2.util.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {
    public Goods_work get_hava_goods(Integer part);

    public List<Goods_work> getAllGoodMes(String part);
    public List<Goods_work> getAllNotGoodMes(String part);

    public List<Goods_work> getAllGoodMesWork(String part);

    public List<Goods_work> getAllNotGoodMesWork(String part);


    public String getMarketNum(String part,Integer id);
    public Integer insertNewDate(String id);

    public Talk_people getOne_talk_people(String part, String id);

    //服务人员从市场接受订单并在数据库更新
    public Integer put_Goods_Market(String part,Integer number);

    //获取1号市场可查询订单的总页数
    public Integer get_num_Market_1(Integer market_num);

    //查看1号市场的订单
    public  List<Goods_work> get_Goods_Market_1(Integer number,Integer market_num);


    //新增goods_work数据
    public Integer update_new_GoodsWork(Goods_work goods_work);

    //批量更新到时间的数据
    public Integer update_GoodsWork(String str);

    //用于订单申请取消的批量更新数据
    public Integer update_GoodsWork_for_return(String str);


    //普通用户给订单评分
    public Integer put_GoodsScope_user(String scope,String id);

    //获取普通用户goods_work的数量
    public Integer get_WorkGoodsnum_user(@Param("Anum") String part);

    //获取服务人员goods_work的数量
    public Integer get_WorkGoodsnum_work(@Param("Bnum") String part);

    //获取普通用户goods_work的未完成数量
    public Integer get_WorkGoodsnum_userNot(@Param("Anum") String part);

    //获取服务人员goods_work的未完成数量
    public Integer get_WorkGoodsnum_workNot(@Param("Bnum") String part);

    //获取普通用户goods_work的数据
    public List<Goods_work> get_WorkGoods_user(@Param("Anum") String part,Integer number_find);

    //获取普通用户goods_work的未完成数据
    public List<Goods_work> get_WorkGoods_userNot(@Param("Anum") String part,Integer number_find);

    //获取服务人员goods_work的数据
    public List<Goods_work> get_WorkGoods_work(@Param("Bnum") String part,Integer number_find);

    //获取服务人员goods_work的未完成数据
    public List<Goods_work> get_WorkGoods_workNot(@Param("Bnum") String part,Integer number_find);

}
