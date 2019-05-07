package com.sky.java.preparation.JavaBasicsTill4;
//Question: can we access static variable directly?
public class StaticVariableCheck {

    static int a = 20;

    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
        System.out.println(StaticVariableCheck.a);
    }

}
