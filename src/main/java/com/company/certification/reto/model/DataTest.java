package com.company.certification.reto.model;

import java.util.Map;

public class DataTest {

    private static Map<String, Object> map;

    public static Map<String, Object> getMap() {
        return map;
    }

    public static void setMap(Map<String, Object> map) {
        DataTest.map = map;
    }

    public static String obtain(String dataObtain) {
        return (String) getMap().get(dataObtain);
    }

}
