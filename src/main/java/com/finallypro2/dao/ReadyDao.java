package com.finallypro2.dao;

import com.finallypro2.POJO.Bootstrap;
import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.Ready_work;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ReadyDao {

    public List<Ready_work> getAllGoodMes(String part);

    public List<Ready_work> getAllGoodMesWork(String part);

    //用于用户发布指定服务人员订单
    public Integer update_new_ReadyWork(Ready_work ready_work);

    //用于判断订单时间是否过期
    public Integer update_Ready_Good(String str);

    //获取普通用户的ready_work的数量
    public Integer get_WorkReadynum_user(@Param("Anum") String part);

    //获取服务人员的ready_work的数量
    public Integer get_WorkReadynum_work(@Param("Bnum") String part);

    //获取普通用户的ready_work的数据
    public List<Ready_work> get_WorkReady_user(@Param("Anum") String part, Integer number_find);

    //获取服务人员的ready_work的数据
    public List<Ready_work> get_WorkReady_work(@Param("Bnum") String part,Integer number_find);

    //服务人员更新数据去goods_work表
    public Integer updataGoods_work(String part);

    //服务人员更新数据去ready_work表
    public Integer updataReady_work(String part,String state);
}
