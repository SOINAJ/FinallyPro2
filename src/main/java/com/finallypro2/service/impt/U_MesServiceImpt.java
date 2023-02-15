package com.finallypro2.service.impt;

import com.baidubce.services.bos.model.PutObjectResponse;
import com.finallypro2.POJO.Ready_work;
import com.finallypro2.POJO.User_message;
import com.finallypro2.POJO.Work_message;
import com.finallypro2.controller.TestRedis;
import com.finallypro2.dao.U_W_MesDao;
import com.finallypro2.service.U_W_MesService;
import com.finallypro2.util.Code;
import com.finallypro2.util.MyBos;
import com.finallypro2.util.Result;
import com.finallypro2.util.Works_Util;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.net.URL;
import java.util.List;

@Service(value = "Umes")
public class U_MesServiceImpt implements U_W_MesService {

    @Autowired
    private U_W_MesDao uWMesDao;

    @Autowired
    private TestRedis testRedis;

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
        List<User_message> list = uWMesDao.get_Url_img_User(part);
        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR;
        String msc = list != null ? "" : "error";
        return new Result(list, oh, msc);
    }

    @Override
    public Result getImg_Url_Bos(String model,String imgName,String part){
//        URL url = new MyBos().getBosClient().generatePresignedUrl("mytest01",imgName,-1);
//        System.out.println(url.toString());
        String url = "https://mytest01.gz.bcebos.com/"+imgName;
        uWMesDao.updata_Url_Bos_A(url+"",part);
        return null;
    }

    @Override
    public Result insert_newMes(String data,String model, FileInputStream fileInputStream) {
        try {
            String mydata = data+model+".jpg";
            PutObjectResponse objectResponse = new MyBos().getBosClient().putObject("mytest01", mydata , fileInputStream);
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
        for (int i = 0;i<list.size();i++){
            Integer scope1 = uWMesDao.getGoodsScope(list.get(i).getPart());
            Integer scope2 = uWMesDao.getGoodsScope_null(list.get(i).getPart());
            if(scope2 != null && scope1 !=null){
                list.get(i).setScope(scope1+(scope2*3));
                list.get(i).setWorknum(uWMesDao.getGoodsnum(list.get(i).getPart()));
            }

        }
        return list;
    }

    @Override
    public Result updata_new_WorkMes(String data) {
       return null;
    }

    @Override
    public Result updata_new_UserMes(String data) {
        Integer num = uWMesDao.updata_new_UserMes(Works_Util.UserMesUtil(data));
        Integer number = 0;
        if (num%6 == 0){
            number = num / 6;
        } else {
            number = (num / 6) + 1;
        }
        Integer oh = num != null ? Code.GET_OK : Code.GET_ERR ;
        String msc = num != null ? "" : "error" ;
        return new Result(number,oh,msc);
    }


    @Override
    public Result get_people_Mes(String part) {
        User_message user_message = uWMesDao.get_U_mes(part);
        Integer oh = user_message != null ? Code.GET_OK : Code.GET_ERR ;
        String msc = user_message != null ? "" : "error" ;
        return new Result(user_message,oh,msc);
    }



    @Override
    public Result getWorkMesNum() {
        Integer num = uWMesDao.getWorkMes_num();
        Integer number = 0;
        if (num%6 == 0){
            number = num / 6;
        } else {
            number = (num / 6) + 1;
        }
        Integer oh = num != null ? Code.GET_OK : Code.GET_ERR ;
        String msc = num != null ? "" : "error" ;
        return new Result(number,oh,msc);
    }

    @Override
    public Result getWorkMes(String number) {
//        List<Work_message> list = this.getGoodsnum_scope(uWMesDao.get_Work_Mes((Integer.parseInt(number)-1)*6));

        List<Work_message> list = null;
        if (testRedis.getGood_work((Integer.parseInt(number)-1)*6,"Workman").size() != 0){
            list = testRedis.getWork_message((Integer.parseInt(number)-1)*6,"Workman");
        }else {
            list = this.getGoodsnum_scope(uWMesDao.get_Work_Mes((Integer.parseInt(number)-1)*6));
            testRedis.putWork_message(list , "Workman");
        }

        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR ;
        String msc = list != null ? "" : "error" ;
        return new Result(list,oh,msc);
    }
}
