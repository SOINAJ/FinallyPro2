package com.finallypro2.POJO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complain {
    private int id;
    private String user;
    private String work;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;
    private String message;
    private int state;
    private String talk;

    public Complain(String user, String work, Date date) {
        this.user = user;
        this.work = work;
        this.date = date;
    }
}
