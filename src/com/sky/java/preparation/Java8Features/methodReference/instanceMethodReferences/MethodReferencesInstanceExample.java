package com.sky.java.preparation.Java8Features.methodReference.instanceMethodReferences;

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
class Hello{
    void sayHello(){
        System.out.println("Hello Sumit");
    }
}
public class MethodReferencesInstanceExample {

    public static void main(String[] args) {
        Hello hello = new Hello();
        Sayable sayable = hello::sayHello;
        sayable.say();

        Sayable sayable1 = new Hello()::sayHello;
        sayable1.say();
    }
}
