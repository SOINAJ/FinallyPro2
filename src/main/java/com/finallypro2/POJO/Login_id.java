package com.finallypro2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login_id {
    private int id;
    private String account;
    private String passwd;
    private String role;
    private String talk;
    private String part;
    private String username;
}
