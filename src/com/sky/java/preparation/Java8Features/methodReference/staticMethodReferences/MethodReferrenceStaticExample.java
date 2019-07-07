package com.sky.java.preparation.Java8Features.methodReference.staticMethodReferences;

/**
 * ========
 * 3-ways:
 * ========
 * Reference to a static method. | ContainingClass::staticMethodName
 * Reference to an instance method. | containingObject::staticMethodName
 * Reference to a constructor. | ClassName::new
 * */

interface Sayable{
    void say();
}
public class MethodReferrenceStaticExample {
    public static void saySomething(){
        System.out.println("Hello, This is static method");
    }
    public static void main(String[] args) {
        //Referring a static method
        Sayable sayable = MethodReferrenceStaticExample::saySomething;
        sayable.say();
    }
}
