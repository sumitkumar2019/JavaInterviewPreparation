package com.sky.java.preparation.java7Features;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeInferenceExample {
    public static void main(String[] args) {
        //Before JDK 7
        Map<String, List<String>> myMap = new HashMap<String, List<String>>();// Before jdk 7
        List<String> strings = new ArrayList<String>();
        strings.add("ABC");
        strings.add("CDE");

        myMap.put("A", strings);
        System.out.println(myMap);

        //From JDK 7 - type inference
        Map<String, List<String>> myMap2 = new HashMap<>();
        List<String> strings2 = new ArrayList<>();
        strings2.add("ABC");
        strings2.add("CDE");

        myMap2.put("A", strings);
        System.out.println(myMap2);

        Map<String, List<String>> myMap3 = new HashMap(); // warning unchecked assignment
    }
}
