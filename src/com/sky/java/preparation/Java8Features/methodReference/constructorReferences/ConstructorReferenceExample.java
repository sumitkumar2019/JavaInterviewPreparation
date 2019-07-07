package com.sky.java.preparation.Java8Features.methodReference.constructorReferences;

import java.util.stream.Stream;

/**
 * ========
 * 3-ways:
 * ========
 * Reference to a static method. | ContainingClass::staticMethodName
 * Reference to an instance method. | containingObject::staticMethodName
 * Reference to a constructor. | ClassName::new
 * */
interface Cycle{
    void paddling();
}
class Car{
    Car(){
        System.out.println("Driving car");
    }
}
public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Cycle cycle = Car::new;
        cycle.paddling();
    }
}
