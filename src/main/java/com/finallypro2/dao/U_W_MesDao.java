package com.finallypro2.dao;

import com.baidubce.model.User;
import com.finallypro2.POJO.User_message;
import com.finallypro2.POJO.Work_message;
import com.finallypro2.util.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface U_W_MesDao {
    /**
     * 注销工作人员账号全部信息
     * @param part
     * @return
     */
    public Integer delete_work_message(String part);

    /**
     * 注销工作人员账号
     * @param part
     * @return
     */
    public Integer delete_work_login(String part);



    /**
     * 用于通过审核账号信息
     * @param part
     * @return
     */
    public Integer pass_U_W(String path,String part);


    /**
     * root下查看账号个数
     * @param place
     * @return
     */
    public Integer root_get_UW_num(String place);

//    /**
//     * 获取指定账号信息
//     * @param part
//     * @return
//     */
//    public User_message get_U_Mes(String part);
//    public Work_message get_W_Mes(String part);

    /**
     * root下查看俩表信息-列表
     * @param place
     * @param num
     * @return
     */
    public List<User_message> root_get_U_mes(String place,int num);
    public List<Work_message> root_get_W_mes(String place,int num);

    /**
     * 获取账号的图片信息
     * @param part
     * @return
     */
    public List<Work_message> get_Url_img_Work(String part);
    public List<User_message> get_Url_img_User(String part);

    /**
     * 更新用户图片信息，并且上传到数据库
     * @param model
     * @param url
     * @param part
     * @return
     */
    public Integer updata_Url_Bos_B(String model,String url,String part);
    public Integer updata_Url_Bos_A(String url,String part);


    /**
     * 用于AOP，获取俩表用户姓名
     * @param part
     * @return
     */
    public List<Work_message> getNamefrompart_W(String part);
    public List<User_message> getNamefrompart_U(String part);

    /**
     * 获取某服务人员已完成订单个数
     * @param part
     * @return
     */
    public Integer getGoodsnum(String part);

    /**
     * 获取已完成订单且已评分订单总和
     * @param part
     * @return
     */
    public Integer getGoodsScope(String part);

    /**
     * 获取已完成订单且未评分订单总和
     * @param part
     * @return
     */
    public Integer getGoodsScope_null(String part);

    public Integer get_UMesage(@Param("usr") User_message usr);


    /**
     * 获取一个账号信息
     * @param part
     * @return
     */
    public User_message get_U_mes(String part);
    public Work_message get_W_mes(String part);

    /**
     * 更新账号信息
     * @param work_message
     * @return
     */
    public Integer updata_new_WorkMes(Work_message work_message);
    public Integer updata_new_UserMes(User_message user_message);


    //查看work的数量
    public Integer getWorkMes_num();

    public List<Work_message> get_Work_Mes(Integer num);

    //根据账号角色获取用户姓名
    public List<User_message> getUserMes(String part);

    //根据账号角色获取用户姓名
    public List<Work_message> getWorkMes(String part);
}
