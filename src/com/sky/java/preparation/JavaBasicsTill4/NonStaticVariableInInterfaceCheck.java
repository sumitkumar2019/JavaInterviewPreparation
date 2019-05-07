package com.sky.java.preparation.JavaBasicsTill4;
//Question: can we declare instance variable inside an Interface?
//Answer: allowed to declare but by default it will be "public static final" only: as compiler adding to it by default
public interface NonStaticVariableInInterfaceCheck {
    int a=10; // by default : public static final int a =10
     public static final int b =10;
    //private static final int c =10;// private Not allowed
    //protected static final int d =10; private Not allowed
}
