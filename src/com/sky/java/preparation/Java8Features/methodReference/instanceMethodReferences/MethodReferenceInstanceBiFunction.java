package com.sky.java.preparation.Java8Features.methodReference.instanceMethodReferences;

import java.util.function.BiFunction;
/**
 * ========
 * 3-ways:
 * ========
 * Reference to a static method. | ContainingClass::staticMethodName
 * Reference to an instance method. | containingObject::staticMethodName
 * Reference to a constructor. | ClassName::new
 * */

class Arithmetic{
    int sum(int a, int b) {return a+b;}
    float sum(float a, int b) {return a+b;}
    float sum(float a, float b) {return a+b;}

}
public class MethodReferenceInstanceBiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> adder1 = new Arithmetic()::sum;
        BiFunction<Float, Integer, Float> adder2 = new Arithmetic()::sum;
        BiFunction<Float, Float, Float> adder3 = new Arithmetic()::sum;

        int result1 = adder1.apply(10,30);
        float result2 = adder2.apply(10.0f,30);
        float result3 = adder3.apply(10.0f,30.0f);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
