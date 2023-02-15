package com.finallypro2.util;

public class IsEmpty {
    public static boolean isEmpty(String str){
        if(str==null||str.trim()==""||str.trim().length()==0){
            return true;
        }
        return false;
    }

}
