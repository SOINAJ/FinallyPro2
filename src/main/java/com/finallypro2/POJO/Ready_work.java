package com.finallypro2.POJO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ready_work {
    private Integer id;
    private String place;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date time_start;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date time_end;

    private String Anum;
    private String Bnum;
    private String state;
    private String phone;
    private String market;

    public Ready_work(String place, String message,
                      Date time_start, Date time_end,
                      String anum, String bnum,
                      String market) {
        this.place = place;
        this.message = message;
        this.time_start = time_start;
        this.time_end = time_end;
        Anum = anum;
        Bnum = bnum;
        this.market = market;
    }
}
