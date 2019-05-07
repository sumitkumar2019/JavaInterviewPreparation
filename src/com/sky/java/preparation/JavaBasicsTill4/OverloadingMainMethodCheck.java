package com.sky.java.preparation.JavaBasicsTill4;
//Question: can we overload main method?
public class OverloadingMainMethodCheck {
    public static void main(int[] args){
        System.out.println("Hello");
    }
    public static void main(String[] args) {
        System.out.println("He");
        int a[]={10,20};
        //String a[]={"10","20"}; //Stack overflow error
        OverloadingMainMethodCheck.main(a);
    }
}
