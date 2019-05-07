package com.sky.java.preparation.java7Features.message;

public class Message {
    public String welcome(String name){
        String message;
        if(name == null || name.isEmpty()){
            message = "Hello dear";
        }else{
            message = "Hello " + name;
        }
        return message;
    }
}
