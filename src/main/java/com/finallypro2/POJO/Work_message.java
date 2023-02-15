package com.finallypro2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Work_message {
    private int id;
    private String name;
    private String place;
    private String phone;
    private Integer scope;
    private String part;
    private Integer worknum;
    private String talk;
    private String sfz;
    private String prove;
    private String state;

    public Work_message(String place, String phone, String part, String talk) {
        this.place = place;
        this.phone = phone;
        this.part = part;
        this.talk = talk;
    }
}
