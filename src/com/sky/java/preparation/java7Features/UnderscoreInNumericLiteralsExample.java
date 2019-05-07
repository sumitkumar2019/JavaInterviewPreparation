package com.sky.java.preparation.java7Features;

public class UnderscoreInNumericLiteralsExample {
    public static void main(String[] args) {
        //Underscores are allowed between numbers
        long creditCardNumber = 1234_5678_9123_4578L;
        long socialSecurityNumber = 999_999_9999_99L;
        float pi = 3.14_15F;
        long hexWords = 0xCAFE_BABE;
        byte inByte = 0b0010_0101;

        System.out.println(creditCardNumber);
        System.out.println(socialSecurityNumber);
        System.out.println(pi);
        System.out.println(hexWords);
        System.out.println(inByte);

        //long creditCardNumber2 = 1234_5678_9123_4578_L; // not allowed underscore before L
        ///long socialSecurityNumber2 = _999_999_9999_99L; // not allowed underscore in start of number
        //int number = 999_; // not allowed underscore in last of number
        //float pi = 3_.14_15F;// not allowed underscore in before decimal and after decimal
        //float pi2 = 3._14_15F;// not allowed underscore in before decimal and after decimal
    }
}
