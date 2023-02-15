package com.finallypro2.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyResult {
    private String code;
    private String msg;
    private Map<String,Object> data;

}




