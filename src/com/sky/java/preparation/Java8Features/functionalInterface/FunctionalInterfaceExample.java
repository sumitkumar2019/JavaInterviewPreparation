package com.sky.java.preparation.Java8Features.functionalInterface;

import java.util.function.Predicate;

/**
 * @FunctionalInterface:
 * As Many As Default and static methods can be defined inside interface and is allowed but inside
 * Functional Interface only one abstract method is allowed.
 * else
 * it will prompt us to remove @FunctionalInterface from the top of the interface
 * Rest all the rules of interface follows
 * if we will remove @Functional interface from the top of the interface and if it has only one
 * abstract method then in that case also it is a qualifying Functional interface without being declared
 *
 * Note: Java 8 lambda expression heavily use Functional interfaces
 * =======================================
 * Predefined Functional Interfaces are:
 * =======================================
 * BiConsumer<T,U>	It represents an operation that accepts two input arguments and returns no result.
 * Consumer<T>	It represents an operation that accepts a single argument and returns no result.
 * Function<T,R>	It represents a function that accepts one argument and returns a result.
 * Predicate<T>	It represents a predicate (boolean-valued function) of one argument.
 * BiFunction<T,U,R>	It represents a function that accepts two arguments and returns a a result.
 * BinaryOperator<T>	It represents an operation upon two operands of the same data type. It returns a result of the same type as the operands.
 * BiPredicate<T,U>	It represents a predicate (boolean-valued function) of two arguments.
 * BooleanSupplier	It represents a supplier of boolean-valued results.
 * DoubleBinaryOperator	It represents an operation upon two double type operands and returns a double type value.
 * DoubleConsumer	It represents an operation that accepts a single double type argument and returns no result.
 * DoubleFunction<R>	It represents a function that accepts a double type argument and produces a result.
 * DoublePredicate	It represents a predicate (boolean-valued function) of one double type argument.
 * DoubleSupplier	It represents a supplier of double type results.
 * DoubleToIntFunction	It represents a function that accepts a double type argument and produces an int type result.
 * DoubleToLongFunction	It represents a function that accepts a double type argument and produces a long type result.
 * DoubleUnaryOperator	It represents an operation on a single double type operand that produces a double type result.
 * IntBinaryOperator	It represents an operation upon two int type operands and returns an int type result.
 * IntConsumer	It represents an operation that accepts a single integer argument and returns no result.
 * IntFunction<R>	It represents a function that accepts an integer argument and returns a result.
 * IntPredicate	It represents a predicate (boolean-valued function) of one integer argument.
 * IntSupplier	It represents a supplier of integer type.
 * IntToDoubleFunction	It represents a function that accepts an integer argument and returns a double.
 * IntToLongFunction	It represents a function that accepts an integer argument and returns a long.
 * IntUnaryOperator	It represents an operation on a single integer operand that produces an integer result.
 * LongBinaryOperator	It represents an operation upon two long type operands and returns a long type result.
 * LongConsumer	It represents an operation that accepts a single long type argument and returns no result.
 * LongFunction<R>	It represents a function that accepts a long type argument and returns a result.
 * LongPredicate	It represents a predicate (boolean-valued function) of one long type argument.
 * LongSupplier	It represents a supplier of long type results.
 * LongToDoubleFunction	It represents a function that accepts a long type argument and returns a result of double type.
 * LongToIntFunction	It represents a function that accepts a long type argument and returns an integer result.
 * LongUnaryOperator	It represents an operation on a single long type operand that returns a long type result.
 * ObjDoubleConsumer<T>	It represents an operation that accepts an object and a double argument, and returns no result.
 * ObjIntConsumer<T>	It represents an operation that accepts an object and an integer argument. It does not return result.
 * ObjLongConsumer<T>	It represents an operation that accepts an object and a long argument, it returns no result.
 * Supplier<T>	It represents a supplier of results.
 * ToDoubleBiFunction<T,U>	It represents a function that accepts two arguments and produces a double type result.
 * ToDoubleFunction<T>	It represents a function that returns a double type result.
 * ToIntBiFunction<T,U>	It represents a function that accepts two arguments and returns an integer.
 * ToIntFunction<T>	It represents a function that returns an integer.
 * ToLongBiFunction<T,U>	It represents a function that accepts two arguments and returns a result of long type.
 * ToLongFunction<T>	It represents a function that returns a result of long type.
 * UnaryOperator<T>	It represents an operation on a single operand that returnsa a result of the same type as its operand.
 * =======================================
 * */

@FunctionalInterface
interface A{
    void A();

    //Object Methods are allowed to be declared inside interface and also inside Functional interfaces
    int hashCode();
    String toString();
    boolean equals(Object obj);

    default void c(){
        System.out.println("C");
    }
    default void d(){
        System.out.println("D");
    }

    static void e(){
        System.out.println("E");
    }

    static void f(){
        System.out.println("F");
    }
}
@FunctionalInterface
interface C extends A{

}

interface D extends A{
    void d(); //not a functional interface anymore
}

class B implements A{

    @Override
    public void A() {
        System.out.println("A");
    }

    static Boolean checkIfNegative(Integer x){
        return (x<0);
    }
}

@FunctionalInterface
interface compare{
    boolean isGreaterThanZero(Integer value);
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        A a = new B();
        a.A();
        A.e();
        A.f();
        a.c();
        a.d();

        //using inbuilt functional interface: Predicate using functional interface
        Predicate<Integer> predicate = value->value>0;
        System.out.println(predicate.test(30));

        //using inbuilt functional interface: Predicate using static method reference
        Predicate<Integer> predicate1 = B::checkIfNegative;
        System.out.println(predicate1.test(-1));

    }
}
