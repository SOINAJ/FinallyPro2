package com.finallypro2.service.impt;


import com.baidubce.services.bos.model.DeleteMultipleObjectsRequest;
import com.baidubce.services.bos.model.DeleteMultipleObjectsResponse;
import com.finallypro2.POJO.Complain;

import com.finallypro2.dao.ComplainDao;

import com.finallypro2.dao.U_W_MesDao;

import com.finallypro2.util.Code;
import com.finallypro2.util.MyBos;
import com.finallypro2.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Profile_down_line {
    @Autowired
    private ComplainDao complainDao;

    @Autowired
    private U_W_MesDao uWMesDao;


    public Result delete_work(String part) {
        try {
            boolean mysfz = new MyBos().getBosClient().doesObjectExist("mytest01", part + "SFZ.jpg");
            boolean myzg = new MyBos().getBosClient().doesObjectExist("mytest01", part + "ZG.jpg");
            List<String> objectKeys = new ArrayList<>();
            if (mysfz) objectKeys.add(part + "SFZ.jpg");
            if (myzg) objectKeys.add(part + "ZG.jpg");
            DeleteMultipleObjectsRequest request = new DeleteMultipleObjectsRequest();
            request.setBucketName("mytest01");
            request.setObjectKeys(objectKeys);
            DeleteMultipleObjectsResponse response = new MyBos().getBosClient().deleteMultipleObjects(request);
            System.out.println(response.toString());

            Integer ok = uWMesDao.delete_work_message(part);
            Integer integer = uWMesDao.delete_work_login(part);

            Integer oh = (integer != null && ok != null) ? Code.DELETE_OK : Code.DELETE_ERR;
            String msc = (integer != null && ok != null) ? "" : "error";
            return new Result(integer, oh, msc);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return new Result(0, Code.DELETE_ERR, "");
    }
//        return new Result("20031", 0, "0");

    public List<Integer> get_down_Umes(String part, String role) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(complainDao.get_Complain_num(role, part));
        return list;
    }

    public List<Integer> get_down_Wmes(String part, String role) {
        List<Integer> list = new ArrayList<>();
        Integer scope = uWMesDao.getGoodsScope(part);
        Integer scope_null = uWMesDao.getGoodsScope_null(part);

//        Integer total = (scope == null ? 0 : scope) + (3 * (scope_null == null ? 0 : scope_null));
        list.add(uWMesDao.getGoodsnum(part));
        list.add(scope == null ? 0 : scope);
        list.add(scope_null == null ? 0 : scope_null);
        list.add(complainDao.get_Complain_num(role, part));
        return list;
    }

    public Result get_downMes(String data) {
        List<Integer> list = null;

        switch (data.substring(0, 1)) {
            case "U":
                list = this.get_down_Umes(data.substring(1), data.substring(0, 1));
                break;
            case "W":
                list = this.get_down_Wmes(data.substring(1), data.substring(0, 1));
                break;
        }
        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR;
        String msc = list != null ? "" : "error";
        return new Result(list, oh, msc);
//        return null;
    }

    public Result get_lineMes(String part, String num) {
        List<Complain> list = complainDao.get_Conplain_byPart(part.substring(0, 1), part.substring(1), (Integer.parseInt(num) - 1) * 6);
        Integer oh = list != null ? Code.GET_OK : Code.GET_ERR;
        String msc = list != null ? "" : "error";
        return new Result(list, oh, msc);
//        return null;
    }
}
