package com.sky.java.preparation;

public class ChainedExceptionExample {
    static void demoChainedException(){
        // Creating an exception
        NullPointerException ne = new NullPointerException("Top Layer Exception");

        //add a cause
        ne.initCause(new ArithmeticException("cause"));
        throw ne;
    }
    public static void main(String[] args) {
        try{
            demoChainedException();
        }catch (NullPointerException ne){
            //display top level exception
            System.out.println("Caught: "+ne);

            //display the cause exception
            System.out.println("Original Cause: "+ne.getCause());
        }
    }
}
