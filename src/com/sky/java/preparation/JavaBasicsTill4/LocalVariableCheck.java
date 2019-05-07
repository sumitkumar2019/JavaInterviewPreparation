package com.sky.java.preparation.JavaBasicsTill4;
//Question: local variable and its limitations?
public class LocalVariableCheck {


    static {
         int a;
         //System.out.println(a);//not allowed because not initialized
        a=10;
        System.out.println(a); // allowed initalized
    }
    public static void main(String[] args) {
    }

}
