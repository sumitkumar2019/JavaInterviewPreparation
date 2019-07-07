package com.sky.java.preparation.Java8Features.lambda;


public class LambdaThread {

    public static void main(String[] args) {
        Thread thread = new Thread(()-> System.out.println(Thread.currentThread().getName()));
        thread.start();
    }
}
