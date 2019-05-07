package com.sky.java.preparation.JavaBasicsTill4;

strictfp class NormalCalculation{
    strictfp double calculateMe(){
        double num1 = 10e+102;
        double num2 = 6e+08;
        return num1+num2;
    }

}
public class StrictFpExample {
    public static void main(String[] args) {
        NormalCalculation normalCalculation = new NormalCalculation();
        System.out.println(normalCalculation.calculateMe()); //strictfp:precision should not differ from platform to platform
    }
}
