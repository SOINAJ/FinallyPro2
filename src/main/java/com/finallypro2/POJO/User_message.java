package com.finallypro2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_message {
    private int id;
    private String name;
    private String phone;
    private String part;
    private String place;
    private String talk;
    private String sfz;
    private String state;
    private String sfzMes;

    public User_message(String phone, String part, String place, String talk) {
        this.phone = phone;
        this.part = part;
        this.place = place;
        this.talk = talk;
    }
}
