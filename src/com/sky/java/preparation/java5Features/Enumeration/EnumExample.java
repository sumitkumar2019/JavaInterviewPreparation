package com.sky.java.preparation.java5Features.Enumeration;

enum Person{
    RAKESH,
    SHYAM(10),
    RAM(20);

    int age;

    Person(){
        age = 80;
        System.out.println("Constructor called");
    }
    Person(int age){
        this.age = age;
        System.out.println("Constructor called");
    }
    public int getAge(){
        return age;
    }

}

public class EnumExample {

    enum Mobile{
        APPLE,
        SAMSUNG,
        HTC
    }
    public static void main(String[] args) {
        System.out.println(Mobile.APPLE);
        System.out.println(Mobile.SAMSUNG);
        System.out.println(Mobile.HTC);

        System.out.println(Mobile.APPLE.ordinal());

        System.out.println(Person.RAKESH);
        System.out.println(Person.SHYAM);
        System.out.println(Person.RAM);

        System.out.println(Person.RAKESH.getAge());
        System.out.println(Person.SHYAM.getAge());
        System.out.println(Person.RAM.getAge());

        Mobile m = Mobile.APPLE;
        switch (m){
            case APPLE: System.out.println("Apple is best");
            break;
            case SAMSUNG: System.out.println("Samsung is best");
                break;
            case HTC: System.out.println("HTC is best");
                break;

        }
    }
}
