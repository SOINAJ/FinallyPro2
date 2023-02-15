package com.finallypro2.dao;

import com.finallypro2.POJO.Talk_people;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TalkDao {
//    public List<Talk_people> getAll_User_people();
//
//    public List<Talk_people> getAll_Work_people();


    /**
     * 获取好友名单
     * @param talk
     * @return
     */
    public List<Talk_people> getAll_talk_people(@Param("talk") Talk_people talk);
}
