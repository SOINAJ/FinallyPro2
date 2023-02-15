package com.finallypro2.util;

import com.finallypro2.POJO.*;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Works_Util {

//    /**
//     * date用于比较时间,用于提前多少进行信息通知
//     * 需要通知返回true
//     *
//     * @param start_date
//     * @return
//     */
//    public static boolean time_Util(Date start_date, int num) {
//        long mylong = 0;
//        switch (num) {
//            case 1:
//                mylong = start_date.getTime() + 1000 * 60;
//                break;
//            case 2:
//                mylong = start_date.getTime() + 1000 * 60 * 60 * 24;
//                break;
//        }
//        Date date = new Date(mylong);
//        int res = new Date().compareTo(start_date);
//        int res1 = new Date().compareTo(date);
//        return (res >= 0 && res1 >= 0) ? true : false;
//    }


    //用于转换前端发布菜单页面的信息，然后进行处理
    public static Goods_work goodUtil(String data) {
        Goods_work goods_work = null;
        try {
            String[] this_data = data.split("&");
            String[] need_data = new String[this_data.length];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            for (int i = 0; i < this_data.length; i++) {
                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
                String str2 = this_data[i].substring(str1.length() + 1);
                need_data[i] = str2;
            }

            long time1 = Long.parseLong(need_data[3]);
            long time2 = Long.parseLong(need_data[4]);
            need_data[3] = simpleDateFormat.format(new Date(time1));
            need_data[4] = simpleDateFormat.format(new Date(time2));

            goods_work = new Goods_work(
                    need_data[0],
                    simpleDateFormat.parse(need_data[3]),
                    simpleDateFormat.parse(need_data[4]),
                    need_data[1],
                    URLDecoder.decode(need_data[2], "utf-8"),
                    Integer.parseInt(need_data[5]));
        } catch (ParseException e) {
            e.getStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.getStackTrace();
        }
        return goods_work;
    }

    public static Ready_work readyUtil(String data) {
        Ready_work ready_work = null;
        try {
            String[] this_data = data.split("&");
            String[] need_data = new String[this_data.length];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            for (int i = 0; i < this_data.length; i++) {
                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
                String str2 = this_data[i].substring(str1.length() + 1);
                need_data[i] = str2;
            }

            long time1 = Long.parseLong(need_data[4]);
            long time2 = Long.parseLong(need_data[5]);
            need_data[4] = simpleDateFormat.format(new Date(time1));
            need_data[5] = simpleDateFormat.format(new Date(time2));

            ready_work = new Ready_work(
                    need_data[1], URLDecoder.decode(need_data[3], "utf-8"),
                    simpleDateFormat.parse(need_data[4]),
                    simpleDateFormat.parse(need_data[5]),
                    need_data[0], need_data[2], need_data[6]);
        } catch (ParseException e) {
            e.getStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.getStackTrace();
        }
        return ready_work;
    }

    public static User_message UserMesUtil(String data) {
        User_message user_message = null;
        try {
            String[] this_data = data.split("&");
            String[] need_data = new String[this_data.length];
            for (int i = 0; i < this_data.length; i++) {
                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
                String str2 = this_data[i].substring(str1.length() + 1);
                need_data[i] = str2;
            }

            user_message = new User_message(need_data[0], need_data[1], need_data[2], URLDecoder.decode(need_data[3], "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.getStackTrace();
        }
        return user_message;
    }

    public static Work_message WorkMesUtil(String data) {
        Work_message work_message = null;
        try {
            String[] this_data = data.split("&");
            String[] need_data = new String[this_data.length];
            for (int i = 0; i < this_data.length; i++) {
                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
                String str2 = this_data[i].substring(str1.length() + 1);
                need_data[i] = str2;
            }

            work_message = new Work_message(need_data[2], need_data[0], need_data[1], URLDecoder.decode(need_data[3], "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.getStackTrace();
        }
        return work_message;
    }

    public static Complain ComplainUtil(String data) {
        Complain complain = null;
        try {
            String[] this_data = data.split("&");
            String[] need_data = new String[this_data.length];
            for (int i = 0; i < this_data.length; i++) {
//                String str1 = this_data[i].substring(0,this_data[i].indexOf("="));
//                String str2 = this_data[i].substring(str1.length()+1);
                String str2 = this_data[i].substring(this_data[i].indexOf("=") + 1);
                need_data[i] = str2;
            }
            complain = new Complain(need_data[0], need_data[1], new Date());
            switch (need_data[2]) {
                case "1":
                    complain.setMessage("服务态度太差");
                    break;
                case "2":
                    complain.setMessage("服务效果太低");
                    break;
                case "3":
                    complain.setMessage("人员消息异常");
                    break;
                case "4":
                    complain.setMessage(URLDecoder.decode(need_data[3], "UTF-8"));
                    break;
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return complain;
    }

    public static String[] root_Return(String data) {
        String[] need_data = new String[2];
        try {
            String[] this_data = data.split("&");
            for (int i = 0; i < this_data.length; i++) {
                String str2 = this_data[i].substring(this_data[i].indexOf("=") + 1);
                need_data[i] = str2;
            }
            need_data[1] = URLDecoder.decode(need_data[1], "UTF-8");
        } catch (Exception e) {
            e.getStackTrace();
        }
        return need_data;
    }
}
