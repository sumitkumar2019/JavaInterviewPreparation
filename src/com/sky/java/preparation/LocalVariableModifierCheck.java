package com.sky.java.preparation;
//Question: can we apply modifiers to Local Variables?
public class LocalVariableModifierCheck {


    static {
        //public int a=10; //not allowed
        //private int a=10; //not allowed
        //protected int a=10; //not allowed
        //static int a=10; //not allowed
        final int a=10; // allowed
    }
    public static void main(String[] args) {
    }

}
