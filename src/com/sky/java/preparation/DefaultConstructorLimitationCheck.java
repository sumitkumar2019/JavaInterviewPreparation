package com.sky.java.preparation;

public class DefaultConstructorLimitationCheck {
    DefaultConstructorLimitationCheck(int x){

    }
    public static void main(String[] args) {
        //new DefaultConstructorLimitationCheck(); //cannot be applied
        new DefaultConstructorLimitationCheck(10);//valid
    }
    //DefaultConstructorLimitationCheck(){}
}
