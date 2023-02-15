package com.finallypro2.service.impt;

import com.baidu.aip.ocr.AipOcr;
import com.finallypro2.POJO.User_message;
import com.finallypro2.POJO.Work_message;
import com.finallypro2.dao.U_W_MesDao;
import com.finallypro2.service.U_W_MesService;
import com.finallypro2.util.Code;
import com.finallypro2.util.MyAipOrc;
import com.finallypro2.util.Result;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "Root")
public class Root_UW_ServiceImpt implements U_W_MesService {

    @Autowired
    private U_W_MesDao mesDao;

    @Override
    public Result pass_U_W(String part) {
        Integer result = mesDao.pass_U_W(part.substring(0, 1), part.substring(1));
        Integer oh = result != null ? Code.UPDATA_OK : Code.UPDATA_ERR;
        String msc = result != null ? "" : "error";
        return new Result(result, oh, msc);
    }

    @Override
    public Result root_U_W_Mes(String data) {
        String part = data.substring(0, 1);
        if (part.equals("U")) {
            User_message messages = mesDao.get_U_mes(data.substring(1));
            Integer oh = messages != null ? Code.GET_OK : Code.GET_ERR;
            String msc = messages != null ? "" : "error";

            AipOcr aipOrc = new MyAipOrc().getAipOcr();
            HashMap<String, String> options = new HashMap<String, String>();
            options.put("detect_direction", "true");
            options.put("probability", "false");


            JSONArray array = (aipOrc.basicGeneralUrl(messages.getSfz(), options)).getJSONArray("words_result");
            JSONObject object = (JSONObject) array.get(7);
            messages.setSfzMes((String) object.get("words"));


            return new Result(messages, oh, msc);
        } else if (part.equals("W")) {
            Work_message messages = mesDao.get_W_mes(data.substring(1));
            Integer oh = messages != null ? Code.GET_OK : Code.GET_ERR;
            String msc = messages != null ? "" : "error";
            return new Result(messages, oh, msc);
        }
        return null;
    }

    @Override
    public Result root_get_U_num(String place) {
        Integer number = mesDao.root_get_UW_num(place);
        Integer oh = number != null ? Code.GET_OK : Code.GET_ERR;
        String msc = number != null ? "" : "error";
        return new Result(number, oh, msc);
//        return null;
    }

    @Override
    public Result root_get_W_num(String place) {
        Integer number = mesDao.root_get_UW_num(place);
        Integer oh = number != null ? Code.GET_OK : Code.GET_ERR;
        String msc = number != null ? "" : "error";
        return new Result(number, oh, msc);
//        return null;
    }

    @Override
    public Result root_get_U_mes(String place, String num) {
        List<User_message> user_messages = mesDao.root_get_U_mes(place, (Integer.parseInt(num) - 1) * 6);
        Integer oh = user_messages != null ? Code.GET_OK : Code.GET_ERR;
        String msc = user_messages != null ? "" : "error";
        return new Result(user_messages, oh, msc);
//        return null;
    }

    @Override
    public Result root_get_W_mes(String place, String num) {
        List<Work_message> work_messages = mesDao.root_get_W_mes(place, (Integer.parseInt(num) - 1) * 6);
        Integer oh = work_messages != null ? Code.GET_OK : Code.GET_ERR;
        String msc = work_messages != null ? "" : "error";
        return new Result(work_messages, oh, msc);
//        return null;
    }

    @Override
    public Result get_Img_sql(String part) {
        return null;
    }

    @Override
    public Result getImg_Url_Bos(String model, String imgName, String part) {
        return null;
    }

    @Override
    public Result insert_newMes(String data, String model, FileInputStream inputStream) {
        return null;
    }

    @Override
    public List<Work_message> getGoodsnum_scope(List<Work_message> list) {
        return null;
    }

    @Override
    public Result updata_new_WorkMes(String data) {
        return null;
    }

    @Override
    public Result updata_new_UserMes(String data) {
        return null;
    }

    @Override
    public Result get_people_Mes(String part) {
        return null;
    }

    @Override
    public Result getWorkMesNum() {
        return null;
    }

    @Override
    public Result getWorkMes(String number) {
        return null;
    }
}
