package com.example.testAndroid;

import java.util.*;

public class Convert {
    Map<String,Map<String,Double>> mapMap = new HashMap<String, Map<String, Double>>();

    Convert()
    {
        Map<String,Double> map = new HashMap<String, Double>();
        map.put("km",1000.0);
        map.put("cm",0.01);

        Map<String,Double> mapMass = new HashMap<String, Double>();
        mapMass.put("pound", .45);
        mapMass.put("tonne", 1000.0);


        Map<String,Double> mapTime = new HashMap<String, Double>();
        mapTime.put("minutes", 60.0);
        mapTime.put("hour", 3600.0);

        mapMap.put("length", map);
        mapMap.put("mass", mapMass);
        mapMap.put("time", mapTime);

    }


    double standardType(String type,String unit)
    {
        return mapMap.get(type).get(unit);
    }
    double convert(String type,String u1,double m1,String u2)
    {
        return (standardType(type,u1)*m1)/standardType(type, u2);
    }
    Set<String> getUnitList(String category)
    {
        return  mapMap.get(category).keySet();

    }
    Set<String> getCategoryList()
    {
        return  mapMap.keySet();
    }



}
