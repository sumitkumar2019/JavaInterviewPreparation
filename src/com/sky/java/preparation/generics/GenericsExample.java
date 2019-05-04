package com.sky.java.preparation.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    //normal
    static <X> X doubleValue(X value){
        return value;
    }
    //extends
    static <X extends List> void duplicate(X list){
        list.addAll(list);
    }

    //wild card : upper bounded
    static double sumOfNumberList(List<? extends Number> numbers){
        double sumOfNumbers = 0.0;
        for (Number number:numbers) {
            sumOfNumbers += number.doubleValue();
        }
        return sumOfNumbers;
    }

    //wild card : lower bounded
    static void addValues(List<? super Number> numbers){
        numbers.add(1);
        numbers.add(1.0);
        numbers.add(1.0f);
        numbers.add(1l);
    }
    public static void main(String[] args) {

        MyCustomList<Integer> integerMyCustomList = new MyCustomList<>();
        integerMyCustomList.addElement(Integer.valueOf(23));
        integerMyCustomList.addElement(Integer.valueOf(24));

        MyCustomList2<Float> floatMyCustomList = new MyCustomList2<>();
        floatMyCustomList.addElement(Float.valueOf(23.0f));
        floatMyCustomList.addElement(Float.valueOf(24));

        MyCustomList<String> stringMyCustomList = new MyCustomList<>();
        stringMyCustomList.addElement("Hello");
        stringMyCustomList.addElement("Hi");

        System.out.println(integerMyCustomList);
        System.out.println(floatMyCustomList);
        System.out.println(stringMyCustomList);

        String value = doubleValue("HiDear");
        Integer number = doubleValue(Integer.valueOf(5));
        ArrayList<String> list = doubleValue(new ArrayList<>(List.of("Hi", "Hello")));

        System.out.println(value);
        System.out.println(number);
        System.out.println(list.toString());

        ArrayList<Integer> numberList = new ArrayList<>(List.of(1,2,3));
        duplicate(numberList);
        System.out.println(numberList.toString());

        System.out.println(sumOfNumberList(List.of(1,2,3,4,5)));
        System.out.println(sumOfNumberList(List.of(1.0,2.3,3.4,4.5,5.6)));
        System.out.println(sumOfNumberList(List.of(1l,2l,3l,4l,5l)));

        ArrayList<Number> listNumbers = new ArrayList<>();
        addValues(listNumbers);
        System.out.println(listNumbers);

    }
}
