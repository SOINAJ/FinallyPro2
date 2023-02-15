package com.finallypro2.dao;

import com.finallypro2.POJO.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NoticeDao {

    @Select("select * from notice where status = 0")
    public List<Notice> get_Notice();

    @Insert("insert into notice (created,title,content) values (#{created},#{title},#{content})")
    public Integer insert_new_Notice(Notice notice);

    @Update("update notice set status = 1 where id in (${param1})")
    public Integer update_notice(String data);
}
