package com.sky.java.preparation;

public class VarArgsExample {
    static int add(int ... i){
        int sum = 0;
        for (int n : i){
            sum = sum+n;
        }
        return sum;
    }
    public static void main(String[] args) {
        int sum = add(1,2,3,4,5,6,7,8);
        System.out.println(sum);
    }
}
