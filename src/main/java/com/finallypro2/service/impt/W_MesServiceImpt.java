package com.finallypro2.service.impt;

import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.model.PutObjectResponse;
import com.finallypro2.POJO.User_message;
import com.finallypro2.POJO.Work_message;
import com.finallypro2.dao.U_W_MesDao;
import com.finallypro2.service.U_W_MesService;
import com.finallypro2.util.Code;
import com.finallypro2.util.MyBos;
import com.finallypro2.util.Result;
import com.finallypro2.util.Works_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.net.URL;
import java.util.List;

@Service(value = "Wmes")
public class W_MesServiceImpt implements U_W_MesService {

    @Autowired
    private U_W_MesDao uWMesDao;


    @Override
    public Result pass_U_W(String part) {
        return null;
    }

    @Override
    public Result root_U_W_Mes(String data) {
        return null;
    }

    @Override
    public Result root_get_U_num(String place) {
        return null;
    }

    @Override
    public Result root_get_W_num(String place) {
        return null;
    }

    @Override
    public Result root_get_U_mes(String place,String num) {
        return null;
    }

    @Override
    public Result root_get_W_mes(String place,String num) {
        return null;
    }

    @Override
    public Result get_Img_sql(String part) {
        List<Work_message> list = uWMesDao.get_Url_img_Work(part);
        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR;
        String msc = list != null ? "" : "error";
        return new Result(list, oh, msc);
    }

    @Override
    public Result getImg_Url_Bos(String model,String imgName,String part){
//        URL url = new MyBos().getBosClient().generatePresignedUrl("mytest01",part,-1);
//        System.out.println(url.toString());
        String url = "https://mytest01.gz.bcebos.com/"+imgName;
        uWMesDao.updata_Url_Bos_B(model,url+"",part);
        return null;
    }

    @Override
    public Result insert_newMes(String data,String model, FileInputStream fileInputStream) {
        try {
            String mydata = data+model+".jpg";
            PutObjectResponse objectResponse = new MyBos().getBosClient().putObject("mytest01", mydata, fileInputStream);
            System.out.println(objectResponse.getETag());
            getImg_Url_Bos(model,mydata,data);
            Integer oh = objectResponse.getETag() != null ? Code.UPDATA_OK : Code.UPDATA_ERR;
            String msc = objectResponse.getETag() != null ? "" : "error";
            return new Result("图片上传成功", oh, msc);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Work_message> getGoodsnum_scope(List<Work_message> list) {
        return null;
    }

    @Override
    public Result updata_new_WorkMes(String data) {
        Integer num = uWMesDao.updata_new_WorkMes(Works_Util.WorkMesUtil(data));
        Integer number = 0;
        if (num % 6 == 0) {
            number = num / 6;
        } else {
            number = (num / 6) + 1;
        }
        Integer oh = num != null ? Code.GET_OK : Code.GET_ERR;
        String msc = num != null ? "" : "error";
        return new Result(number, oh, msc);
    }

    @Override
    public Result updata_new_UserMes(String data) {
        return null;
    }


    @Override
    public Result get_people_Mes(String part) {
        Work_message work_message = uWMesDao.get_W_mes(part);
        Integer oh = work_message != null ? Code.GET_OK : Code.GET_ERR;
        String msc = work_message != null ? "" : "error";
        return new Result(work_message, oh, msc);
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
