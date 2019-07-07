package com.sky.java.preparation.Java8Features.methodReference.instanceMethodReferences;

class Hi{
    void sayHi(){
        System.out.println("Hi Sumit: "+ Thread.currentThread().getName());
    }
}
public class MethodReferenceThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Hi()::sayHi);
        thread.start();
    }
}
