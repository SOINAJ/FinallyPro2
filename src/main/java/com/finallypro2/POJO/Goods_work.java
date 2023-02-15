package com.finallypro2.POJO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods_work {
    private int id;
    private String Anum;
    private String Bnum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date time_start;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date time_end;

    private String place;
    private String scope;
    private String Aend;
    private String Bend;
    private String message;
    private Integer market;
    private String phone;
    private String remarks;

    public Goods_work(String anum, Date time_start, Date time_end, String place,String message,Integer market) {
        this.Anum = anum;
        this.time_start = time_start;
        this.time_end = time_end;
        this.place = place;
        this.message = message;
        this.market = market;
    }
}
