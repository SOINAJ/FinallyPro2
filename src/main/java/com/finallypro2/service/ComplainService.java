package com.finallypro2.service;

import com.finallypro2.POJO.Complain;
import com.finallypro2.util.Result;

public interface ComplainService {
    /**
     * 获取某用户，第某页的投诉信息
     * @param part
     * @param number
     * @return
     */
    public Result get_Complain_user(String part,String number);

    /**
     * 上传投诉反馈去数据库
     * @param data
     * @return
     */
    public Result post_rootReturn(String data);

    /**
     * root权限下获取投诉信息内容
     * @param number
     * @return
     */
    public Result get_Complain_Mes(String number);

    /**
     * root权限下查看投诉列表
     * @return
     */
    public Result get_root_complain(String number);

    /**
     * user权限下发出投诉
     * @return
     */
    public Result post_user_complain(String data);
}
