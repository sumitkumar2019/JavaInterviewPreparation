package com.sky.java.preparation.generics;

import java.util.ArrayList;

public class MyCustomList2<T extends Number> {
    ArrayList<T> list = new ArrayList<>();

    public void addElement(T element){
        list.add(element);
    }
    public String toString(){
        return list.toString();
    }

}
