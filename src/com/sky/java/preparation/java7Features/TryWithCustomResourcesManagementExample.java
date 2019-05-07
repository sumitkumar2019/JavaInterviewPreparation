package com.sky.java.preparation.java7Features;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MyResource implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("Closing my resources");
        throw new Exception("Exception in Closing");
    }
}

public class TryWithCustomResourcesManagementExample {


    //In java 7
    private static void tryWithResourcesFeatureResourceManagement() throws Exception{
        try(MyResource resource = new MyResource()){
            System.out.println("MyResources created in try-with-resources");
            throw new Exception("Excetion in try");
        }

    }
    public static void main(String[] args) throws Exception{
        tryWithResourcesFeatureResourceManagement();
    }
}
