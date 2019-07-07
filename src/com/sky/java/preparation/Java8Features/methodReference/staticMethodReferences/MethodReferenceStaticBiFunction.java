package com.sky.java.preparation.Java8Features.methodReference.staticMethodReferences;

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
    static int sum(int x, int y){
        return x+y;
    }
    static float sum(int x, float y){
        return x+y;
    }
    static float sum(float x, float y){
        return x+y;
    }
}
public class MethodReferenceStaticBiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::sum;
        BiFunction<Integer, Float, Float> adder2 = Arithmetic::sum;
        BiFunction<Float, Float, Float> adder3 = Arithmetic::sum;
        int result1 = adder1.apply(10,20);
        float result2 = adder2.apply(10,20.0f);
        float result3 = adder3.apply(10.0f,20.0f);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
