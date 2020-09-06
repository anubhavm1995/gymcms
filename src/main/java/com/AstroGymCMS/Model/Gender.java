package com.AstroGymCMS.Model;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
    MALE(1), FEMALE(2);
 
    private int code;
    private static Map<Integer, Gender> genderMap;
 
    Gender(int code) {
        this.code = code;
    }
 
    public int getCode() {
        return code;
    }
 
    public static Gender getGender(int code) {
        if (genderMap == null) {
            genderMap = new HashMap<Integer, Gender>();
            genderMap.put(1, Gender.MALE);
            genderMap.put(2, Gender.FEMALE);
        }
        return genderMap.get(code);
    }
}