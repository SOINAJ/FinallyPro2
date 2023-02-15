package com.finallypro2.service.impt;

import com.finallypro2.POJO.Complain;
import com.finallypro2.dao.ComplainDao;
import com.finallypro2.service.ComplainService;
import com.finallypro2.util.Code;
import com.finallypro2.util.Result;
import com.finallypro2.util.Works_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainServiceImpt implements ComplainService {

    @Autowired
    private ComplainDao complainDao;

    @Override
    public Result get_Complain_user(String part, String number) {
        List<Complain> userComplain = complainDao.get_Complain_user(part, (Integer.parseInt(number) - 1) * 6);
        Integer oh = userComplain != null ? Code.GET_OK : Code.GET_ERR;
        String msc = userComplain != null ? "" : "error";
        return new Result(userComplain, oh, msc);
    }

    @Override
    public Result post_rootReturn(String data) {
        String[] need_data = Works_Util.root_Return(data);
        Integer myoh = complainDao.updata_Return_Complain(need_data[1], Integer.parseInt(need_data[0]));
        Integer oh = myoh != null ? Code.SAVE_OK : Code.SAVE_ERR;
        String msc = myoh != null ? "" : "error";
        return new Result(need_data, oh, msc);
    }

    @Override
    public Result get_Complain_Mes(String number) {
        Complain complain = complainDao.get_Complain_Mes(Integer.parseInt(number));
        Integer oh = complain != null ? Code.GET_OK : Code.GET_ERR;
        String msc = complain != null ? "" : "error";
        return new Result(complain, oh, msc);
    }

    @Override
    public Result get_root_complain(String number) {
        List<Complain> complains = complainDao.get_root_Complain((Integer.parseInt(number) - 1) * 6);
        String complainNum = complainDao.get_root_number();
        int num = 0;
        if ((Integer.parseInt(complainNum) / 6) == 0) {
            num = 1;
        } else {
            num = Integer.parseInt(complainNum) / 6;
            if ((Integer.parseInt(complainNum) % 6) != 0) {
                num += 1;
            }
        }
        boolean myoh = (complains != null && complainNum != null);
        Integer oh = myoh ? Code.GET_OK : Code.GET_ERR;
        String msc = myoh ? String.valueOf(num) : "error";
        return new Result(complains, oh, msc);
//        return null;
    }

    @Override
    public Result post_user_complain(String data) {
        Complain complain = Works_Util.ComplainUtil(data);
        System.out.println(complain.toString());
        Integer integer = complainDao.post_user_Complain(complain);
        Integer code = integer != 0 ? Code.SAVE_OK : Code.SAVE_ERR;
        String mes = integer != 0 ? "" : "error";
        return new Result(integer, code, mes);
    }
}
