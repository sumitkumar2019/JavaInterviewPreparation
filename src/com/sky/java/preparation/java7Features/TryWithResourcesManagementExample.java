package com.sky.java.preparation.java7Features;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesManagementExample {

    //before JDK 7
    private static void tryWithCatchResourceManagement(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("test.txt"));
                String line;
                while((line = br.readLine())!=null){
                    System.out.println(line);
                }
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(br != null)
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
        }
    }

    //In java 7
    private static void tryWithResourcesFeatureResourceMAnagement(){
        try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))){
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //tryWithCatchResourceManagement();
        tryWithResourcesFeatureResourceMAnagement();
    }
}
