package com.sky.java.preparation.java5Features.annotations;

import java.lang.annotation.*;

@FunctionalInterface //annotation
interface C{
    void show();  // only one method is allowed
}
@interface Phone{ //marker annotation

}
@interface LocalPhone{ //single value annotation
    String os() default "Symbian";
}

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{ // Multivalued annotation
    String os() default "Android";
    int version() default 1;
}

@Phone
@SmartPhone(os="Iphone", version = 10)
class IphoneSeries{
    String model;
    int size;

    public IphoneSeries(String model, int size){
        this.model = model;
        this.size = size;
    }
}
class A{
    public void showMyDataFromLastYearDatabase(){
        System.out.println("in A");
    }
}
class B extends A{
    @Deprecated //annotation
    public void show(){}

    @Override //annotation
    public void showMyDataFromLastYearDatabase(){
        System.out.println("in B");
    }
}

public class AnnotationExmple {
    public static void main(String[] args) {
        B obj = new B();
        obj.showMyDataFromLastYearDatabase();
        IphoneSeries iphone = new IphoneSeries("10X", 5);

        Class clazz = iphone.getClass();
        Annotation annotation  = clazz.getAnnotation(SmartPhone.class);
        SmartPhone smartPhone = (SmartPhone) annotation;
        System.out.println(smartPhone.os());

    }
}
