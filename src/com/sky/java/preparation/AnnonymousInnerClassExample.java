package com.sky.java.preparation;

//What is annonymous Inner Class?
interface  A{}

public class AnnonymousInnerClassExample {
    public static void main(String[] args) {
        A a = new A() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }
}
