package com.finallypro2.POJO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Talk_people {
    private int id;
    private String apart;
    private String bpart;
    private String name;

    public Talk_people(String apart,String bpart) {
        this.apart = apart;
        this.bpart = bpart;
    }

    public Talk_people(int id, String apart, String bpart) {
        this.id = id;
        this.apart = apart;
        this.bpart = bpart;
    }
}
