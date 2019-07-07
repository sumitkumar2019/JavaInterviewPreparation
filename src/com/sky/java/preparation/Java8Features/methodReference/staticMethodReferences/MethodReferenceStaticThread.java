package com.sky.java.preparation.Java8Features.methodReference.staticMethodReferences;

/**
 * ========
 * 3-ways:
 * ========
 * Reference to a static method. | ContainingClass::staticMethodName
 * Reference to an instance method. | containingObject::staticMethodName
 * Reference to a constructor. | ClassName::new
 * */

public class MethodReferenceStaticThread {
    public static void status() {
        System.out.println("Thread running "+ Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        Thread thread = new Thread(MethodReferenceStaticThread::status);
        thread.start();
    }
}
