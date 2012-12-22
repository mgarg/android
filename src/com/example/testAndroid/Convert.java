package com.example.testAndroid;

import java.util.HashMap;
import java.util.Map;

public class Convert {
    Map<String,Map<String,Double>> mapMap = new HashMap<String, Map<String, Double>>();
    void init()
    {
        Map<String,Double> map = new HashMap<String, Double>();
        map.put("km",1000.0);
        map.put("cm",0.01);

        mapMap.put("length",map);
    }
    double standardType(String type,String unit)
    {
        return mapMap.get(type).get(unit);
    }
    double convert(String type,String u1,double m1,String u2)
    {
        return (standardType(type,u1)*m1)/standardType(type, u2);
    }
//    public static void main(String args[])throws Exception
//    {
//        Convert c = new Convert();
//        c.init();
//        System.out.print(c.convert("length","cm",2,"km"));
//    }

}
