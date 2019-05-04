package com.sky.java.preparation.generics;

import java.util.ArrayList;

public class MyCustomList<e> {
    ArrayList<e> list = new ArrayList<>();

    public void addElement(e element){
        list.add(element);
    }
    public String toString(){
        return list.toString();
    }

}
