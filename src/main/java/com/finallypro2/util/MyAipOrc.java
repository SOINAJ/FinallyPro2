package com.finallypro2.util;

import com.baidu.aip.ocr.AipOcr;

public class MyAipOrc {
    public  String APP_ID = "739d63b94c1e468286bc0459851f3841";
    public  String API_KEY = "0i2FubbUzXDEfzEVW3tPytvZ";
    public  String SECRET_KEY = "FYSfwwdWkdT1uKSSw9slRLxcrOfhfkDq";

    public AipOcr getAipOcr(){
        return new AipOcr(APP_ID,API_KEY,SECRET_KEY);
    }
}
