package com.sky.java.preparation.java7Features;

public class BinaryLiteralsExample {
    public static void main(String[] args) {
        //An 8 bit 'Byte' value
        byte b = (byte)0b00100001;
        System.out.println(b);

        //An 16 bit 'Short' value
        short s = (short) 0b101000010;
        System.out.println(s);

        //An 32 bit 'int' value
        int i = 0b1101;
        System.out.println(i);
        int in =0B101; //small b or caps B: all same
        System.out.println(in);

        //An 64 bit 'long' value
        long l = 0b10100001010001011L;
        System.out.println(l);
    }
}
