package com.sky.java.preparation.java7Features;

import java.util.Scanner;

public class SwitchWithStringExample {

    private static String getTypeOfTheDay(String dayOfWeek){
        String typeOfDay;
        switch (dayOfWeek){
            case "Monday":
                typeOfDay = "Start Of the Week";
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                typeOfDay = "Mid Of the Week";
                break;
            case "Friday":
                typeOfDay = "End Of work Week";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay = "WeekEnd";
                break;
             default:
                 throw new IllegalArgumentException("Invalid day of the week: "+ dayOfWeek);

        }
        return typeOfDay;
    }
    public static void main(String[] args) {
        Scanner scanner = null;

        try{
            scanner = new Scanner(System.in);
            System.out.println("Enter name of the day:");
            String dayOfWeek = scanner.next();
            String dayTypeOfWeek = getTypeOfTheDay(dayOfWeek);
            System.out.println(dayTypeOfWeek);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(scanner!=null)
                scanner.close();
        }

    }
}
