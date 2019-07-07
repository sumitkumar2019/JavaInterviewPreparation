package com.sky.java.preparation.Java8Features.lambda;

//functional style coding & SAM interface(Single Abstract Method)
// Short cut replacement of Anonymous class :  (argument-list) -> {body}
public class LambdaExpressions {
    public static void main(String[] args) {
        int width=10;

        //without lambda, Drawable implementation using anonymous class
        Drawable d=new Drawable(){
            public void draw(){System.out.println("Drawing without lambda"+width);}
        };
        d.draw();

        //same above code with lambda, Drawable implementation using anonymous class
        Drawable d1 = ()->System.out.println("Drawing with lambda"+width);
        d1.draw();

        // lambda with single parameter
        Sayable sayable = name -> "Hello "+ name;
        System.out.println(sayable.say("sumit"));

        // lambda with double parameter
        Rectangle rectangle = (x,y) -> x * y;
        System.out.println("Area of Rectangle:" + rectangle.area(10,20));

        // lambda with multi line code
        Rectangle rectangle1 = (x,y) ->{
            long area = x * y;
            return area;
        };
        System.out.println("Area of Rectangle 1:" + rectangle1.area(30,20));
    }
}

@FunctionalInterface
interface Drawable{
    public void draw();
}

interface Sayable{
    public String say(String name);
}

interface Rectangle{
    public long area(long x, long y);
}

