package com.sky.java.preparation.java7Features;

import com.sky.java.preparation.java7Features.message.Message;

public class HandlingMultipleExceptonExample {
    public static void main(String[] args) {
        try{
            Class<?> clazz = Class.forName("com.sky.java.preparation.java7Features.message.Message");
            Object object = clazz.newInstance(); //till java 7 ok in java 9 newInstance() deprecated use getConstructor().newInstance()
            if(object != null){
                Message message = (Message)object;
                String welcome = message.welcome("Sumit");
                System.out.println(welcome);
            }
        }catch(ClassNotFoundException|InstantiationException|IllegalAccessException ex){
            ex.printStackTrace();
        }
    }

}
