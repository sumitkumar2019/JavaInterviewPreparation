package com.sky.java.preparation.java5Features.userinput;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        String str = "";
        Scanner sc = new Scanner(System.in);
        str =sc.nextLine();
        Integer number = sc.nextInt();
        System.out.println(number);
        System.out.println(str);
    }
}
