package com.sky.java.preparation.JavaBasicsTill4;

public final class FinalModifierExample {
    final static int sk = 10;
    public static void main(String[] args) {
        //sk=20; //not allowed as it is final
    }
}

class C {
    final void m1(){}
}

class D extends C{
     //void m1(){}//Final method can't be overridden
}
//class B extends FinalModifierExample{} //not allowed as class is final
