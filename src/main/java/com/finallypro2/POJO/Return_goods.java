package com.finallypro2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Return_goods {
    private int id;
    private String Anum;
    private String Bnum;
    private int good_id;
    private String message;
    private int state;


    public Return_goods(String Anum, String Bnum, int good_id) {
        this.Anum = Anum;
        this.Bnum = Bnum;
        this.good_id = good_id;
    }
}
