package com.finallypro2.service;


import com.finallypro2.POJO.User_message;
import com.finallypro2.POJO.Work_message;
import com.finallypro2.util.Result;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public interface U_W_MesService {

    public Result pass_U_W(String part);

    public Result root_U_W_Mes(String data);

    public Result root_get_U_num(String place);
    public Result root_get_W_num(String place);

    public Result root_get_U_mes(String place,String num);
    public Result root_get_W_mes(String place,String num);


    /**
     * 从数据库获取资料的图片的地址
     * @param part
     * @return
     */
    public Result get_Img_sql(String part);

    /**
     * 获取bos中储存图片的地址并且存于数据库
     * @param model
     * @param imgName
     * @param part
     * @return
     */
    public Result getImg_Url_Bos(String model,String imgName,String part);

    /**
     * 上传新图片去bos中，并且分为不同类型：“SFZ”，“ZG”
     * @param data
     * @param model
     * @param inputStream
     * @return
     */
    public Result insert_newMes(String data,String model , FileInputStream inputStream);

    /**
     * 以A为登入情况下查看B的评分
     * @param list
     * @return
     */
    public List<Work_message> getGoodsnum_scope(List<Work_message> list);

    /**
     * B更新个人信息
     * @param data
     * @return
     */
    public Result updata_new_WorkMes(String data);

    /**
     * A更新个人信息
     * @param data
     * @return
     */
    public Result updata_new_UserMes(String data);

    /**
     * 获取个人信息
     * @param part
     * @return
     */
    public Result get_people_Mes(String part);

    /**
     * 获取B用户的个数
     * @return
     */
    public Result getWorkMesNum();

    /**
     * 存于redis的数据/从redis获取数据
     * @param number
     * @return
     */
    public Result getWorkMes(String number);
}
