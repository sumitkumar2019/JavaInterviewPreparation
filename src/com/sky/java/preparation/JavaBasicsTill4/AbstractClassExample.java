package com.sky.java.preparation.JavaBasicsTill4;

//Question: what is abstract class? why a class become abstract?
abstract class  Vehicle {
    void fuel(){
        System.out.println("fuel");
    }
    abstract void ac();
}
class Car extends Vehicle{

    @Override
    void ac() {
        System.out.println("ac");
    }
}
