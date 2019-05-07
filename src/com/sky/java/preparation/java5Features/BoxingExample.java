package com.sky.java.preparation.java5Features;

//What is Boxing in java? //Wrapper classes: Converting primitive data in to Corresponding Wrapper Classes
//byte - Byte
//int - Integer
//float - Float
//double - Double etc. etc
public class BoxingExample {
    public static void main(String[] args) {
        byte b = 10;
        int c = 20;
        Byte bte = Byte.valueOf(b);
        System.out.println(bte);
        Integer no = Integer.valueOf(c);
        System.out.println(no);
    }
}
