package com.finallypro2.dao;

import com.finallypro2.POJO.Goods_work;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RootGoodsDao {

    /**
     * 删除good表数据
     * @param data
     * @return
     */
    public Integer deldata(String data);

    /**
     * 获取数据个数
     * @return
     */
    public Integer getAll_Goods_num();

    /**
     * 获取数据
     * @param offset
     * @param limit
     * @return
     */
    public List<Goods_work> getAll_Goods_Work(@Param("offset") Integer offset,@Param("limit") Integer limit);
}
